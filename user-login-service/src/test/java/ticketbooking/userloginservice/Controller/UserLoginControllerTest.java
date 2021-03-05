package ticketbooking.userloginservice.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ticketbooking.userloginservice.dto.UserLoginReqDto;
import ticketbooking.userloginservice.entity.UserLogin;
import ticketbooking.userloginservice.service.UserLoginService;
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserLoginControllerTest {
	
	
	@InjectMocks
	UserLoginController userController;
	
	@Mock
	UserLoginService userService;

	static UserLogin  userResponseDto;
	static UserLoginReqDto userDto;
	
	@BeforeAll
	public static void setup() {
		userResponseDto = new UserLogin();
		userResponseDto.setUserName("samuel");
		userResponseDto.setPassword("asdf");
		

		userDto = new UserLoginReqDto();
		userDto.setUserName("samuel");
		userDto.setPassword("asdf");
	}
	
	@Test
	public void userLoginTest() {
		 

		/*UserResponseDto responseDto = new UserResponseDto();
		responseDto.setStatusCode(ErrorConstants.INVALID_INPUT_CODE);
		responseDto.setStatusMessage(ErrorConstants.INVALID_INPUT);*/

		Mockito.when(userService.userLoginMethod(Mockito.any(), Mockito.any())).thenReturn(userResponseDto);
		ResponseEntity<UserLogin> result = userController.userLoginMethod(userDto);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}


}
