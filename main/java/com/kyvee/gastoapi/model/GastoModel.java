package com.kyvee.gastoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_gasto")
public class GastoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    @Column(nullable = false, precision = 10, scale = 2)
    private double valor;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaGasto categoria;

    public GastoModel() {}

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public CategoriaGasto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaGasto categoria) {
        this.categoria = categoria;
    }
}
