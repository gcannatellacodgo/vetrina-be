package com.corso.vetrina.service;

import com.corso.vetrina.repository.UserRepository;
import com.corso.vetrina.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository utenti;

    //boolean mailPresente =false;
    //boolean utenteRegistrato;

    public ResponseEntity<User> registrazione(User utente){
        Optional<User> optionalUser= utenti.findByMail(utente.getMail());

        //mailPresente = false;
        /*utenti.findAll().forEach(item ->{
            if (utente.getMail().equals(item.getMail())){
                mailPresente = true;
            }
        });*/

        if (optionalUser.isPresent()){
            return ResponseEntity.status(200).header ("message", "mail presente").body(null);
        }else {
            return ResponseEntity.ok(utenti.save(utente));
        }
    }

    public ResponseEntity<User> login(String auth) {
        String decodAuth =new String(Base64.getDecoder().decode(auth));
        String[] parts =decodAuth.split(":");
        if (parts.length!=2){
            return ResponseEntity.status(200).header("message","Credenziali di accesso non corrette").body(null);
        }
        else {
            String mail = parts[0];
            String password = parts[1];

            Optional<User> optionalUser= utenti.findByMail(mail);

            /*utenteRegistrato=false;
            utenti.findAll().forEach(item ->{
                if (mail.equals(item.getMail())){
                    utenteRegistrato = true;
                }
            });*/

            if (optionalUser.isPresent() && password.equals(optionalUser.get().getPassword()) ) {

                    return ResponseEntity.status(200).header("message", "Credenziali corrette").body(optionalUser.get());
                }
            else     {
                    return ResponseEntity.status(200).header("message", "Credenziali non presenti, registrati").body(null);
                }
            }
        }



    }

