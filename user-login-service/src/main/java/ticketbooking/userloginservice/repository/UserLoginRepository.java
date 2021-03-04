package ticketbooking.userloginservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ticketbooking.userloginservice.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {
	
	Optional<UserLogin> findByUserNameAndPassword(String userName,String password);
	
	

}
