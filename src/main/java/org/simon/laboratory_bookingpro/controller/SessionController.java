package org.simon.laboratory_bookingpro.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @GetMapping("/setSessionAttribute")
    public String setSessionAttribute(HttpSession session) {
        session.setAttribute("user", "Admin");
        return "Session attribute set successfully!";
    }

    @GetMapping("/getSessionAttribute")
    public String getSessionAttribute(HttpSession session) {
        String user = (String) session.getAttribute("user");
        return "Session attribute: " + user;
    }
}
