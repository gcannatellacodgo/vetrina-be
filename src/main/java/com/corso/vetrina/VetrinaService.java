package com.corso.vetrina;

import com.corso.vetrina.Dto.ProdottoDto;
import com.corso.vetrina.entity.Prodotto;
import com.corso.vetrina.repository.ProdottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

}
