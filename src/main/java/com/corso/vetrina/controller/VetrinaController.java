package com.corso.vetrina.controller;

import com.corso.vetrina.dto.ProdottoDto;
import com.corso.vetrina.entity.ImageEntity;
import com.corso.vetrina.entity.Prodotto;
import com.corso.vetrina.service.VetrinaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    @PostMapping(path = "/inserisci",consumes = "multipart/form-data")
    @Transactional
    public ResponseEntity<Prodotto> inserisciProdotto(@RequestPart("file") MultipartFile[] files,@RequestPart("titolo") String titolo,@RequestPart("modello") String modello,@RequestPart("codice") String codice,@RequestPart("descrizione") String descrizione,@RequestPart("prezzo") String prezzo) throws IOException {
        Prodotto prodotto = new Prodotto();
        prodotto.setTitolo(titolo);
        prodotto.setModello(modello);
        prodotto.setCodice(codice);
        prodotto.setDescrizione(descrizione);
        prodotto.setPrezzo(Double.parseDouble(prezzo));

        List< ImageEntity> immagini = new ArrayList<>();
        for (MultipartFile file : files) {
            immagini.add(new ImageEntity(file.getBytes()));
        }
        prodotto.setBlobImg(immagini);

        return vetrina.aggiungiModificaProdotto(prodotto);
    }
    @PutMapping("/modifica")
    public ResponseEntity<Prodotto> modificaProdotto(@RequestPart("file") MultipartFile[] files,@RequestPart("titolo") String titolo,@RequestPart("modello") String modello,@RequestPart("codice") String codice,@RequestPart("descrizione") String descrizione,@RequestPart("prezzo") String prezzo) throws IOException {
        Prodotto prodotto = new Prodotto();
        prodotto.setTitolo(titolo);
        prodotto.setModello(modello);
        prodotto.setCodice(codice);
        prodotto.setDescrizione(descrizione);
        prodotto.setPrezzo(Double.parseDouble(prezzo));

        List<ImageEntity> immagini = new ArrayList<>();
        for (MultipartFile file : files) {
            immagini.add(new ImageEntity(file.getBytes()));
        }
        prodotto.setBlobImg(immagini);

        return vetrina.aggiungiModificaProdotto(prodotto);
    }

    @DeleteMapping("/{modello}")
    public ResponseEntity<Prodotto> eliminaProdotto(@PathVariable String modello){
        return vetrina.eliminaProdotto(modello);
    }

}
