/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.lugar.view.cliente;

import com.lugar.view.funcionario.*;
import com.lugar.confeitaria.Util;
import static com.lugar.confeitaria.Util.formataDiaHora;
import com.lugar.controller.Conexao;
import com.lugar.model.ExcecaoCampoInvalido;
import com.lugar.model.ExcecaoDataPassada;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lugar
 */
public class ConfirmacaoPedido extends javax.swing.JDialog {

    java.awt.Frame pai;
    boolean confirmado;
    LocalDateTime dataHota;
    String comentario;
    static float valorTotal;

    public ConfirmacaoPedido(java.awt.Frame parent, boolean modal, float valorTotal) {
        super(parent, modal);
        this.pai = parent;
        this.confirmado = false;
        this.valorTotal = valorTotal;
        initComponents();
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public LocalDateTime getDataHota() {
        return dataHota;
    }

    public String getComentario() {
        return comentario;
    }

    private LocalDateTime validaCampos(String dataForm, String horaForm) throws ExcecaoCampoInvalido, ExcecaoDataPassada {
        if (!Util.dataValida(dataForm)) {
            throw new ExcecaoCampoInvalido("data");
        }
        if (!Util.dataPassada(dataForm)) {
            throw new ExcecaoDataPassada();
        }
        if (!Util.horaValida(horaForm + ":00")) {
            throw new ExcecaoCampoInvalido("hora");
        }

        LocalDateTime dataHora = LocalDateTime.parse(dataForm + " " + horaForm + ":00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return dataHora;
    }

    private void confirmarPedido() {
        String dataForm = campoData.getText().trim();
        String horaForm = campoHora.getText().trim();
        String comentarioForm = areaTextoComentario.getText().trim();

        try {
            this.dataHota = validaCampos(dataForm, horaForm);
            this.comentario = comentarioForm;
            this.confirmado = true;
            this.dispose();
        } catch (ExcecaoCampoInvalido ex) {
            JOptionPane.showMessageDialog(this.pai, "Não foi possível realizar o cadastro! Um ou mais campos foram preenchidos incorretamente.", "Erro", JOptionPane.WARNING_MESSAGE);
        } catch (ExcecaoDataPassada ex) {
            JOptionPane.showMessageDialog(this.pai, "Não foi possível realizar o cadastro! A data de entrega precisa ser ao menos um dia após a atual.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
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
        painelInformacoesProduto = new javax.swing.JPanel();
        textoPrecoProduto = new javax.swing.JLabel();
        painelCampos = new javax.swing.JPanel();
        textoData = new javax.swing.JLabel();
        campoData = new javax.swing.JFormattedTextField();
        textoHora = new javax.swing.JLabel();
        campoHora = new javax.swing.JFormattedTextField();
        textoComentario = new javax.swing.JLabel();
        painelAreaTextoComentario = new javax.swing.JScrollPane();
        areaTextoComentario = new javax.swing.JTextPane();
        painelBotoes = new javax.swing.JPanel();
        botaoConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmação de Pedido");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        painelFormulario.setLayout(new java.awt.GridBagLayout());

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Confirmação de Pedido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        painelFormulario.add(titulo, gridBagConstraints);

        painelInformacoesProduto.setLayout(new java.awt.GridBagLayout());

        textoPrecoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoPrecoProduto.setText("R$ 0,00");
        textoPrecoProduto.setText("Valor R$ " + valorTotal);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        painelInformacoesProduto.add(textoPrecoProduto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        painelFormulario.add(painelInformacoesProduto, gridBagConstraints);

        painelCampos.setLayout(new java.awt.GridBagLayout());

        textoData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoData.setText("Data de Entrega:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        painelCampos.add(textoData, gridBagConstraints);

        campoData.setForeground(new java.awt.Color(153, 153, 153));
        campoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        campoData.setText("dd/mm/aaaa");
        campoData.setPreferredSize(new java.awt.Dimension(200, 22));
        campoData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoDataFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDataFocusLost(evt);
            }
        });
        campoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoData, gridBagConstraints);

        textoHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoHora.setText("Horário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        painelCampos.add(textoHora, gridBagConstraints);

        campoHora.setForeground(new java.awt.Color(153, 153, 153));
        campoHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        campoHora.setText("hh:mm");
        campoHora.setPreferredSize(new java.awt.Dimension(200, 22));
        campoHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoHoraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoHoraFocusLost(evt);
            }
        });
        campoHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHoraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(campoHora, gridBagConstraints);

        textoComentario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoComentario.setText("Comentário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        painelCampos.add(textoComentario, gridBagConstraints);

        areaTextoComentario.setText("\n\n");
        painelAreaTextoComentario.setViewportView(areaTextoComentario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        painelCampos.add(painelAreaTextoComentario, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        painelFormulario.add(painelCampos, gridBagConstraints);

        painelBotoes.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoConfirmar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        painelFormulario.add(painelBotoes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(painelFormulario, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        this.confirmarPedido();
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void campoHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoHoraActionPerformed

    private void campoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataActionPerformed

    private void campoDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDataFocusGained
        if (campoData.getText().equals("dd/mm/aaaa")) {
            campoData.setText("");
            campoData.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_campoDataFocusGained

    private void campoHoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoHoraFocusGained
        if (campoHora.getText().equals("hh:mm")) {
            campoHora.setText("");
            campoHora.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_campoHoraFocusGained

    private void campoDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDataFocusLost
        if (campoData.getText().equals("")) {
            campoData.setForeground(new Color(153, 153, 153));
            campoData.setText("dd/mm/aaaa");
        }
    }//GEN-LAST:event_campoDataFocusLost

    private void campoHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoHoraFocusLost
        if (campoHora.getText().equals("")) {
            campoHora.setForeground(new Color(153, 153, 153));
            campoHora.setText("hh:mm");
        }
    }//GEN-LAST:event_campoHoraFocusLost

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
            java.util.logging.Logger.getLogger(ConfirmacaoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmacaoPedido dialog = new ConfirmacaoPedido(new javax.swing.JFrame(), true, valorTotal);
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
    private javax.swing.JTextPane areaTextoComentario;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JFormattedTextField campoData;
    private javax.swing.JFormattedTextField campoHora;
    private javax.swing.JScrollPane painelAreaTextoComentario;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelCampos;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelInformacoesProduto;
    private javax.swing.JLabel textoComentario;
    private javax.swing.JLabel textoData;
    private javax.swing.JLabel textoHora;
    private javax.swing.JLabel textoPrecoProduto;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
