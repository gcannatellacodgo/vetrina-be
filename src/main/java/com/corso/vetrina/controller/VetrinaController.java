package com.corso.vetrina.controller;

import com.corso.vetrina.dto.ProdottoDto;
import com.corso.vetrina.entity.Prodotto;
import com.corso.vetrina.service.VetrinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping(path = "/inserisci", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Prodotto> inserisciProdotto(@RequestPart MultipartFile file, @RequestPart String codice, @RequestPart Double prezzo, @RequestPart String descrizione, @RequestPart String modello,@RequestPart String titolo) throws IOException {
        Prodotto prodotto = new Prodotto();
        prodotto.setCodice(codice);
        prodotto.setPrezzo(prezzo);
        prodotto.setTitolo(titolo);
        prodotto.setModello(modello);
        prodotto.setDescrizione(descrizione);
        prodotto.setBlobImg(file.getBytes());

        return vetrina.aggiungiModificaProdotto(new Prodotto());
    }
    @PutMapping("/modifica")
    public ResponseEntity<Prodotto> modificaProdotto(@RequestBody Prodotto prodotto){
        return vetrina.aggiungiModificaProdotto(prodotto);
    }

    @DeleteMapping("/{modello}")
    public ResponseEntity<Prodotto> eliminaProdotto(@PathVariable String modello){
        return vetrina.eliminaProdotto(modello);
    }

}
