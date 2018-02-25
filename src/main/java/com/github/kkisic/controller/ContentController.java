package com.github.kkisic.controller;

import com.github.kkisic.dao.PostDao;
import com.github.kkisic.entity.Post;
import com.github.kkisic.form.PostForm;

import enkan.component.BeansConverter;
import enkan.component.doma2.DomaProvider;
import enkan.data.HttpResponse;
import enkan.util.HttpResponseUtils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.sql.Date;

public class ContentController {

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
        HttpResponse res = HttpResponseUtils.redirect(
                "assets/content.html",
                HttpResponseUtils.RedirectStatusCode.FOUND);
        return res;
    }

    public HttpResponse post(PostForm postForm){
        // TODO: do validation
        postForm.setTime(new Date(System.currentTimeMillis()));

        Post post = beansConverter.createFrom(postForm, Post.class);
        postDao.insert(post);

        HttpResponse res = HttpResponseUtils.redirect(
                "assets/content.html",
                HttpResponseUtils.RedirectStatusCode.FOUND);
        return res;
    }
}
