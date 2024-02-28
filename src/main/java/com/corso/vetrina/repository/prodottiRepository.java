package com.corso.vetrina.repository;

import com.corso.vetrina.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface prodottiRepository extends JpaRepository<Prodotto,String> {

Optional<Prodotto> findByModello(String modello);

}
