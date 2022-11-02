/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lugar.confeitaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lugar
 */
public class Conexao {

    /**
     * Conecta ao banco de dados confeitaria.db
     *
     * @return o objeto Connection
     */
    private Connection criaConexao() {
        String url = "jdbc:sqlite:confeitaria.db";
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexao;
    }

    /**
     * Seleciona todas as linhas em uma tabela
     */
    public ResultSet selecionaTodas(String[] campos, String tabela) {
        String sql = "SELECT ";
        for (int i = 0; i < campos.length; i++) {
            sql += campos[i];
            if (i == campos.length - 1) {
                sql += " ";
            } else {
                sql += ", ";
            }
        }
        sql += "FROM " + tabela + ";";

        try ( Connection conexao = this.criaConexao();  Statement stmt = conexao.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t"
//                        + rs.getString("nome"));
//            }
            return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
