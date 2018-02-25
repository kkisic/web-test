package com.github.kkisic.controller;

import enkan.data.HttpResponse;
import enkan.util.HttpResponseUtils;
import kotowari.component.TemplateEngine;

import javax.inject.Inject;
import java.io.File;

public class IndexController {
    @Inject
    private TemplateEngine templateEngine;

    public HttpResponse index(){
        return templateEngine.render("index");
    }
}
