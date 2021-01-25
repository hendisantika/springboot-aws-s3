package com.hendisantika.springbootawss3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.hendisantika.springbootawss3.model.S3File;
import com.hendisantika.springbootawss3.model.S3FileForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Resource search
     *
     * @param fileName
     */
    public S3FileForm search(String fileName) {

        // Screen display form
        S3FileForm s3FileForm = new S3FileForm();

        Resource[] resources = null;
        try {
            // Specify the Ant pattern (s3: //cinpo/**/*test.*) and get the target list.
            resources = this.resourcePatternResolver.getResources("s3: //" + BUCKET_NAME + "/ ** / *" + fileName + "." +
                    " *");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<S3File> s3FileList = new ArrayList<S3File>();

        // Get S3Object for each resource.
        for (Resource resource : resources) {
            S3Object s3Object = amazonS3.getObject(new GetObjectRequest("S3.Cinpo", resource.getFilename()));

            S3File s3File = new S3File();
            s3File.setBucketName(s3Object.getBucketName());
            s3File.setKey(s3Object.getKey());
            s3File.setContentType(s3Object.getObjectMetadata().getContentType());
            s3File.setLastModifiedDate(s3Object.getObjectMetadata().getLastModified());

            s3FileList.add(s3File);
        }
        s3FileForm.setFileList(s3FileList);

        return s3FileForm;
    }
}
