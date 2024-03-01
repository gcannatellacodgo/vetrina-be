package com.corso.vetrina;

import com.corso.vetrina.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userLogin")
public class UserController {
    @Autowired
    private UserService utenti;

    @PostMapping ("/registrazione")
    public ResponseEntity<User> registrazione (@RequestBody User utente){
        return utenti.registrazione(utente);
    }



    @GetMapping ("/login")
    public ResponseEntity<User> login(@RequestHeader("Authorization") String auth) {
        return utenti.login(auth);
    }


   /* public ResponseEntity<User> visualizzaUtente (HttpServletRequest request){
        request.getHeader("auth");
        return utenti.visualizzaUtente("");}*/





}
