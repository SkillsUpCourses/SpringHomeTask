package com.pb.msg.application.main;

import com.pb.msg.spring.controllers.BrowserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.pb.msg.spring.controllers")
public class Application {

    public static void main(String[] args) {
        BrowserConfig.runBrowser();               
        SpringApplication.run(Application.class,  args);

        

    }
}