/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksu.skillsup.configs;

import com.ksu.skillsup.eventlistener.ClearEvent;
import com.ksu.skillsup.eventlistener.DeleteContactListener;
import com.ksu.skillsup.factory.ContactBeanFactory;
import com.ksu.skillsup.service.Impl.ContactManager;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ksu
 */

@Configuration
@ComponentScan({
    "com.ksu.skillsup.factory", 
    "com.ksu.skillsup.configs",
})
@EnableTransactionManagement
@PropertySource({"classpath:ContactBookMaximumSize.properties","classpath:contacts.properties"})
@Import({MvcConfig.class,JPAConfig.class,ServiceConfig.class})
public class AppConfig {
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
	return new PropertySourcesPlaceholderConfigurer();
    }


}
