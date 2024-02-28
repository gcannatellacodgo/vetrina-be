package com.corso.vetrina;

import com.corso.vetrina.Dto.ProdottoDto;
import com.corso.vetrina.entity.Prodotto;
import com.corso.vetrina.repository.prodottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VetrinaService {
    @Autowired
    private prodottiRepository prodotti;

    public Optional<Prodotto> visualizzaProdotto(String modelloSelezionato){

        return prodotti.findByModello(modelloSelezionato);
    }

    public List<ProdottoDto> visualizzaProdotti(){
        List<Prodotto> listaProdotti=prodotti.findAll();
        List<ProdottoDto> prodottiDTO = new ArrayList<>();

        listaProdotti.forEach(item -> {
            ProdottoDto dto = new ProdottoDto();
            dto.setBlobImg(item.getBlobImg());
            dto.setModello(item.getModello());
            dto.setDescrizione(item.getDescrizione());
            dto.setPrezzo(item.getPrezzo());
            prodottiDTO.add(dto);
        });
        return prodottiDTO;
    }

}
