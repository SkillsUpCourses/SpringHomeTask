/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.springjavaconfig.Service;

import com.stoxa.springjavaconfig.DAO.ContactDAO;
import com.stoxa.springjavaconfig.DAO.ContactSimpleDAO;
import com.stoxa.springjavaconfig.Model.Contact;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

/**
 *
 * @author stoxa
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactManagerTest {
    
    private ContactDAO dao;
    
    public ContactManagerTest() {
        dao = mock(ContactSimpleDAO.class);
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
     * Test of setApplicationEventPublisher method, of class ContactManager.
     */
    @Test
    public void testSetApplicationEventPublisher() {
        System.out.println("setApplicationEventPublisher");
        ApplicationEventPublisher publisher = null ;
        ContactManager instance = new ContactManager();
        instance.setApplicationEventPublisher(publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class ContactManager.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        ContactManager instance = new ContactManager();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addContact method, of class ContactManager.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        Contact contact = new Contact("Оксана", "Рудниченко", "+380937405289", "dn100488rol@gmail.com");
        ContactManager instance = new ContactManager();
        instance.addContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateContact method, of class ContactManager.
     */
    @Test
    public void testUpdateContact() {
        System.out.println("updateContact");
        Contact contact = null;
        ContactManager instance = new ContactManager();
        instance.updateContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteContact method, of class ContactManager.
     */
    @Test
    public void testDeleteContact() {
        System.out.println("deleteContact");
        Contact contact = null;
        ContactManager instance = new ContactManager();
        instance.deleteContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class ContactManager.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        String phone = "";
        ContactManager instance = new ContactManager();
        Contact expResult = null;
        Contact result = instance.getContact(phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllContacts method, of class ContactManager.
     */
    @Test
    public void testGetAllContacts() {
        System.out.println("getAllContacts");
        ContactManager instance = new ContactManager();
        List<Contact> expResult = null;
        List<Contact> result = instance.getAllContacts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearAll method, of class ContactManager.
     */
    @Test
    public void testClearAll() {
        System.out.println("clearAll");
        ContactManager instance = new ContactManager();
        instance.clearAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class ContactManager.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ContactManager instance = new ContactManager();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dao method, of class ContactManager.
     */
    @Test
    public void testDao() {
        System.out.println("dao");
        ContactManager instance = new ContactManager();
        ContactDAO expResult = null;
        ContactDAO result = instance.dao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDao method, of class ContactManager.
     */
    @Test
    public void testSetDao() {
        System.out.println("setDao");
        ContactDAO dao = null;
        ContactManager instance = new ContactManager();
        instance.setDao(dao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxContactBookSize method, of class ContactManager.
     */
    @Test
    public void testGetMaxContactBookSize() {
        System.out.println("getMaxContactBookSize");
        ContactManager instance = new ContactManager();
        int expResult = 0;
        int result = instance.getMaxContactBookSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxContactBookSize method, of class ContactManager.
     */
    @Test
    public void testSetMaxContactBookSize() {
        System.out.println("setMaxContactBookSize");
        int maxContactBookSize = 0;
        ContactManager instance = new ContactManager();
        instance.setMaxContactBookSize(maxContactBookSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
