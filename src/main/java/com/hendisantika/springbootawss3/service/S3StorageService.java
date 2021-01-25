package com.hendisantika.springbootawss3.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-aws-s3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/01/21
 * Time: 06.24
 */
@Service
public class S3StorageService {

    private final String BUCKET_NAME = "springboot-s3-demo1";

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    @Autowired
    private AmazonS3 amazonS3;
}
