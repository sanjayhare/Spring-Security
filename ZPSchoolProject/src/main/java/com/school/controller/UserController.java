package com.school.controller;

import com.school.constant.SchoolConstants;
import com.school.dto.ResponseDto;
import com.school.dto.UsersDto;
import com.school.entity.Users;
import com.school.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/school1", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fetch")
    public ResponseEntity<UsersDto> fetchUserDetails(@RequestParam String userID) {
        UsersDto userDetails = userService.getUserDetails(userID);
        return ResponseEntity.status(HttpStatus.OK).body(userDetails);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody Users user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(SchoolConstants.STATUS_201, SchoolConstants.MESSAGE_201));
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody UsersDto usersDto) {
        //System.out.println("User by me"+user.toString());
        boolean isUpdated = userService.updateUser(usersDto);
        if (isUpdated == true) {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(new ResponseDto(SchoolConstants.STATUS_201, SchoolConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(new ResponseDto(SchoolConstants.STATUS_417, SchoolConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> updateUser(@RequestParam String userID) {
        //System.out.println("User by me"+user.toString());
        boolean isDeleted = userService.deleteUser(userID);
        if (isDeleted == true) {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(new ResponseDto(SchoolConstants.STATUS_201, SchoolConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(new ResponseDto(SchoolConstants.STATUS_417, SchoolConstants.MESSAGE_417_DELETE));
        }
    }
}
