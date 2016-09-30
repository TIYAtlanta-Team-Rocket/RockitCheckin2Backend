package com.tiy.RocketCheckIn;

/**
 * Created by Yehia830 on 9/29/16.
 */
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User,Integer>{
 User findByEmailAndPassword(String email, String password);

}
