package org.simon.laboratory_bookingpro.repository;

import org.simon.laboratory_bookingpro.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto,Long> {
    public UserDto findAllById(int id);
    public UserDto findAllByEmail(String email);
    public UserDto findAllByIdAndEmail(int id, String email);
    public UserDto findAllByPhoneNumber(String phoneNumber);
    public UserDto findUserByPhoneNumber(String phoneNumber);

    public UserDto findByEmail(String email);

    public void deleteById(Long id);


}
