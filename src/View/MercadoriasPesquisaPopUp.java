/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Mercadoria;

import Table.TabelaMercadoria;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leandro
 */
public class MercadoriasPesquisaPopUp extends javax.swing.JFrame {

    /**
     * Creates new form PessoasPesquisaPopUp
     */
    public MercadoriasPesquisaPopUp() {
        initComponents();
        inicializar();
        setIcon();
    }
    
    private static List<Mercadoria>lista;    
    private static TabelaMercadoria dadosTabela;
    private int idLinha = 0;
    
    private void inicializar(){
        lista = new ArrayList<>();
        dadosTabela = new TabelaMercadoria(lista);
        tableMercadoria.setModel(dadosTabela);
    }
    
    public static void deletarNaTabela(int linha)
    {
        dadosTabela.excluir(linha);
    }
    
    public static void listarTodosGrid(String campo, String valor)
    {
        limparTabela();
        ArrayList<Mercadoria> arrayList = Mercadoria.listarTodas(campo, valor);
        
        for(Mercadoria mercadoria : arrayList)
        {
            dadosTabela.adicionar(mercadoria);
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static void limparTabela()
    {        
        while(tableMercadoria.getSelectedRow() == 0)
        {
            deletarNaTabela(0);
        }
    }
    
    private static boolean temLinhaSelecionada()
    {
        if(tableMercadoria.getSelectedRow() == -1)
        {
            return false;
        }
        
        else
        {
            return true;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        bttnPesquisar = new javax.swing.JButton();
        lblTituloMercadorias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMercadoria = new javax.swing.JTable();
        comboPesquisa = new javax.swing.JComboBox<>();
        bttnSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPesquisaFocusLost(evt);
            }
        });
        txtPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisaMouseClicked(evt);
            }
        });

        bttnPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        bttnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/magnifying-glass (1).png"))); // NOI18N
        bttnPesquisar.setBorderPainted(false);
        bttnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPesquisarActionPerformed(evt);
            }
        });

        lblTituloMercadorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTituloMercadorias.setText("Cadastro de Mercadorias");

        tableMercadoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableMercadoria);

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Descrição" }));

        bttnSelecionar.setText("Selecionar");
        bttnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(529, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTituloMercadorias)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bttnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 214, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(bttnSelecionar)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTituloMercadorias)
                    .addGap(11, 11, 11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPesquisa)
                        .addComponent(comboPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(bttnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addGap(35, 35, 35)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisaFocusLost
        if("".equals(txtPesquisa.getText()))
        {
            txtPesquisa.setText("Pesquisar...");
        }
    }//GEN-LAST:event_txtPesquisaFocusLost

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked

    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void bttnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPesquisarActionPerformed
        listarTodosGrid(comboPesquisa.getSelectedItem().toString(), txtPesquisa.getText());
    }//GEN-LAST:event_bttnPesquisarActionPerformed

    private void bttnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSelecionarActionPerformed
        if(temLinhaSelecionada() == true)
        {
            idLinha = tableMercadoria.getSelectedRow();
            Mercadoria mercadoria = Mercadoria.listarUma((int) tableMercadoria.getValueAt(idLinha, 0));
            VendasCadastro.mercadoria = mercadoria;
            
            this.dispose();
            VendasCadastro.atualizarCampos();
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarErroMensagem("É necessário selecionar um registro para essa operação!");
        }
    }//GEN-LAST:event_bttnSelecionarActionPerformed

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
            java.util.logging.Logger.getLogger(MercadoriasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MercadoriasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MercadoriasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MercadoriasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MercadoriasPesquisaPopUp().setVisible(true);
            }
        });
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnPesquisar;
    private javax.swing.JButton bttnSelecionar;
    private javax.swing.JComboBox<String> comboPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloMercadorias;
    private static javax.swing.JTable tableMercadoria;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
