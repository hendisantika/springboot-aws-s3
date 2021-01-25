package com.hendisantika.springbootawss3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-aws-s3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/01/21
 * Time: 06.22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class S3FileForm implements Serializable {

    private String fileName;

    private String downloadKey;

    private String[] checkedItems;

    private List<S3File> fileList;

}