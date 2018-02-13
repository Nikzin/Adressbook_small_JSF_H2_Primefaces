package com.nikolay.zinin.jsfaddressbook.service;

import com.nikolay.zinin.jsfaddressbook.repository.AddressBookData;
import com.nikolay.zinin.jsfaddressbook.beans.Contact;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class AddressBookService {

    @Inject
    private AddressBookData addressBookData;

    public List<Contact> getContacts() {
        return addressBookData.getAllContacts();
    }

    public void addContact(Contact contact) {
        addressBookData.addContact(contact);
    }

    public Contact getContact(int id) {
        return addressBookData.getContact(id);
    }

    public void deleteContact(int id) {
        addressBookData.deleteContact(id);
    }

}
