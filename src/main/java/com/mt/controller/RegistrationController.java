package com.mt.controller;

import com.mt.model.Registration;
import com.mt.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/register")
    public String register(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email
            // Other form fields
    ) {
        Registration registration = new Registration();
        registration.setFirstname(firstname);
        registration.setLastname(lastname);
        registration.setEmail(email);
        // Set other fields

        registrationRepository.save(registration);

        return "redirect:/registration.html"; // Redirect back to registration page
    }
}
