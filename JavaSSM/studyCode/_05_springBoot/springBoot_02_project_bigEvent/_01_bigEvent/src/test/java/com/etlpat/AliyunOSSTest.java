package com.etlpat;

import com.aliyun.oss.*;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.FileInputStream;


// AliyunOSSTest：用于测试阿里云的OSS对象存储服务
// （可将文件上传到阿里云服务器中）
public class AliyunOSSTest {

    public static void main(String[] args) throws Exception {

        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 设置本用户的AccessKeyID和AccessKeySecret（这是您访问阿里云API的密钥，具有该账户的完全权限）
        String ACCESS_KEY_ID = "LTAI5tQAoUNGMsfmfRagJov9";
        String ACCESS_KEY_SECRET = "VVCnZAypmUCsUDgPuDEy3PysevqRFi";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "etlpat-big-event";


        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "xxx.txt";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。（如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件）
        String filePath = "D:\\" + objectName;


        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, ACCESS_KEY_ID, ACCESS_KEY_SECRET);


        try {
            // 创建要上传文件的PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new FileInputStream(filePath));

            // 上传文件到阿里云OSS服务器。
            PutObjectResult result = ossClient.putObject(putObjectRequest);

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
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
