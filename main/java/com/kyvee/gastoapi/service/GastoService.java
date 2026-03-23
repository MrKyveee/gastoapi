package com.kyvee.gastoapi.service;

import com.kyvee.gastoapi.model.CategoriaGasto;
import com.kyvee.gastoapi.model.GastoModel;
import com.kyvee.gastoapi.repository.GastoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GastoService {
    private final GastoRepository repository;

    public GastoService(GastoRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<GastoModel> registrarGasto(GastoModel gastoModel) {
        if (gastoModel.getValor() == null  || gastoModel.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O valor do gasto deve ser maior que zero");
        }

        if (gastoModel.getCategoria() == null) {
            gastoModel.setCategoria(CategoriaGasto.OUTROS);
        }

        if (gastoModel.getDescricao() == null || gastoModel.getDescricao().isBlank()) {
            throw new RuntimeException("A descrição do gasto é obrigatória.");
        }
        gastoModel.setDescricao(gastoModel.getDescricao().trim());

        repository.save(gastoModel);
        return ResponseEntity
                .status(201)
                .body(gastoModel);
    }

    public ResponseEntity<List<GastoModel>> listarGastos() {
        List<GastoModel> gastos = (ArrayList<GastoModel>)repository.findAll();
        if (gastos.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(gastos);
    }

    public ResponseEntity<List<GastoModel>> listarGastosCategoria(CategoriaGasto categoria) {
        if (!repository.existsByCategoria(categoria)) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(repository.findByCategoria(categoria));
    }

    public ResponseEntity<String> deletarGasto(Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Gasto com ID " + id + " deletado com sucesso!");
    }

}
