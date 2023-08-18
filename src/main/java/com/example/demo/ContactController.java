package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "index";
    }

    @PostMapping("/submit")
    public String submitContactForm(@ModelAttribute ContactForm contactForm) {
        contactService.saveContactForm(contactForm);
        return "redirect:/contact?success";
    }
    @GetMapping("/display")
    public String displayContacts(Model model) {
        List<ContactForm> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "display";
    }
}
