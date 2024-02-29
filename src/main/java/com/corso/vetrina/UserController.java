package com.corso.vetrina;

import com.corso.vetrina.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("UserLog-in")
public class UserController {
    @Autowired
    private UserService utenti;

    @PostMapping ("InserisciUtente")
    public ResponseEntity<User> inserisciUtente (@RequestBody User utente){
        return utenti.aggiungiUtente(utente);
    }



    @GetMapping ("visualizzaUtente")
    public ResponseEntity<User> visualizzaUtente (HttpServletRequest request){
        request.getHeader("auth");
        return utenti.visualizzaUtente();}





}
