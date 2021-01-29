package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * // config by this but  not work
 *
 * xml will work
 *
 *  path controller here{@link Swagger2Controller }
 *  handler mapping here{@link Swagger2DocumentationConfiguration }
 */
//@Component
public class InterceptorConfig implements WebMvcConfigurer {

  @Autowired
  SwaggerInterceptor swaggerInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    MappedInterceptor mappedInterceptor = new MappedInterceptor(new String[]{"/v2/api-docs"},
        swaggerInterceptor);
    registry.addInterceptor(mappedInterceptor);
  }
}