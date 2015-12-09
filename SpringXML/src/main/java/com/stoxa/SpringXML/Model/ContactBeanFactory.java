/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.SpringXML.Model;

import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import java.util.Properties;

/**
 *
 * @author ksu
 */
public class ContactBeanFactory extends AbstractFactoryBean {

    @Override
    public Object createInstance() throws Exception {
        Contact newContact = null;
        FileInputStream fis;
        Properties property = new Properties();
        String firstName;
        String lastName;
        String phone;
        String email;
        try {
            fis = new FileInputStream("src/main/resources/contacts.properties");
            property.load(fis);
            for (int i=1;;i++){
                newContact = new Contact();
                firstName = property.getProperty(i + ".firstName");
                newContact.setFirstName(firstName);
                lastName = property.getProperty(i + ".lastName");
                newContact.setLastName(lastName);
                phone = property.getProperty(i + ".phone");
                newContact.setPhone(phone);
                email = property.getProperty(i + ".email");
                newContact.setEmail(email);
            } 
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return newContact;
    }

    @Override
    public Class getObjectType() {
        return Contact.class;
    }
    
}
