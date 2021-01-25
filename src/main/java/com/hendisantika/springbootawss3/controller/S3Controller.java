package com.hendisantika.springbootawss3.controller;

import com.hendisantika.springbootawss3.model.S3FileForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @PostMapping(value = "/aws/s3/search")
    public String search(Model model, S3FileForm fileForm) throws IOException {

        S3FileForm s3FileForm = storageService.search(fileForm.getFileName());
        model.addAttribute("s3FileForm", s3FileForm);

        return "/aws/s3/downloadFromS3";
    }
}
