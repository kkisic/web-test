package com.github.kkisic.form;

import lombok.Data;

import java.sql.Date;

@Data
public class PostForm {
    private static final long serialVersionUID = 1L;

    // TODO: validation
    private Integer id;
    private String author;
    private Date time;
    private String body0;
    private String body1;
    private String body2;
}
