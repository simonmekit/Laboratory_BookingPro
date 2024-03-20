package org.simon.laboratory_bookingpro.repositoryservice;

import org.simon.laboratory_bookingpro.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<?> createUser(UserDto userDtoToSave);

  List<UserDto> getAll();

    ResponseEntity<?> getUserById(long id);

    ResponseEntity<?> updateUserById(long id, UserDto userDtoToUpdate);

    //ResponseEntity<?> patchUser(long id, UserPatchRequest changes);

    ResponseEntity<?> deleteUserById(long id);

     ResponseEntity<?> findUserByPhone(String phoneNumber);
}
