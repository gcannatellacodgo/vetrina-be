package com.corso.vetrina.controller;

import com.corso.vetrina.entity.User;
import com.corso.vetrina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService utenti;

    @PostMapping ("/registrazione")
    public ResponseEntity<User> registrazione (@RequestBody User utente){
        return utenti.registrazione(utente);
    }



    @GetMapping()
    public ResponseEntity<User> login(@RequestHeader("Authorization") String auth) {
        return utenti.login(auth);
    }


   /* public ResponseEntity<User> visualizzaUtente (HttpServletRequest request){
        request.getHeader("auth");
        return utenti.visualizzaUtente("");}*/





}
