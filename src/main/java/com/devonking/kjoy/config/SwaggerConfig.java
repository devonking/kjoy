package com.devonking.kjoy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API工具的配置类
 *
 * @author Devon King
 * @date 2018/4/27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket config() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.devonking.kjoy.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("")
                .contact(new Contact("Devon King", "http://blog.devon-king.com", "king7jdx@126.com"))
                .build();
    }
}
