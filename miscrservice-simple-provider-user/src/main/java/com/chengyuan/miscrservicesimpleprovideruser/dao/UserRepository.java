package com.chengyuan.miscrservicesimpleprovideruser.dao;


import com.chengyuan.miscrservicesimpleprovideruser.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
