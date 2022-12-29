/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lugar.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author lugar
 */
public class Pedido {

    private int id;
//    private char estado; // S - aceito pelo cliente; A = aceito e agendado; F  = aceito e fechado; C  = cancelado
//    private boolean agendado;
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataEntrega;
    private String comentario;
    private List<Item> listaItens;

    public Pedido(int id, LocalDateTime dataSolicitacao, LocalDateTime dataEntrega, List<Item> listaItens) {
        this.id = id;
//        this.estado = estado;
//        this.agendado = agendado;
        this.dataSolicitacao = dataSolicitacao;
        this.dataEntrega = dataEntrega;
        this.listaItens = listaItens;

    }

    public int getId() {
        return id;
    }

    public double getValorTotal() {
        double valorTotal = 0;
        for (Item item : listaItens) {
            valorTotal += item.getValorTotal();
        }
        return valorTotal;
    }

    public List<Item> getListaItens() {
        return listaItens;
    }

}
