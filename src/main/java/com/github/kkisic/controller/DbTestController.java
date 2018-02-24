package com.github.kkisic.controller;

import com.github.kkisic.dao.PostDao;
import com.github.kkisic.entity.Post;

import enkan.component.doma2.DomaProvider;
import enkan.data.HttpResponse;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.sql.Date;
import java.util.List;

public class DbTestController {

    @Inject
    private DomaProvider daoProvider;

    private PostDao postDao;

    @PostConstruct
    public void init() {
        postDao = daoProvider.getDao(PostDao.class);

        Post samplePost = new Post();
        samplePost.id = 0;
        samplePost.author = "hoge";
        samplePost.time = Date.valueOf("2018-02-25");
        samplePost.body0 = "あいうえお";
        samplePost.body1 = "みぎからよむと";
        samplePost.body2 = "おえういあ";
        postDao.insert(samplePost);
    }

    public HttpResponse index() {
        List<Post> postList = postDao.selectAll();
        String body = "there is " + postList.size() + " recodes\n";
        for(Post p : postList) {
            body += p;
            body += "\n";
        }
        HttpResponse res = HttpResponse.of(body);
        res.setContentType("text/plain");
        return res;
    }
}
