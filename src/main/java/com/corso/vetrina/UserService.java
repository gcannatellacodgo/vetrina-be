package com.corso.vetrina;

import com.corso.vetrina.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository utenti;

    boolean mailPresente =false;

    public ResponseEntity<User> aggiungiUtente(User utente){
        mailPresente = false;
        utenti.findAll().forEach(item ->{
            if (utente.getMail().equals(item.getMail())){
                mailPresente = true;
            }
        });
        if (mailPresente){
            return ResponseEntity.status(200).header ("message", "mail presente").body(null);
        }else {
            User contatto = new User();
            contatto.setNome(utente.getNome());
            contatto.setMail(utente.getMail());
            contatto.setCellulare(utente.getCellulare());
            contatto.setCognome(utente.getCognome());


            return ResponseEntity.ok(utenti.save(utente));
        }
    }

    public ResponseEntity<User> visualizzaUtente() {

    }
}
