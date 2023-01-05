/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lugar.controller;

import com.lugar.confeitaria.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;

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
    static Connection abreConexao() {
        String url = "jdbc:sqlite:confeitaria.db";
        Connection conexao = null;
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            conexao = DriverManager.getConnection(url, config.toProperties());
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }

    static void fechaConexao(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            // Fechamento de conexão falhou
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static int determinaValorErro(String mensagem) {
        if (mensagem.substring(0, 26)
                .equals("[SQLITE_CONSTRAINT_UNIQUE]")) {
            return Util.RETORNO_ERRO_NAO_UNICO;
        } else {
            return Util.RETORNO_ERRO_INDETERMINADO;
        }
    }

    public static void criaBancoDeDados() {
        Connection conn = null;

        try {
            conn = Conexao.abreConexao();
            if (conn == null) {
                return;
            }

            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();
            stmt.setQueryTimeout(30);

            String sql = "";

            sql = "CREATE TABLE IF NOT EXISTS \"Produto\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"tipo\"	INTEGER NOT NULL DEFAULT 0 CHECK(\"tipo\" IN (0, 1)),"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"ProdutoPronto\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"nome\"	TEXT NOT NULL UNIQUE,\n"
                    + "	\"estoque\"	INTEGER NOT NULL DEFAULT 0,\n"
                    + "	\"valor\"	REAL NOT NULL DEFAULT 0,\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Produto\"(\"id\") ON DELETE CASCADE,\n"
                    + "	PRIMARY KEY(\"id\")\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"ProdutoPersonalizado\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"detalhe\"	TEXT,\n"
                    + "	\"receita\"	TEXT NOT NULL CHECK(receita IN('B','T')),\n"
                    + "	\"idCobertura\"	INTEGER,\n"
                    + "	\"idCor\"	INTEGER NOT NULL,\n"
                    + "	\"idForma\"	INTEGER NOT NULL,\n"
                    + "	PRIMARY KEY(\"id\"),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Produto\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Transacao\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"valor\"	REAL NOT NULL,\n"
                    + "	\"diaHora\"	TEXT NOT NULL,\n"
                    + "	\"descricao\"	TEXT NOT NULL,\n"
                    + "	\"ehPedido\"	INTEGER NOT NULL DEFAULT 0 CHECK(\"ehPedido\" IN (0, 1)),\n"
                    + "	PRIMARY KEY(\"id\")\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Endereco\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"numero\"	TEXT NOT NULL DEFAULT 'S/N',\n"
                    + "	\"complemento\"	TEXT,\n"
                    + "	\"logradouro\"	TEXT NOT NULL,\n"
                    + "	\"bairro\"	TEXT NOT NULL,\n"
                    + "	\"cidade\"	TEXT NOT NULL,\n"
                    + "	\"uf\"	TEXT NOT NULL,\n"
                    + "	\"cep\"	TEXT NOT NULL CHECK(LENGTH(\"cep\") == 7),\n"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Usuario\" (\n"
                    + " \"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"nome\"	TEXT NOT NULL,\n"
                    + "	\"nomeUsuario\"	TEXT NOT NULL UNIQUE,\n"
                    + "	\"senhaHash\"	TEXT NOT NULL,\n"
                    + "	\"identificador\"	TEXT NOT NULL,\n"
                    + "	\"email\"	TEXT NOT NULL UNIQUE,\n"
                    + "	\"telefone\"	TEXT NOT NULL,\n"
                    + "	\"admin\"	INTEGER NOT NULL DEFAULT 0 CHECK(\"admin\" IN (0, 1)),\n"
                    + " \"idEndereco\"	INTEGER NOT NULL,\n"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT),\n"
                    + "	FOREIGN KEY(\"idEndereco\") REFERENCES \"Endereco\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Cliente\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"cartao\"	TEXT NOT NULL CHECK(LENGTH(\"cartao\") == 16),\n"
                    + "	PRIMARY KEY(\"id\"),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Usuario\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"PessoaFisica\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"dataNascimento\"	TEXT NOT NULL,\n"
                    + "	PRIMARY KEY(\"id\"),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Cliente\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"PessoaFisica\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"dataNascimento\"	TEXT NOT NULL,\n"
                    + "	PRIMARY KEY(\"id\"),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Cliente\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"PessoaJuridica\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"razaoSocial\"	TEXT NOT NULL,\n"
                    + "	PRIMARY KEY(\"id\"),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Cliente\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Funcionario\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"matricula\"	TEXT NOT NULL UNIQUE,\n"
                    + "	\"funcao\"	TEXT NOT NULL,\n"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Usuario\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Caracteristica\" (\n"
                    + " \"id\"         INTEGER NOT NULL UNIQUE,\n"
                    + " \"tipo\"       TEXT    NOT NULL CHECK (tipo IN (\"F\", \"R\", \"T\", \"C\") ),\n"
                    + " \"nome\"       TEXT    NOT NULL UNIQUE,\n"
                    + " \"valorGrama\" REAL    NOT NULL DEFAULT 0,\n"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Forma\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"recheios\"	INTEGER NOT NULL DEFAULT 0 CHECK(recheios >=0 AND recheios <=3),\n"
                    + "	\"gramaRecheio\"	INTEGER NOT NULL DEFAULT 0,\n"
                    + "	\"gramaCobertura\"	INTEGER NOT NULL DEFAULT 0,\n"
                    + "	\"gramaMassa\"	INTEGER NOT NULL DEFAULT 0,\n"
                    + "	PRIMARY KEY(\"id\"),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Caracteristica\"(\"id\") ON DELETE CASCADE\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"ProdutoPersonalizado_Recheio\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"idProdutoPersonalizado\"	INTEGER NOT NULL,\n"
                    + "	\"idRecheio\"	INTEGER NOT NULL,\n"
                    + "	FOREIGN KEY(\"idRecheio\") REFERENCES \"Caracteristica\"(\"id\") ON DELETE CASCADE,\n"
                    + "	FOREIGN KEY(\"idProdutoPersonalizado\") REFERENCES \"Produto\"(\"id\") ON DELETE CASCADE,\n"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Pedido\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"estado\"	TEXT NOT NULL,\n"
                    + "	\"dataEntrega\"	TEXT NOT NULL,\n"
                    + "	\"comentario\"	TEXT,\n"
                    + "	\"idCliente\"	INTEGER NOT NULL,\n"
                    + "	FOREIGN KEY(\"idCliente\") REFERENCES \"Usuario\"(\"id\"),\n"
                    + "	FOREIGN KEY(\"id\") REFERENCES \"Transacao\"(\"id\") ON DELETE CASCADE,\n"
                    + "	PRIMARY KEY(\"id\")\n"
                    + ");";
            stmt.addBatch(sql);

            sql = "CREATE TABLE IF NOT EXISTS \"Item\" (\n"
                    + "	\"id\"	INTEGER NOT NULL UNIQUE,\n"
                    + "	\"valorTotal\"	REAL NOT NULL,\n"
                    + "	\"quantidade\"	INTEGER NOT NULL,\n"
                    + "	\"idProduto\"	INTEGER NOT NULL,\n"
                    + "	\"idPedido\"	INTEGER NOT NULL,\n"
                    + "	FOREIGN KEY(\"idProduto\") REFERENCES \"Produto\"(\"id\"),\n"
                    + "	FOREIGN KEY(\"idPedido\") REFERENCES \"Pedido\"(\"id\") ON DELETE CASCADE,\n"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                    + ");";
            stmt.addBatch(sql);

            stmt.executeBatch();
            conn.commit();

            sql = "SELECT id FROM Usuario LIMIT 1;";
            ResultSet rs = stmt.executeQuery(sql);
            conn.commit();

            if (!rs.next()) {
                sql = "INSERT INTO \"Produto\" (\"id\",\"tipo\") VALUES (1,1);\n"
                        + "INSERT INTO \"Produto\" (\"id\",\"tipo\") VALUES (2,1);\n"
                        + "INSERT INTO \"Produto\" (\"id\",\"tipo\") VALUES (3,0);\n"
                        + "INSERT INTO \"Produto\" (\"id\",\"tipo\") VALUES (4,0);\n"
                        + "INSERT INTO \"Produto\" (\"id\",\"tipo\") VALUES (5,0);\n"
                        + "INSERT INTO \"ProdutoPronto\" (\"id\",\"nome\",\"estoque\",\"valor\") VALUES (3,'Brownie',8,6.95);\n"
                        + "INSERT INTO \"ProdutoPronto\" (\"id\",\"nome\",\"estoque\",\"valor\") VALUES (4,'Bolo de milho simples',1,7.89);\n"
                        + "INSERT INTO \"ProdutoPronto\" (\"id\",\"nome\",\"estoque\",\"valor\") VALUES (5,'Sorvete de manga apimentada',0,3.67);\n"
                        + "INSERT INTO \"ProdutoPersonalizado\" (\"id\",\"detalhe\",\"receita\",\"idForma\",\"idCor\",\"idCobertura\") VALUES (1,'Gostoso','B',2,3,4);\n"
                        + "INSERT INTO \"Transacao\" (\"id\",\"valor\",\"diaHora\",\"descricao\") VALUES (0,12.71,'2020-08-17T10:11:16.908732','Compra de papéis');\n"
                        + "INSERT INTO \"Endereco\" (\"id\",\"numero\",\"complemento\",\"logradouro\",\"bairro\",\"cidade\",\"uf\",\"cep\") VALUES (1,'0','','Rua dos bobos','Vale Místico','Lírica do Norte','MG','3789287');\n"
                        + "INSERT INTO \"Endereco\" (\"id\",\"numero\",\"complemento\",\"logradouro\",\"bairro\",\"cidade\",\"uf\",\"cep\") VALUES (2,'34','APT 506','Avenida Brasil','Centro','Mar de Espanha','MG','3897235');\n"
                        + "INSERT INTO \"Endereco\" (\"id\",\"numero\",\"complemento\",\"logradouro\",\"bairro\",\"cidade\",\"uf\",\"cep\") VALUES ('3','S/N','','Rua das Indústrias','Distrito Industrial','Juiz de Fora','MG','3809725');\n"
                        + "INSERT INTO \"Usuario\" (\"id\",\"nome\",\"nomeUsuario\",\"senhaHash\",\"identificador\",\"admin\",\"email\",\"telefone\",\"idEndereco\") VALUES (1,'Cliente PF Exemplo','cliente','senha','01234567890',0,'cliente@email.com','32980675454',1);\n"
                        + "INSERT INTO \"Usuario\" (\"id\",\"nome\",\"nomeUsuario\",\"senhaHash\",\"identificador\",\"admin\",\"email\",\"telefone\",\"idEndereco\") VALUES (2,'Papelaria O Escritório','juridico','senha','09468264870001',0,'contato@papelaria.com','3233988734',3);\n"
                        + "INSERT INTO \"Usuario\" (\"id\",\"nome\",\"nomeUsuario\",\"senhaHash\",\"identificador\",\"admin\",\"email\",\"telefone\",\"idEndereco\") VALUES (3,'Funcionário Exemplo','admin','senha','09876543210',1,'admin@email.com','32956435476',2);\n"
                        + "INSERT INTO \"Cliente\" (\"id\",\"cartao\") VALUES (1,'7846746387576273');\n"
                        + "INSERT INTO \"Cliente\" (\"id\",\"cartao\") VALUES (2,'8946736409768881');\n"
                        + "INSERT INTO \"PessoaFisica\" (\"id\",\"dataNascimento\") VALUES (1,'1996-08-17T00:00:00.000000');\n"
                        + "INSERT INTO \"PessoaJuridica\" (\"id\",\"razaoSocial\") VALUES (2,'Empresa de Papéis LTDA');"
                        + "INSERT INTO \"Funcionario\" (\"id\",\"matricula\",\"funcao\") VALUES (3,'201789034','Caixa');\n"
                        + "INSERT INTO \"Caracteristica\" (\"id\",\"tipo\",\"nome\",\"valorGrama\") VALUES (1,'R','Creme de morango',0.32);\n"
                        + "INSERT INTO \"Caracteristica\" (\"id\",\"tipo\",\"nome\",\"valorGrama\") VALUES (2,'F','Redonda 20cm',0.0625);\n"
                        + "INSERT INTO \"Caracteristica\" (\"id\",\"tipo\",\"nome\",\"valorGrama\") VALUES (3,'C','Azul',0);\n"
                        + "INSERT INTO \"Caracteristica\" (\"id\",\"tipo\",\"nome\",\"valorGrama\") VALUES (4,'T','Glacê de limão',0.023);\n"
                        + "INSERT INTO \"Caracteristica\" (\"id\",\"tipo\",\"nome\",\"valorGrama\") VALUES (5,'R','Ganache meio amargo',0.57);\n"
                        + "INSERT INTO \"Forma\" (\"id\",\"recheios\",\"gramaRecheio\",\"gramaCobertura\",\"gramaMassa\") VALUES (2,1,100,150,800);\n"
                        + "INSERT INTO \"ProdutoPersonalizado_Recheio\" (\"idProdutoPersonalizado\",\"idRecheio\") VALUES (1,5);\n";

                String[] updates = sql.split("\n");
                for (String update : updates) {
                    stmt.addBatch(update);
                }

                stmt.executeBatch();
                conn.commit();
            }

            conn.setAutoCommit(true);

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fechaConexao(conn);
        }
    }
}
