package com.kyvee.gastoapi.controller;

import com.kyvee.gastoapi.model.CategoriaGasto;
import com.kyvee.gastoapi.model.GastoModel;
import com.kyvee.gastoapi.service.GastoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @PostMapping
    public ResponseEntity<GastoModel> registrarGasto(@RequestBody GastoModel gastoModel) {
        return gastoService.registrarGasto(gastoModel);
    }

    @GetMapping
    public ResponseEntity<List<GastoModel>> listarGastos() {
        return gastoService.listarGastos();
    }

    @GetMapping("/categoria{categoria}")
    public ResponseEntity<List<GastoModel>> listarGastoCategoria(@PathVariable CategoriaGasto categoria) {
        return gastoService.listarGastosCategoria(categoria);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarGasto(@PathVariable Integer id) {
        return gastoService.deletarGasto(id);
    }
}