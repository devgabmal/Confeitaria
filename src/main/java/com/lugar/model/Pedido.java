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
public class Pedido extends Transacao {

    private String estado; //F: Finalizado; E: Pronto para entrega; S: Solicitado
    private LocalDateTime dataEntrega;
    private String comentario;
    private List<Item> listaItens;
    private boolean instanciaSimplificada;

    public Pedido(int id, double valor, LocalDateTime diaHora, String descricao) {
        super(id, valor, diaHora, descricao, true);
        this.instanciaSimplificada = true;
    }

    public Pedido(int id, String estado, LocalDateTime dataEntrega,
            String comentario, List<Item> listaItens) {
        this(id, LocalDateTime.now(), estado, dataEntrega, comentario, listaItens);
    }

    public Pedido(int id, LocalDateTime diaHora, String estado, LocalDateTime dataEntrega,
            String comentario, List<Item> listaItens) {
        super(id, Pedido.calculaValorTotal(listaItens), diaHora, "Pedido", true);
        this.estado = estado;
        this.dataEntrega = dataEntrega;
        this.comentario = comentario;
        this.listaItens = listaItens;
        this.instanciaSimplificada = false;
    }

    @Override
    public double getValor() {
        if (this.instanciaSimplificada) {
            return ((Transacao) this).getValor();
        } else {
            double valorTotal = 0;
            for (Item item : listaItens) {
                valorTotal += item.getValorTotal();
            }
            return valorTotal;
        }
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public String getDataEntregaString() {
        return dataEntrega.toString();
    }

    public String getComentario() {
        return comentario;
    }

    public List<Item> getListaItens() {
        return listaItens;
    }

    private static double calculaValorTotal(List<Item> listaItens) {
        double valorTotal = 0;
        for (Item item : listaItens) {
            valorTotal += item.getValorTotal();
        }
        return valorTotal;
    }

}
