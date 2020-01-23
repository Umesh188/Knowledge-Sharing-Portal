package com.ksp1.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksp1.beans.User;
@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.username=:nm and u.password=:pass")
	Optional<User> AuthenticateRole(@Param("nm")String nm,@Param("pass") String pass);

	

	

}
