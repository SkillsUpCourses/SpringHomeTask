/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoxa.springjavaconfig.DAO;

import com.stoxa.springjavaconfig.Model.Contact;
import java.util.ArrayList;
import java.util.List;
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
public class ContactSimpleDAOTest {
    
    Contact contact;
    Contact contact2;
    ContactSimpleDAO instance;
    
    public ContactSimpleDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("The class ContactSimpleDAO is testing");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("The testing of class ContactSimpleDAO is finished");
    }
    
    @Before
    public void setUp() {
        contact = new Contact("Оксана", "Рудниченко", "+380937405289", "dn100488rol@gmail.com");
        contact2 = new Contact("Тошик", "Синяев", "+380507464280", "dn091986saa@gmail.com");
        instance = new ContactSimpleDAO();
        instance.setContacts(new ArrayList());
        instance.addContact(contact);
        
    }
   

    /**
     * Test of addContact method, of class ContactSimpleDAO.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact test");
        assertEquals(1, instance.getAllContacts().size());
        System.out.println("addContact test is passed");
    }

    /**
     * Test of updateContact method, of class ContactSimpleDAO.
     */
    @Test
    public void testUpdateContact() {
        System.out.println("updateContact test");
        Contact newContact = new Contact("Оксана", "Синяева", "+380937405289", "dn100488rol@gmail.com");
        instance.updateContact(newContact);
        assertEquals(newContact, instance.getContact("+380937405289"));
        System.out.println("updateContact test is passed");
    }

    /**
     * Test of deleteContact method, of class ContactSimpleDAO.
     */
    @Test
    public void testDeleteContact() {
        System.out.println("deleteContact");
        instance.deleteContact(contact);
        assertEquals(0, instance.getAllContacts().size());
        System.out.println("deleteContact test is passed");
    }

    /**
     * Test of getContact method, of class ContactSimpleDAO.
     */
    @Test
    public void testGetContact_String() {
        System.out.println("getContact test");
        String phone = "+380937405289";
        Contact expResult = contact;
        Contact result = instance.getContact(phone);
        assertEquals(expResult, result);
        System.out.println("getContact test is passed");
    }

    /**
     * Test of getAllContacts method, of class ContactSimpleDAO.
     */
    @Test
    public void testGetAllContacts() {
        System.out.println("getAllContacts test");
        Contact contact2 = new Contact("Тошик", "Синяев", "+380507464280", "dn091986saa@gmail.com");
        instance.addContact(contact2);
        List<Contact> expResult = new ArrayList<>();
        expResult.add(contact);
        expResult.add(contact2);
        List<Contact> result = instance.getAllContacts();
        assertEquals(expResult, result);
        System.out.println("getAllContacts test is passed");
    }

    /**
     * Test of clearAll method, of class ContactSimpleDAO.
     */
    @Test
    public void testClearAll() {
        System.out.println("clearAll");
        Contact contact1 = new Contact("Оксана", "Рудниченко", "+380937405289", "dn100488rol@gmail.com");
        Contact contact2 = new Contact("Тошик", "Синяев", "+380507464280", "dn091986saa@gmail.com");
        ContactSimpleDAO instance = new ContactSimpleDAO();
        instance.setContacts(new ArrayList());
        instance.addContact(contact1);
        instance.addContact(contact2);
        instance.clearAll();
        assertEquals(0, instance.getAllContacts().size());
        System.out.println("clearAll test is passed");
    }

    /**
     * Test of setContacts method, of class ContactSimpleDAO.
     */
    @Test
    public void testSetContacts() {
        System.out.println("setContacts test");
        Contact contact1 = new Contact("Оксана", "Рудниченко", "+380937405289", "dn100488rol@gmail.com");
        Contact contact2 = new Contact("Тошик", "Синяев", "+380507464280", "dn091986saa@gmail.com");
        ContactSimpleDAO instance = new ContactSimpleDAO();
        instance.setContacts(new ArrayList());
        instance.addContact(contact1);
        instance.addContact(contact2);
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        instance.setContacts(contacts);
        assertEquals(contacts, instance.getAllContacts());
        System.out.println("setContacts test is passed");
    }

    /**
     * Test of getContact method, of class ContactSimpleDAO.
     */
    @Test
    public void testGetContact_int() {
        System.out.println("getContact test");
        int number = 0;
        Contact contact1 = new Contact("Оксана", "Рудниченко", "+380937405289", "dn100488rol@gmail.com");
        Contact contact2 = new Contact("Тошик", "Синяев", "+380507464280", "dn091986saa@gmail.com");
        ContactSimpleDAO instance = new ContactSimpleDAO();
        instance.setContacts(new ArrayList());
        instance.addContact(contact1);
        instance.addContact(contact2);
        Contact expResult = contact1;
        Contact result = instance.getContact(number);
        assertEquals(expResult, result);
        System.out.println("getContact test is passed");
    }
    
}
