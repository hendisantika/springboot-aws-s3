package com.hendisantika.springbootawss3.controller;

import com.hendisantika.springbootawss3.model.S3FileForm;
import com.hendisantika.springbootawss3.service.S3StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-aws-s3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/01/21
 * Time: 06.21
 */
@Controller
public class S3Controller {

    @Autowired
    private S3StorageService s3StorageService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/aws/s3/search")
    public String search(Model model, S3FileForm fileForm) throws IOException {

        S3FileForm s3FileForm = s3StorageService.search(fileForm.getFileName());
        model.addAttribute("s3FileForm", s3FileForm);

        return "index";
    }
}
