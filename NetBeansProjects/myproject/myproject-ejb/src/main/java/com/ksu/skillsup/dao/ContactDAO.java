/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksu.skillsup.dao;

import com.ksu.skillsup.entity.MappedContact;
import com.ksu.skillsup.model.Contact;
import java.util.Collection;

/**
 *
 * @author ksu
 */
public interface ContactDAO {
    public void insertContact(MappedContact contact);
    public void updateContact(MappedContact contact);
    public void deleteContact(MappedContact contact);
    public MappedContact selectContact(String phone);
    public MappedContact selectContact(int number);
    public Collection<MappedContact> selectAllContacts();
    void clearAll();
    
}
