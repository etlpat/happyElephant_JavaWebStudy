package com.etlpat.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.InputStream;


// 用于将文件上传到阿里云OSS服务器中
public class AliyunOSSUtil {

    // 设置本用户的AccessKeyID和AccessKeySecret（这是您访问阿里云API的密钥，具有该账户的完全权限）
    private static final String ACCESS_KEY_ID = "LTAI5tQAoUNGMsfmfRagJov9";
    private static final String ACCESS_KEY_SECRET = "VVCnZAypmUCsUDgPuDEy3PysevqRFi";
    // Bucket的Endpoint地域节点的访问端口
    private static final String ENDPOINT = "https://oss-cn-beijing.aliyuncs.com";
    // 填写Bucket名称，例如examplebucket。
    private static final String BUCKET_NAME = "etlpat-big-event";


    // 方法：将指定文件上传到阿里云OSS服务器，返回文件在服务器中的URL
    public static String uploadFileToAliyunOSS(String fileName,// 要上传的文件名
                                               InputStream fileInputStream) {// 要上传文件的输入流

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        String url = "";
        try {
            // (1)创建要上传文件的PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, fileName, fileInputStream);

            // (2)上传文件到阿里云OSS服务器。
            ossClient.putObject(putObjectRequest);

            // (3)获取文件在阿里云OSS服务器中的URL
            //  注意：URL组成固定为:https://Bucket名称.区域节点名/原始文件名
            url = "https://" + BUCKET_NAME + "."
                    + ENDPOINT.substring(ENDPOINT.lastIndexOf("/") + 1)
                    + "/" + fileName;

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());

        } finally {
            // 销毁OSSClient实例
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        return url;
    }

}
