package cn.chenfyuan.oss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置swagger2
 *
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.config
 * @date 2018/3/1
 */
@EnableSwagger2
@Configuration
public class Swagger2Configuration {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.chenfyuan.oss.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2 UI构建API文档")
                .description("oss项目业务api文档")
                .contact("linweijian")
                .version("1.0")
                .build();
    }

}
