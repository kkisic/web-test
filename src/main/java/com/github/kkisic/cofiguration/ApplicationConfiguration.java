package com.github.kkisic.cofiguration;

import com.github.kkisic.controller.ContentController;
import com.github.kkisic.controller.DbTestController;
import enkan.Application;
import enkan.application.WebApplication;
import enkan.endpoint.ResourceEndpoint;
import enkan.middleware.*;
import enkan.middleware.devel.HttpStatusCatMiddleware;
import enkan.middleware.devel.StacktraceMiddleware;
import enkan.middleware.devel.TraceWebMiddleware;
import enkan.middleware.doma2.DomaTransactionMiddleware;
import enkan.system.inject.ComponentInjector;
import kotowari.middleware.*;
import kotowari.middleware.serdes.ToStringBodyWriter;
import kotowari.routing.Routes;

import com.github.kkisic.controller.IndexController;

import static enkan.util.Predicates.NONE;
import static enkan.util.Predicates.envIn;

import static enkan.util.BeanBuilder.builder;

public class ApplicationConfiguration implements enkan.config.ApplicationFactory{
    @Override
    public Application create(ComponentInjector injector){
        WebApplication app = new WebApplication();

        Routes routes = Routes.define(r -> {
            r.get("/").to(IndexController.class, "index");
            r.get("/dbtest").to(DbTestController.class, "index");

            r.get("/content").to(ContentController.class, "get");
            r.post("/content").to(ContentController.class, "post");
        }).compile();

        app.use(new DefaultCharsetMiddleware());
        app.use(NONE, new ServiceUnavailableMiddleware(new ResourceEndpoint("/public/html/503.html")));

        app.use(envIn("development"), new StacktraceMiddleware());
        app.use(envIn("development"), new TraceWebMiddleware());

        app.use(new TraceMiddleware());
        app.use(new ContentTypeMiddleware());
        app.use(envIn("development"), new HttpStatusCatMiddleware());
        app.use(new ParamsMiddleware());
        app.use(new MultipartParamsMiddleware());
        app.use(new MethodOverrideMiddleware());
        app.use(new NormalizationMiddleware());
        app.use(new NestedParamsMiddleware());
        app.use(new CookiesMiddleware());
        app.use(new SessionMiddleware());
        app.use(new ContentNegotiationMiddleware());

        app.use(new ResourceMiddleware());
        app.use(new RenderTemplateMiddleware());
        app.use(new RoutingMiddleware(routes));
        app.use(new DomaTransactionMiddleware());
        app.use(new FormMiddleware());
        app.use(builder(new SerDesMiddleware()).set(SerDesMiddleware::setBodyWriters, new ToStringBodyWriter()).build());
        app.use(new ValidateBodyMiddleware<>());
        app.use(new ControllerInvokerMiddleware(injector));

        return app;

    }
}
