package com.example.Real.Estate.web.Api;

import com.example.Real.Estate.Dto.UserRequestDto;
import com.example.Real.Estate.Dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/user")
@CrossOrigin


public interface UserApi {

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto);

    @RequestMapping(value = "/{user_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long user_id, @RequestBody UserRequestDto dto);

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long user_id);

    @RequestMapping(value = "/{user_id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable Long user_id);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllUser();

}
