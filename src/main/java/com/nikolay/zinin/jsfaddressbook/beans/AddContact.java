package com.nikolay.zinin.jsfaddressbook.beans;

import com.nikolay.zinin.jsfaddressbook.beans.Contact;
import com.nikolay.zinin.jsfaddressbook.service.AddressBookService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class AddContact implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Inject
    private AddressBookService contactService;

    public String addContact() {
        Contact contact = new Contact(firstName, lastName, email, phone, address);
        contactService.addContact(contact);
        //
        return "index.xhtml";
    }
}
