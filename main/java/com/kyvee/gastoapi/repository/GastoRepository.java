package com.kyvee.gastoapi.repository;

import com.kyvee.gastoapi.model.CategoriaGasto;
import com.kyvee.gastoapi.model.GastoModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GastoRepository extends CrudRepository<GastoModel, Integer> {
        boolean existsByCategoria(CategoriaGasto categoria);
        List<GastoModel> findByCategoria(CategoriaGasto categoria);
}

