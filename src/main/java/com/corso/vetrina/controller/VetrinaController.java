package com.corso.vetrina.controller;

import com.corso.vetrina.dto.ProdottoDto;
import com.corso.vetrina.entity.Prodotto;
import com.corso.vetrina.service.VetrinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotti")
public class VetrinaController {

    @Autowired
    private VetrinaService vetrina;

    @GetMapping("/{modello}")
    public ResponseEntity<Prodotto> visualizzaProdotto(@PathVariable String modello){
        return vetrina.visualizzaProdotto(modello);
    }
    @GetMapping()
    public ResponseEntity<List<ProdottoDto>> visualizzaProdotti(@RequestParam(required = false) String ricerca){
        return vetrina.visualizzaProdotti(ricerca);
    }

    @PostMapping("/inserisci")
    public ResponseEntity<Prodotto> inserisciProdotto(@RequestBody Prodotto prodotto){
        return vetrina.aggiungiModificaProdotto(prodotto);
    }
    @PutMapping("/modifica")
    public ResponseEntity<Prodotto> modificaProdotto(@RequestBody Prodotto prodotto){
        return vetrina.aggiungiModificaProdotto(prodotto);
    }

    @DeleteMapping("/elimina/{modello}")
    public ResponseEntity<Prodotto> eliminaProdotto(@PathVariable String modello){
        return vetrina.eliminaProdotto(modello);
    }

}
