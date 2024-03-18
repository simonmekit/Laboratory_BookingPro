package org.simon.laboratory_bookingpro.service;


import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
import org.simon.laboratory_bookingpro.dto.Status;
import org.simon.laboratory_bookingpro.model.User;
import org.simon.laboratory_bookingpro.repository.UserRepository;
import org.simon.laboratory_bookingpro.repositoryservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;



  @Override
  public ResponseEntity<?> createUser(User userToBeSaved) {

    if (isUserAlreadyExist(userToBeSaved)) {
      return ResponseEntity.badRequest().body("User with same detail already exist");
    } else {

      userRepository.save(userToBeSaved);
      return ResponseEntity.ok(userToBeSaved);
    }
  }

  @Override
  public List<User> getAll() {
    return new ArrayList<>(userRepository.findAll());
  }

  @Override
  public ResponseEntity<?> getUserById(long id) {

    if (userRepository.findById(id).isPresent()) {

      User user;
      try {
        user = userRepository.findById(id).get();
      } catch (NoSuchElementException noSuchElementException) {
        return ResponseEntity.notFound().build();
      }

      log.info("user found with id {} {}", id, user);
      return ResponseEntity.ok(user);

    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<?> updateUserById(long id, User userToUpdate) {
    ResponseEntity<?> response = getUserById(id);

    if (response.getBody() != null) {
      User currentUser = (User) response.getBody();
      // The name, phoneNumber, countryCode should not be modified.
      User toSave = User.builder().name(currentUser.getName())
              .email(userToUpdate.getEmail())
              .phoneNumber(currentUser.getPhoneNumber())
              .dob(userToUpdate.getDob())
              .gender(userToUpdate.getGender())
              .status(Status.ACTIVE).build();

      toSave.setId(currentUser.getId());
      userRepository.save(toSave);

      return ResponseEntity.ok(toSave);

    } else {
      return ResponseEntity.notFound().build();
    }
  }

//  @Override
//  public ResponseEntity<?> patchUser(long id, UserPatchRequest changes) {
//
//    User initialUser = (User) getUserById(id).getBody();
//
//    if (initialUser == null) {
//      return ResponseEntity.notFound().build();
//    }
//
//    if (changes.getName() != null) {
//      initialUser.setName(changes.getName());
//    }
//
//    if (changes.getEmailAddress() != null) {
//      initialUser.setEmailAddress(changes.getEmailAddress());
//    }
//
//    if (changes.getProblems() != null) {
//      initialUser.setProblems(changes.getProblems());
//    }
//
//    if (changes.getDob() != null) {
//      initialUser.setDob(changes.getDob());
//    }
//
//    if (changes.getGender() != null) {
//      initialUser.setGender(changes.getGender());
//    }
//
//    if (changes.getMedicalHistory() != null) {
//      initialUser.setMedicalHistory(changes.getMedicalHistory());
//    }
//
//    if (changes.getBloodGroup() != null) {
//      initialUser.setBloodGroup(changes.getBloodGroup());
//    }
//
//    if (changes.getWeight() >= 10 && changes.getWeight() <= 150) {
//      initialUser.setWeight(changes.getWeight());
//    }
//
//    userRepository.save(initialUser);
//
//    return ResponseEntity.ok(initialUser);
//  }

  @Override
  public ResponseEntity<?> deleteUserById(long id) {
    if (userRepository.findById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {

      // NOTE: WE ARE JUST UPDATING STATUS OF ENTITY.
      User userToDelete = (User) getUserById(id).getBody();
      userToDelete.setStatus(Status.INACTIVE);
      userRepository.save(userToDelete);
      return ResponseEntity.ok(userToDelete);
    }
  }

  @Override
  public ResponseEntity<?> restoreUserById(long id) {
    if (userRepository.findById(id).isPresent()) {
      User restoredUser = userRepository.findById(id).get();
      if (restoredUser.getStatus() == Status.ACTIVE)
        return ResponseEntity.badRequest().body("Already Exist");

      restoredUser.setStatus(Status.ACTIVE);
      userRepository.save(restoredUser);
      return ResponseEntity.ok(restoredUser);
    }
    return ResponseEntity.badRequest().body("User not found by given id");
  }

  @Override
  public ResponseEntity<?> findUserByPhone(String phoneNumber) {
    User foundUser = userRepository.findUserByPhoneNumber(phoneNumber);

    if (foundUser != null && foundUser.getStatus().equals(Status.ACTIVE)) {
      log.info("Found User Phone is {} ",
              foundUser.getPhoneNumber());

      return ResponseEntity.ok(foundUser);
    } else {

      log.info("User not found by phone {}", phoneNumber);
      return ResponseEntity.notFound().build();
    }
  }

  private boolean isUserAlreadyExist(User userToSave) {
    List<User> savedUserList = userRepository.findAll();
    for (User u : savedUserList) {
      if (u.getPhoneNumber().equals(userToSave.getPhoneNumber())
    && u.getStatus() == Status.ACTIVE) {
        return true;
      }
    }
    return false;
  }
}
