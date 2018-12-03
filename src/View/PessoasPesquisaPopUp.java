/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Pessoa;
import Table.TabelaPessoa;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leandro
 */
public class PessoasPesquisaPopUp extends javax.swing.JFrame {

    /**
     * Creates new form PessoasPesquisaPopUp
     */
    public PessoasPesquisaPopUp() {
        initComponents();
        inicializar();
        setIcon();
    }
    
    private static List<Pessoa>lista;    
    private static TabelaPessoa dadosTabela;
    private int idLinha = 0;
    
    private void inicializar(){
        lista = new ArrayList<>();
        dadosTabela = new TabelaPessoa(lista);
        tablePessoa.setModel(dadosTabela);
    }
    
    public static void deletarNaTabela(int linha)
    {
        dadosTabela.excluir(linha);
    }
    
    public static void listarTodosGrid(String campo, String valor)
    {
        limparTabela();
        ArrayList<Pessoa> arrayList = Pessoa.listarTodas(campo, valor);
        
        for(Pessoa pessoa : arrayList)
        {
            dadosTabela.adicionar(pessoa);
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static void limparTabela()
    {        
        while(tablePessoa.getSelectedRow() == 0)
        {
            deletarNaTabela(0);
        }
    }
    
    private static boolean temLinhaSelecionada()
    {
        if(tablePessoa.getSelectedRow() == -1)
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
        lblTituloPessoas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePessoa = new javax.swing.JTable();
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

        lblTituloPessoas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTituloPessoas.setText("Cadastro de Pessoas");

        tablePessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablePessoa);

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF/CNPJ", "Nome(Ativos)", "Nome(Todos)" }));

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
                                .addComponent(lblTituloPessoas)
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
                    .addComponent(lblTituloPessoas)
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
            idLinha = tablePessoa.getSelectedRow();
            Pessoa pessoa = Pessoa.listarUma((int) tablePessoa.getValueAt(idLinha, 0));
            VendasCadastro.pessoa = pessoa;
            
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
            java.util.logging.Logger.getLogger(PessoasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessoasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessoasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessoasPesquisaPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PessoasPesquisaPopUp().setVisible(true);
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
    private javax.swing.JLabel lblTituloPessoas;
    private static javax.swing.JTable tablePessoa;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
