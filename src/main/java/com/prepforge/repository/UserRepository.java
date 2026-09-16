package com.prepforge.repository;
import com.prepforge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
    extends JpaRepository<User, Long>{

}
