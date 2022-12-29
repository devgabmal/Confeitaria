/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.lugar.view;

import com.lugar.controller.Conexao;
import com.lugar.model.Cliente;
import com.lugar.model.Endereco;
import javax.swing.JOptionPane;

/**
 *
 * @author lugar
 */
public class CadastroCliente extends javax.swing.JDialog {

    public CadastroCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        painelFormulario = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        painelCampos = new javax.swing.JPanel();
        textoNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JFormattedTextField();
        textoSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        textoNomeUsuario = new javax.swing.JLabel();
        campoNomeUsuario = new javax.swing.JFormattedTextField();
        textoEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JFormattedTextField();
        textoTelefone = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JFormattedTextField();
        campoEndereco = new javax.swing.JFormattedTextField();
        textoEndereco = new javax.swing.JLabel();
        textoIdentificador = new javax.swing.JLabel();
        textoCartaoCredito = new javax.swing.JLabel();
        campoCartao = new javax.swing.JFormattedTextField();
        campoIdentificador = new javax.swing.JFormattedTextField();
        painelBotoes1 = new javax.swing.JPanel();
        botaoCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        painelFormulario.setLayout(new java.awt.GridBagLayout());

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        painelFormulario.add(titulo, gridBagConstraints);

        painelCampos.setLayout(new java.awt.GridBagLayout());

        textoNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(textoNome, gridBagConstraints);

        campoNome.setText("rodrogo");
        campoNome.setPreferredSize(new java.awt.Dimension(200, 22));
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoNome, gridBagConstraints);

        textoSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoSenha.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(textoSenha, gridBagConstraints);

        campoSenha.setText("senha");
        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoSenha, gridBagConstraints);

        textoNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoNomeUsuario.setText("Nome de Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(textoNomeUsuario, gridBagConstraints);

        campoNomeUsuario.setText("rodcode2");
        campoNomeUsuario.setPreferredSize(new java.awt.Dimension(200, 22));
        campoNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeUsuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoNomeUsuario, gridBagConstraints);

        textoEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoEmail.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(textoEmail, gridBagConstraints);

        campoEmail.setText("rodwe@gmail.com");
        campoEmail.setPreferredSize(new java.awt.Dimension(200, 22));
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoEmail, gridBagConstraints);

        textoTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoTelefone.setText("Telefone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(textoTelefone, gridBagConstraints);

        campoTelefone.setText("24999679969");
        campoTelefone.setPreferredSize(new java.awt.Dimension(200, 22));
        campoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefoneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoTelefone, gridBagConstraints);

        campoEndereco.setText("rua das mansoes");
        campoEndereco.setPreferredSize(new java.awt.Dimension(200, 22));
        campoEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEnderecoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoEndereco, gridBagConstraints);

        textoEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoEndereco.setText("Endereço");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(textoEndereco, gridBagConstraints);

        textoIdentificador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoIdentificador.setText("CPF / CNPJ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        painelCampos.add(textoIdentificador, gridBagConstraints);

        textoCartaoCredito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoCartaoCredito.setText("Cartão de Crédito:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(textoCartaoCredito, gridBagConstraints);

        campoCartao.setText("4444123412341234");
        campoCartao.setPreferredSize(new java.awt.Dimension(200, 22));
        campoCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCartaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoCartao, gridBagConstraints);

        campoIdentificador.setText("11111122280");
        campoIdentificador.setPreferredSize(new java.awt.Dimension(200, 22));
        campoIdentificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdentificadorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        painelCampos.add(campoIdentificador, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        painelFormulario.add(painelCampos, gridBagConstraints);

        painelBotoes1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        painelBotoes1.add(botaoCadastrar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        painelFormulario.add(painelBotoes1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(painelFormulario, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int validaCadastro(String nomeForm,
            String nomeUsuarioForm,
            String senhaForm,
            String emailForm,
            String telefoneForm,
            String enderecoForm,
            String cartaoForm,
            String identificadorForm) {
        if (nomeForm.isBlank() || nomeUsuarioForm.isBlank()
                || senhaForm.isBlank() || emailForm.isBlank()
                || telefoneForm.isBlank() || enderecoForm.isBlank()
                || cartaoForm.isBlank() || identificadorForm.isBlank()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            return -1;
        } else if (nomeUsuarioForm.contains(" ")
                || senhaForm.contains(" ")
                || emailForm.contains(" ")
                || cartaoForm.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Os campos nome de usuário, senha, email e cartão não devem conter espaço");
            return -2;
        } else if (cartaoForm.length() != 16) {
            JOptionPane.showMessageDialog(null, "Numero de cartao invalido");
            return -3;
        } /*
        TODO tratar CNPJ e CPF
        else if (identificadorForm.length() != 11) {
            JOptionPane.showMessageDialog(null, "Numero de cartao invalido");
            return 3;}*/ else {
            return 0;
        }
    }
    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        String nomeForm = campoNome.getText().trim();
        String nomeUsuarioForm = campoNomeUsuario.getText().trim();
        String senhaForm = String.valueOf(campoSenha.getPassword()).trim();
        String emailForm = campoEmail.getText().trim();
        String telefoneForm = campoTelefone.getText().trim();
        String enderecoForm = campoEndereco.getText().trim(); //MEXER
        int idEndereço = 1;
        String cartaoForm = campoCartao.getText().trim();
        String identificadorForm = campoIdentificador.getText().trim();

        if (validaCadastro(nomeForm, nomeUsuarioForm, senhaForm, emailForm, telefoneForm, enderecoForm, cartaoForm, identificadorForm) == 0) {
            Endereco endereco = new Endereco("120", "ao lado predio azul", "rua dos bobos", "japuiba", "angra", "rj", "12348-00");
            int resultado = Conexao.insereCliente(
                    new Cliente(0, nomeForm, nomeUsuarioForm, senhaForm, false,
                            emailForm, telefoneForm, idEndereço, cartaoForm, identificadorForm, endereco)
            );
            if (resultado == 0) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                this.dispose();
            } else if (resultado == -2) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro! O usuário preenchido já existe no sistema.");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro! Tente novamente mais tarde.");
            }
        }

    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void campoEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEnderecoActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    private void campoNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeUsuarioActionPerformed

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void campoIdentificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdentificadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdentificadorActionPerformed

    private void campoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefoneActionPerformed

    private void campoCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCartaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCartaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroCliente dialog = new CadastroCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JFormattedTextField campoCartao;
    private javax.swing.JFormattedTextField campoEmail;
    private javax.swing.JFormattedTextField campoEndereco;
    private javax.swing.JFormattedTextField campoIdentificador;
    private javax.swing.JFormattedTextField campoNome;
    private javax.swing.JFormattedTextField campoNomeUsuario;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JPanel painelBotoes1;
    private javax.swing.JPanel painelCampos;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JLabel textoCartaoCredito;
    private javax.swing.JLabel textoEmail;
    private javax.swing.JLabel textoEndereco;
    private javax.swing.JLabel textoIdentificador;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoNomeUsuario;
    private javax.swing.JLabel textoSenha;
    private javax.swing.JLabel textoTelefone;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
