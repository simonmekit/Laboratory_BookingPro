package org.simon.laboratory_bookingpro.repository;

import org.simon.laboratory_bookingpro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findAllById(int id);
    public User findAllByEmail(String email);
    public User findAllByIdAndEmail(int id, String email);
    public User findAllByPhoneNumber(String phoneNumber);
    public User findUserByPhoneNumber(String phoneNumber);
}
