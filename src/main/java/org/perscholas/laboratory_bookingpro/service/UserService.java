package org.perscholas.laboratory_bookingpro.service;

import org.perscholas.laboratory_bookingpro.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<?> createUser(User userToSave);

  List<User> getAll();

    ResponseEntity<?> getUserById(long id);

    ResponseEntity<?> updateUserById(long id, User userToUpdate);

    //ResponseEntity<?> patchUser(long id, UserPatchRequest changes);

    ResponseEntity<?> deleteUserById(long id);

    ResponseEntity<?> restoreUserById(long id);

    ResponseEntity<?> findUserByPhone(String phoneNumber);
}
