package com.corso.vetrina.repository;

import com.corso.vetrina.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProdottiRepository extends JpaRepository<Prodotto,String> {

Optional<Prodotto> findByModello(String modello);

List<Prodotto> findAllByModelloContainingIgnoreCaseOrTitoloContainingIgnoreCase(String modello,String titolo);



}
