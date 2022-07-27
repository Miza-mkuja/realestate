package com.example.Real.Estate.web.ApiController;

import com.example.Real.Estate.web.Api.UserApi;
import com.example.Real.Estate.Dto.UserRequestDto;
import com.example.Real.Estate.Dto.UserResponseDto;
import com.example.Real.Estate.Model.User;
import com.example.Real.Estate.Service.UserServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserApiController implements UserApi {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    UserServices userServices;
    @Override
    public ResponseEntity<UserResponseDto> createUser(UserRequestDto dto) {

        //Optional<User> UserUsername=userServices.findUserByUsername( dto.getUsername());
        Optional<User> UserEmail=userServices.findByEmail(dto.getEmail());

//        if(UserUsername.isPresent()){
//            throw new IllegalStateException("Username "+ dto.getUsername()+ " Already Taken");
//        }else
      if (UserEmail.isPresent()){
            throw new IllegalStateException("Email "+ dto.getEmail()+ " Already Taken");
        }
        User user = new User();
       // user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setUserRole(dto.getUserRole());
        user.setPassword(dto.getPassword());

        User createUser= userServices.createUser(user);

        UserResponseDto response=new UserResponseDto();
        response.setUserId(createUser.getUserId());
        //response.setUsername(createUser.getUsername());
        response.setEmail(createUser.getEmail());
        response.setUserRole(createUser.getUserRole());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUser(Long user_id, UserRequestDto dto) {
        Optional<User> userOptional=userServices.getUserById(user_id);
        if(!userOptional.isPresent()){
            throw new IllegalStateException("User with "+ user_id + " Does Not exist");
        }
        User user = userOptional.get();
        //user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setUserRole(dto.getUserRole());
        user.setPassword(dto.getPassword());

        User createUser= userServices.createUser(user);

        UserResponseDto response=new UserResponseDto();
        response.setUserId(createUser.getUserId());
        //response.setUsername(createUser.getUsername());
        response.setEmail(createUser.getEmail());
        response.setUserRole(createUser.getUserRole());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserResponseDto> getUserById(Long user_id) {
        Optional<User> userOptional=userServices.getUserById(user_id);
        if(!userOptional.isPresent()){
            throw new IllegalStateException("User with "+ user_id + " Does Not exist");
        }
        User user = userOptional.get();
        UserResponseDto response=new UserResponseDto();
        response.setUserId(user.getUserId());
       // response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setUserRole(user.getUserRole());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserResponseDto> deleteUser(Long user_id) {
        Optional<User> userOptional=userServices.getUserById(user_id);
        if(!userOptional.isPresent()){
            throw new IllegalStateException("User with "+ user_id + " Does Not exist");
        }
        userServices.deleteUser(user_id);
        User user = userOptional.get();
        UserResponseDto response=new UserResponseDto();
        response.setUserId(user.getUserId());
        //response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setUserRole(user.getUserRole());
        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> getAllUser() {
        List<UserResponseDto> response = userServices.getAllUser().stream().map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<UserResponseDto>>(response, HttpStatus.OK);
    }

}
