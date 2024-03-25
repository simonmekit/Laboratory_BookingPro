package org.simon.laboratory_bookingpro.controller;

import lombok.extern.flogger.Flogger;
import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.exception.ProfileNotFoundException;
import org.simon.laboratory_bookingpro.repository.UserRepository;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfile(Model model){

        model.addAttribute("userProfile", new UserDto());

        return "profile";
    }

//    @PostMapping("find_profile")
//    public String updateProfile(@ModelAttribute("userProfile") UserDto currentUser, Model model){
//        UserDto userDto = userService.findUserByEmail(currentUser.getEmail());
//        model.addAttribute("userProfile", userDto);
//        return "update_profile";
//    }

    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("gender") String gender, @RequestParam("dob") LocalDate dateOfBirth, @RequestParam("affiliation") String affiliation, @RequestParam("password") String password, @RequestParam("matchingPassword") String matchingPassword, @RequestParam("action") String action) {
        UserDto userProfile = userService.findUserByEmail(email);
       if (userProfile != null) {
           userProfile.setFirstName(firstName);
           userProfile.setLastName(lastName);
           userProfile.setEmail(email);
           userProfile.setPhoneNumber(phoneNumber);
           userProfile.setGender(gender);
           userProfile.setDob(dateOfBirth);
           userProfile.setAffiliation(affiliation);
           userProfile.setPassword(password);
           userProfile.setMatchingPassword(matchingPassword);

           if ("update".equals(action)) {
               userService.updateUserById(userProfile.getId(), userProfile);
           } else if ("delete".equals(action)) {
               userService.deleteUserById(userProfile.getId());
           }
       }
       else {
           System.out.println(new ProfileNotFoundException("Invalid User email: " + email).getMessage());
       }
        return "redirect:/profile";
    }

}
