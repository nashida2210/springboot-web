package com.websystique.springboot;

import com.websystique.micro.service.account.DataBaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;

@EnableAutoConfiguration
@Bean
public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeClientInfo(true);
    loggingFilter.setIncludeQueryString(true);
    loggingFilter.setIncludePayload(true);
    loggingFilter.setMaxPayloadLength(64000);
    return loggingFilter;
}
@ComponentScans(
        {
                @ComponentScan(value = "com.websystique.springboot"),
                @ComponentScan(value = "com.websystique.micro.service.account")
        })
@EntityScan(basePackages = "com.websystique.micro.service.account.domain")
//@SpringBootApplication(scanBasePackages={"com.websystique.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@Import({
        DataBaseConfiguration.class
})
public class SpringBootStandAloneApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStandAloneApp.class, args);
    }
}
