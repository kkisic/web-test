package com.github.kkisic.form;

import kotowari.data.Validatable;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class PostForm implements Validatable, Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Object> extentions = new HashMap<>();

    @Override
    public Object getExtension(String name) {
        return extentions.get(name);
    }

    @Override
    public void setExtension(String name, Object extention) {
        extentions.put(name, extention);
    }

    private Integer id;

    @NotBlank
    @Size(max = 16)
    private String author;

    private Date time;

    @NotBlank
    @Pattern(regexp = "^[\u3041-\u3096ー]{5}$")
    private String body0;

    @NotBlank
    @Pattern(regexp = "^[\u3041-\u3096ー]{7}$")
    private String body1;

    @NotBlank
    @Pattern(regexp = "^[\u3041-\u3096ー]{5}$")
    private String body2;
}

