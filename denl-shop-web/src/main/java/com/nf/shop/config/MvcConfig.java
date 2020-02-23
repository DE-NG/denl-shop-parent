package com.nf.shop.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.nf.shop.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/6 8:37
 */

@Configuration
@EnableWebMvc
@ComponentScan({"com.nf.shop.controller","com.nf.shop.interceptor"})
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resourceViewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        return resourceViewResolver;
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DateFormatter("yyyy-mm-dd"));
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new FirstInterceptor());
        interceptorRegistration.addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration resourceHandlerRegistration = registry.addResourceHandler("/static/**");
        resourceHandlerRegistration.addResourceLocations("classpath:/static/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List list = new ArrayList();
        list.add("application/json;charset=utf-8");
        fastJsonHttpMessageConverter.setSupportedMediaTypes(list);
    }

//    @Bean
//    public MultipartResolver multipartResolver(){
//        return new StandardServletMultipartResolver();
//    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(10000000);
        //commonsMultipartResolver.setUploadTempDir("classpath:/temporary/");
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }

}
