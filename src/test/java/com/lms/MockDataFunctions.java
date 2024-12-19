package com.lms;

import com.lms.persistence.LoginUserDto;
import com.lms.persistence.RegisterUserDto;
import com.lms.persistence.User;

public class MockDataFunctions {

    public static RegisterUserDto mockRegisteredUser(String id, String firstName, String lastName, String email, String password, String role) {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setId(id);
        registerUserDto.setFirstName(firstName);
        registerUserDto.setLastName(lastName);
        registerUserDto.setEmail(email);
        registerUserDto.setPassword(password);
        registerUserDto.setRole(role);
        return registerUserDto;
    }

    public static LoginUserDto mockLoggedInUser(String email, String password) {
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setEmail(email);
        loginUserDto.setPassword(password);
        return loginUserDto;
    }

    public static User mockAddedUser(String id, String email, String role) {
        return new User()
                .setId(id)
                .setEmail(email)
                .setRole(role);
    }

    public static User mockAddedUser(String id, String firstName, String lastName, String email, String password, String role) {
        return new User()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setRole(role);
    }


}
