package com.Basic.InstaBackend.Controller;

import com.Basic.InstaBackend.Model.Dto.SignInInput;
import com.Basic.InstaBackend.Model.Dto.SignInOutput;
import com.Basic.InstaBackend.Model.Dto.SignUpOutput;
import com.Basic.InstaBackend.Model.User;
import com.Basic.InstaBackend.Service.TokenService;
import com.Basic.InstaBackend.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
    @PutMapping()
    public ResponseEntity<String> updateUser(@RequestParam String email , @RequestParam String token , @RequestBody User user){
        HttpStatus status;
        String msg=null;

        if(authService.authenticate(email,token))
        {
            try{
                userService.updateUser(user , token);
                status = HttpStatus.OK;
                msg = "User updated";
            }catch (Exception e){
                msg = "Enter valid info";
                status = HttpStatus.BAD_REQUEST;
            }

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

}