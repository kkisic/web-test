package com.github.kkisic.controller;

import com.github.kkisic.dao.PostDao;
import com.github.kkisic.entity.Post;
import com.github.kkisic.form.PostForm;

import enkan.component.BeansConverter;
import enkan.component.doma2.DomaProvider;
import enkan.data.HttpResponse;
import enkan.util.HttpResponseUtils;
import kotowari.component.TemplateEngine;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.sql.Date;
import java.util.List;

public class ContentController {
    @Inject
    private TemplateEngine templateEngine;

    @Inject
    private BeansConverter beansConverter;

    @Inject
    private DomaProvider daoProvider;

    private PostDao postDao;

    @PostConstruct
    public void init() {
        postDao = daoProvider.getDao(PostDao.class);
    }

    public HttpResponse get(){
        List<Post> postList = postDao.selectAll();
        return templateEngine.render("content", "postList", postList);
    }

    public HttpResponse post(PostForm postForm){
        // TODO: do validation
        postForm.setTime(new Date(System.currentTimeMillis()));

        Post post = beansConverter.createFrom(postForm, Post.class);
        postDao.insert(post);

        HttpResponse res = HttpResponseUtils.redirect(
                "/content",
                HttpResponseUtils.RedirectStatusCode.FOUND);
        return res;
    }
}
