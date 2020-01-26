package com.ksp1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksp1.beans.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.username=:userName and u.password=:password")
	User getByUsernamePassword(@Param("userName")String userName,@Param("password") String password);

}
