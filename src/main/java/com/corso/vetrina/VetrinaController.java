package com.corso.vetrina;

import com.corso.vetrina.Dto.ProdottoDto;
import com.corso.vetrina.entity.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vetrinaCorso")
public class VetrinaController {

    @Autowired
    private VetrinaService vetrina;

    @GetMapping("/visualizzaProdotto/{modelloSelezionato}")
    public ResponseEntity<Prodotto> visualizzaProdotto(@PathVariable String modelloSelezionato){
        return vetrina.visualizzaProdotto(modelloSelezionato);
    }
    @GetMapping("/prodotti")
    public ResponseEntity<List<ProdottoDto>> visualizzaProdotti(){
        return vetrina.visualizzaProdotti();
    }



}
