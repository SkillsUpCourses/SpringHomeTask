/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.springjavaconfig.Config;

import com.stoxa.springjavaconfig.DAO.ContactDAO;
import com.stoxa.springjavaconfig.DAO.ContactSimpleDAO;
import com.stoxa.springjavaconfig.EventListener.ClearEvent;
import com.stoxa.springjavaconfig.EventListener.DeleteContactListener;
import com.stoxa.springjavaconfig.Model.Contact;
import com.stoxa.springjavaconfig.Model.ContactBeanFactory;
import com.stoxa.springjavaconfig.Service.ContactManager;
import com.stoxa.springjavaconfig.Service.ContactService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author Ksu
 */
@Configuration
@PropertySource("classpath:ContactBookMaximumSize.properties")
@PropertySource("classpath:contacts.properties")
public class AppConfig {

    
    @Bean
    public ContactBeanFactory contactBeanFactory() {
        return new ContactBeanFactory();
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
	return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${maxSize}")
    private int maxContactBookSize;

    @Bean
    public ContactDAO dao() throws Exception {
        final ContactSimpleDAO dao = new ContactSimpleDAO();
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contactBeanFactory().getObject());
        contacts.add(contactBeanFactory().getObject());
        contacts.add(contactBeanFactory().getObject());
        contacts.add(contactBeanFactory().getObject());
        contacts.add(contactBeanFactory().getObject());
        dao.setContacts(contacts);
        return dao;
    }

    @Bean(initMethod = "init")
    public ContactService contactService() throws Exception {
        ContactManager contactService = new ContactManager();
        contactService.setDao(dao());
        contactService.setMaxContactBookSize(maxContactBookSize);
        return contactService;
    }

    @Bean
    public ApplicationEventPublisherAware applicationEventPublisherAware() {
        return new ContactManager();
    }

    @Bean
    ApplicationListener<ClearEvent> applicationListener() {
        return new DeleteContactListener();
    }
}
