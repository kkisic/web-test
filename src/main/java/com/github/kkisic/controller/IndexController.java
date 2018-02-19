package com.github.kkisic.controller;

import enkan.data.HttpResponse;
import enkan.util.HttpResponseUtils;

import java.io.File;

public class IndexController {

    public HttpResponse index(){
        HttpResponse res = HttpResponseUtils.redirect("assets/index.html", HttpResponseUtils.RedirectStatusCode.FOUND);
        return res;
    }
}
