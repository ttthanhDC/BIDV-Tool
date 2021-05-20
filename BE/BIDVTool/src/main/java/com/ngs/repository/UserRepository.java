package com.ngs.repository;

import com.ngs.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.userName = :userName")
    User findByUserName(String userName);
}
