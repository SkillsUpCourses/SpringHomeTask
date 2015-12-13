/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.springjavaconfig.Model;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stoxa
 */
public class ContactBeanFactoryTest {

    public ContactBeanFactoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getObjectType method, of class ContactBeanFactory.
     */
    @Test
    public void testGetObjectType() {
        System.out.println("getObjectType test");
        ContactBeanFactory instance = new ContactBeanFactory();
        Class expResult = Contact.class;
        Class result = instance.getObjectType();
        assertEquals(expResult, result);
        System.out.println("getObjectType test is passed");
    }

    /**
     * Test of hasNextInstance method, of class ContactBeanFactory.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testHasNextInstance() throws Exception {
        System.out.println("hasNextInstance test");
        ContactBeanFactory instance = new ContactBeanFactory();
        boolean expResult = false;
        boolean result = instance.hasNextInstance();
        assertEquals(expResult, result);
        System.out.println("testHasNextInstance test is passed");
    }

    /**
     * Test of getObject method, of class ContactBeanFactory.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetObject() throws Exception {
        System.out.println("getObject test");
        ContactBeanFactory instance = new ContactBeanFactory();
        Contact expResult = new Contact("Андрей", "Соколов", "+380934567894", "sokolov@yandex.ru");
        Contact result = instance.getObject();
        assertEquals(expResult.toString(), result.toString());
        System.out.println("getObject test is passed");
    }

    /**
     * Test of isSingleton method, of class ContactBeanFactory.
     */
    @Test
    public void testIsSingleton() {
        System.out.println("isSingleton test");
        ContactBeanFactory instance = new ContactBeanFactory();
        boolean expResult = false;
        boolean result = instance.isSingleton();
        assertEquals(expResult, result);
        System.out.println("testIsSingleton test is passed");
    }

}
