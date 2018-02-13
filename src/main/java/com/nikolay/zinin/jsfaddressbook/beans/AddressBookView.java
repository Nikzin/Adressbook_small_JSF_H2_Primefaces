package com.nikolay.zinin.jsfaddressbook.beans;

import com.nikolay.zinin.jsfaddressbook.beans.Contact;
import com.nikolay.zinin.jsfaddressbook.service.AddressBookService;

import org.primefaces.event.RowEditEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AddressBookView implements Serializable {

    private List<Contact> contacts;
    private List<Contact> filteredContacts;

    @Inject
    private AddressBookService service;

    @PostConstruct
    private void init() {
        contacts = service.getContacts();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Contact> getFilteredContacts() {
        return filteredContacts;
    }

    public void setFilteredContacts(List<Contact> filteredContacts) {
        this.filteredContacts = filteredContacts;
    }

    public void delete(Contact contact) {
        if (contact != null) {
            if (filteredContacts != null) {
                filteredContacts.remove(contact);
            }
            contacts.remove(contact);
            service.deleteContact(contact.getId());
        }
    }

    public void editRow(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Changing done", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void cancelEditRow(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Changing canceled", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
