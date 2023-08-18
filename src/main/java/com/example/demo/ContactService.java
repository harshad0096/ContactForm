package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void saveContactForm(ContactForm contactForm) {
    	ContactForm contact = new ContactForm();
        contact.setName(contactForm.getName());
        contact.setEmail(contactForm.getEmail());
        contact.setMessage(contactForm.getMessage());
        contactRepository.save(contact);
    }


    public List<ContactForm> getAllContacts() {
        return contactRepository.findAll();
    }

}
