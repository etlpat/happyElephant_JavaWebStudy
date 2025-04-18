package com.etlpat.controller;

import com.etlpat.pojo.Result;
import com.etlpat.utils.AliyunOSSUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;


//  MultipartFile类型
//
//  功能：使用MultipartFile接收前端传来的文件。
//  方法：
//      ①String getOriginalFilename();  //获取原始文件名
//      ②void transferTo(File dest);    //将接收的文件转存到磁盘文件中
//      ③long getSize();    //获取文件的大小,单位:字节
//      ④byte[] getBytes(); //获取文件内容的字节数组
//      ⑤InputStream getInputStream();  //获取接收到的文件内容的输入流
//


// FileUploadController -- 将前端传来的图片，上传到阿里云的服务器
@Controller
@RequestMapping("/upload")
@ResponseBody// 表示返回json
public class FileUploadController {


    // 方法：接收前端传来的图片，上传到阿里云的服务器，返回图片在阿里云服务器中的URL
    @PostMapping
    public Result<String> upload(MultipartFile file) throws Exception {
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件输入流
        InputStream inputStream = file.getInputStream();

        // 创建唯一的文件名（为保证文件名唯一，将UUID与文件名后缀拼接）
        String fileName = UUID.randomUUID().toString()
                + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 调用阿里云OSS的工具类，将图片上传到阿里云服务器中
        String url = AliyunOSSUtil.uploadFileToAliyunOSS(fileName, inputStream);

        // 返回该图片在服务器中的url
        return Result.success(url);
    }

}
