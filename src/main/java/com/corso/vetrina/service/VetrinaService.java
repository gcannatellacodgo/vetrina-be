package com.corso.vetrina.service;

import com.corso.vetrina.dto.ProdottoDto;
import com.corso.vetrina.entity.ImageEntity;
import com.corso.vetrina.entity.Prodotto;
import com.corso.vetrina.repository.ProdottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VetrinaService {
    @Autowired
    private ProdottiRepository prodotti;

    public ResponseEntity<Prodotto> visualizzaProdotto(String modelloSelezionato){
        Optional<Prodotto> opProdotto=prodotti.findByModello(modelloSelezionato);

        if(opProdotto.isPresent()){
            return ResponseEntity.ok(opProdotto.get());
        } else {
            return ResponseEntity.status(200).header("message","Prodotto non presente").body(null);
        }

    }

    public ResponseEntity<List<ProdottoDto>> visualizzaProdotti(String testo) {
        List<Prodotto> listaProdotti = prodotti.findAll();
        List<ProdottoDto> prodottiDTO = new ArrayList<>();

        if (listaProdotti.size() == 0) {
            return ResponseEntity.status(200).header("message", "Non ci sono prodotti").body(null);
        } else if (testo == null) {

            listaProdotti.forEach(item -> {
                ProdottoDto dto = new ProdottoDto();
                dto.setBlobImg(item.getBlobImg());
                dto.setModello(item.getModello());
                dto.setDescrizione(item.getDescrizione());
                dto.setPrezzo(item.getPrezzo());
                prodottiDTO.add(dto);
            });
            return ResponseEntity.ok().body(prodottiDTO);
        } else {

           List<Prodotto> listaFiltrata= prodotti.findAllByModelloContainingIgnoreCaseOrTitoloContainingIgnoreCase(testo,testo);
            listaFiltrata.forEach(item -> {
                ProdottoDto dto = new ProdottoDto();
                dto.setBlobImg(item.getBlobImg());
                dto.setModello(item.getModello());
                dto.setDescrizione(item.getDescrizione());
                dto.setPrezzo(item.getPrezzo());
                prodottiDTO.add(dto);
            });

            return ResponseEntity.ok().body(prodottiDTO);
        }
    }

    public ResponseEntity<Prodotto> aggiungiModificaProdotto(Prodotto prodotto){
        Optional<Prodotto> optionalProdotto = prodotti.findByModello(prodotto.getModello());
        if (optionalProdotto.isPresent()){
            Prodotto tmpProdotto = optionalProdotto.get();
            tmpProdotto.setModello(optionalProdotto.get().getModello());
            tmpProdotto.setDescrizione(optionalProdotto.get().getDescrizione());
            tmpProdotto.setPrezzo(optionalProdotto.get().getPrezzo());
            tmpProdotto.setTitolo(optionalProdotto.get().getTitolo());
            tmpProdotto.setCodice(optionalProdotto.get().getCodice());

            for (int i = 0; i < tmpProdotto.getBlobImg().size(); i++) {
                tmpProdotto.getBlobImg().get(i).setImage(prodotto.getBlobImg().get(i).getImage());
            }

            return ResponseEntity.status(200).header("message", "modello aggiornato").body(prodotti.save(tmpProdotto));
        }else {
            return ResponseEntity.status(200).header("message", "modello aggiunto").body(prodotti.save(prodotto));
        }
    }


    public ResponseEntity<Prodotto> eliminaProdotto(String modello){
        prodotti.deleteById(modello);
        return ResponseEntity.status(200).header("message","modello eliminato").body(null);
    }
}
