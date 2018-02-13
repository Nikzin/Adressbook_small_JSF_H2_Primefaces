package com.nikolay.zinin.jsfaddressbook.repository;


import com.nikolay.zinin.jsfaddressbook.beans.Contact;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class AddressBookData {
    private Map<Integer, Contact> contacts = new HashMap<>();
    private int id = 1;

    public void addContact(Contact contact) {
        contact.setId(id++);
        contacts.put(contact.getId(), contact);
    }

    public List<Contact> getAllContacts() {
        return contacts.values().stream().collect(Collectors.toList());
    }

    public void deleteContact(int id) {
        contacts.remove(id);
    }

    public Contact getContact(int id) {
        return contacts.get(id);
    }

    @PostConstruct
    private void initializeTableData() {
        addContact(new Contact("James", "Bond", "james@bond.com", "00777777777", "Street 7"));
        addContact(new Contact("Bruce", "Lee", "bruce@lee.com", "11111111111", "Street 1"));
        addContact(new Contact("John", "Doe", "john@doe.com", "555555555555", "Street 5"));
        addContact(new Contact("Jane", "Doe", "jane@doe.com", "666666666666", "Street 6"));
    }


}
