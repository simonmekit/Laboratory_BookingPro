package org.simon.laboratory_bookingpro.service;


import lombok.extern.log4j.Log4j2;
//import org.modelmapper.ModelMapper;
import org.simon.laboratory_bookingpro.dto.UserDto;
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
  public ResponseEntity<?> createUser(UserDto userDtoToBeSaved) {

    if (isUserAlreadyExist(userDtoToBeSaved)) {
      return ResponseEntity.badRequest().body("UserDto with same detail already exist");
    } else {

      userRepository.save(userDtoToBeSaved);
      return ResponseEntity.ok(userDtoToBeSaved);
    }
  }

  @Override
  public List<UserDto> getAll() {
    return new ArrayList<>(userRepository.findAll());
  }

  @Override
  public ResponseEntity<?> getUserById(long id) {

    if (userRepository.findById(id).isPresent()) {

      UserDto userDto;
      try {
        userDto = userRepository.findById(id).get();
      } catch (NoSuchElementException noSuchElementException) {
        return ResponseEntity.notFound().build();
      }

      log.info("userDto found with id {} {}", id, userDto);
      return ResponseEntity.ok(userDto);

    } else {
      return ResponseEntity.notFound().build();
    }
  }
  @Override
  public ResponseEntity<?> updateUserById(long id, UserDto userDtoToUpdate) {
    ResponseEntity<?> response = getUserById(id);

    if (response.getBody() != null) {
      UserDto currentUserDto = (UserDto) response.getBody();
      // The name, phoneNumber, countryCode should not be modified.
      UserDto toSave = UserDto.builder().firstName(currentUserDto.getFirstName())
              .lastName(userDtoToUpdate.getLastName())
              .gender(userDtoToUpdate.getGender())
              .affiliation(userDtoToUpdate.getAffiliation())
              .email(userDtoToUpdate.getEmail())
              .phoneNumber(currentUserDto.getPhoneNumber())
              .password(currentUserDto.getPassword())
              .matchingPassword(currentUserDto.getMatchingPassword())
              .dob(userDtoToUpdate.getDob()).build();

      toSave.setId(currentUserDto.getId());
      userRepository.save(toSave);

      return ResponseEntity.ok(toSave);

    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<?> deleteUserById(long id) {
    if (userRepository.findById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {

      // NOTE: Delete the profile using delete method of Jpa repository.
      userRepository.deleteById(id);
      return ResponseEntity.ok(userRepository.findById(id));
    }
  }


  @Override
  public UserDto findUserByPhone(String phoneNumber) {
    UserDto foundUserDto = userRepository.findUserByPhoneNumber(phoneNumber);

    if (foundUserDto != null ) {
      log.info("Found UserDto Phone is {} ",
              foundUserDto.getPhoneNumber());

      return foundUserDto;
    } else {
      log.info("UserDto not found by phone {}", phoneNumber);
      return null;
    }
  }
 @Override
  public UserDto findUserByEmail(String email){
     return userRepository.findByEmail(email);
 }

 @Override
 public UserDto findUserByEmailAndPassword(String email, String password){
    return null; //userRepository.findByEmailAndPassword(email, password);
 }

  /**
   * @param userDto
   */
  @Override
  public void save(UserDto userDto) {

  }


  private boolean isUserAlreadyExist(UserDto userDtoToSave) {
    List<UserDto> savedUserListDto = userRepository.findAll();
    for (UserDto u : savedUserListDto) {
      if (u.getEmail().equals(userDtoToSave.getEmail())) {
        return true;
      }
    }
    return false;
  }
}
