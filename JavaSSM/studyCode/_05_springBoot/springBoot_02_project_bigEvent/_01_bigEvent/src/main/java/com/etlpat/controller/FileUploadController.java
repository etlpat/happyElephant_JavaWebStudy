package com.etlpat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/upload")
@ResponseBody// 表示返回json
@Validated// 参数校验注解
public class FileUploadController {


}
