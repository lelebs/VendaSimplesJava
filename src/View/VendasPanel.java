/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Venda;
import Model.VendaTable;
import Table.TabelaVenda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author leandro
 */
public class VendasPanel extends javax.swing.JPanel {

    /**
     * Creates new form VendasPanel
     */
    public VendasPanel() {
        initComponents();
        inicializar();
    }
    
    private int idLinha = 0;
    private static List<VendaTable>lista;    
    private static TabelaVenda dadosTabela;

    private void inicializar(){
        lista = new ArrayList<>();
        dadosTabela = new TabelaVenda(lista);
        tableVenda.setModel(dadosTabela);
    }

    public static void adicionarNaTabela (VendaTable vendaTable){
        dadosTabela.adicionar(vendaTable);
    }
    
    public static void deletarNaTabela(int linha)
    {
        dadosTabela.excluir(linha);
    }
    
    @SuppressWarnings("empty-statement")
    public static void limparTabela()
    {        
        while(tableVenda.getRowCount() > 0)
        {
            deletarNaTabela(0);
        }
    }
    
    public static void listarTodosGrid(String campo, String valor)
    {
        limparTabela();
        ArrayList<VendaTable> arrayList = Venda.listarTodas(campo, valor);
        limparTabela();
        
        for(VendaTable vendaTable : arrayList)
        {
            dadosTabela.adicionar(vendaTable);
        }
    }
    
    private static boolean temLinhaSelecionada()
    {
        if(tableVenda.getSelectedRow() == -1)
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
        lblTituloVendas = new javax.swing.JLabel();
        comboPesquisa = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        bttnPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bttnInserir = new javax.swing.JButton();
        bttnAlterar = new javax.swing.JButton();
        bttnReabrir = new javax.swing.JButton();
        bttnCancelar = new javax.swing.JButton();
        bttnConcluir = new javax.swing.JButton();
        bttnVisualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVenda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(660, 428));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTituloVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTituloVendas.setText("Cadastro de Vendas");

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Pessoa" }));

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

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        bttnInserir.setBackground(new java.awt.Color(255, 255, 255));
        bttnInserir.setText("Inserir");
        bttnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnInserirActionPerformed(evt);
            }
        });
        jPanel2.add(bttnInserir);

        bttnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        bttnAlterar.setText("Alterar");
        bttnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(bttnAlterar);

        bttnReabrir.setBackground(new java.awt.Color(255, 255, 255));
        bttnReabrir.setText("Reabrir");
        bttnReabrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnReabrirActionPerformed(evt);
            }
        });
        jPanel2.add(bttnReabrir);

        bttnCancelar.setText("Cancelar");
        bttnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(bttnCancelar);

        bttnConcluir.setText("Concluir");
        bttnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConcluirActionPerformed(evt);
            }
        });
        jPanel2.add(bttnConcluir);

        bttnVisualizar.setText("Visualizar");
        bttnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnVisualizarActionPerformed(evt);
            }
        });
        jPanel2.add(bttnVisualizar);

        tableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableVenda);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconGrafico.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTituloVendas)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloVendas)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bttnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisa)
                    .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(166, 166, 166))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisaFocusLost

    }//GEN-LAST:event_txtPesquisaFocusLost

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked

    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void bttnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPesquisarActionPerformed
        listarTodosGrid(comboPesquisa.getSelectedItem().toString(), txtPesquisa.getText());
    }//GEN-LAST:event_bttnPesquisarActionPerformed

    private void bttnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnInserirActionPerformed
        JFrame jFrameVenda = new VendasCadastro(null, "i");
        jFrameVenda.show();
    }//GEN-LAST:event_bttnInserirActionPerformed

    private void bttnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAlterarActionPerformed
        if(temLinhaSelecionada() == true)
        {
            int idVenda = (int) tableVenda.getValueAt(tableVenda.getSelectedRow(), 0);
            
            if("ABERTA".equals(Venda.verificarSituacao(idVenda)))
            {
                Venda venda = Venda.listarUma(idVenda);
                JFrame jFrameVenda = new VendasCadastro(venda, "a");
                jFrameVenda.show();
            }

            else
            {
                Helper.MostrarMensagem.mostrarErroMensagem("Somente é permitido alterar venda com situação [ABERTA]");
            }
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarSelecioneUmRegistro();
        }
    }//GEN-LAST:event_bttnAlterarActionPerformed

    private void bttnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConcluirActionPerformed
        if(temLinhaSelecionada() == true)
        {
            int idVenda = (int) tableVenda.getValueAt(tableVenda.getSelectedRow(), 0);
            
            switch(Venda.verificarSituacao(idVenda))
            {
                case "ABERTA": 
                    limparTabela();
                    Date data = new Date();
                    adicionarNaTabela(Venda.concluirVenda(idVenda, data));
                    Helper.MostrarMensagem.mostrarErroMensagem("Venda Conluída com Sucesso!");
                    break;
                    
                default:
                    Helper.MostrarMensagem.mostrarErroMensagem("Somente é permitido concluir venda com situação [ABERTA]"); 
                    break;
            }
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarSelecioneUmRegistro();
        }
    }//GEN-LAST:event_bttnConcluirActionPerformed

    private void bttnReabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnReabrirActionPerformed
        if(temLinhaSelecionada() == true)
        {
            int idVenda = (int) tableVenda.getValueAt(tableVenda.getSelectedRow(), 0);
            
            switch(Venda.verificarSituacao(idVenda))
            {
                case "CONCLUÍDA": 
                    limparTabela();
                    adicionarNaTabela(Venda.reabrirVendaConcluida(idVenda, "ABERTA"));
                    Helper.MostrarMensagem.mostrarErroMensagem("Venda Reaberta com Sucesso!");
                    break;
                    
                case "CANCELADA": 
                    adicionarNaTabela(Venda.reabrirVendaCancelada(idVenda));
                    break;
                    
                default:
                    Helper.MostrarMensagem.mostrarErroMensagem("Somente é permitido reabrir venda com situação [CONCLUÍDA] ou [CANCELADA]"); 
                    break;
            }
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarSelecioneUmRegistro();
        }
    }//GEN-LAST:event_bttnReabrirActionPerformed

    private void bttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelarActionPerformed
        if(temLinhaSelecionada() == true)
        {
            idLinha = tableVenda.getSelectedRow();
            int idVenda = (int) tableVenda.getValueAt(idLinha, 0);
            
            switch(Venda.verificarSituacao(idVenda))
            {
                case "ABERTA": 
                    limparTabela();
                    Date data = new Date();
                    adicionarNaTabela(Venda.cancelarVenda(idVenda, data)); 
                    Helper.MostrarMensagem.mostrarErroMensagem("Venda Cancelada com Sucesso!");
                    break;
                    
                default:
                    Helper.MostrarMensagem.mostrarErroMensagem("Somente é permitido cancelar venda com situação [ABERTA]"); 
                    break;
            }
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarSelecioneUmRegistro();
        }
    }//GEN-LAST:event_bttnCancelarActionPerformed

    private void bttnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnVisualizarActionPerformed
        if(temLinhaSelecionada() == true)
        {
            int idVenda = (int) tableVenda.getValueAt(tableVenda.getSelectedRow(), 0);
            

            Venda venda = Venda.listarUma(idVenda);
            JFrame jFrameVenda = new VendasCadastro(venda, "v");
            jFrameVenda.setTitle("Venda - Visualizando");
            jFrameVenda.show();
        }

        
        
        else
        {
            Helper.MostrarMensagem.mostrarSelecioneUmRegistro();
        }
    }//GEN-LAST:event_bttnVisualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame jFrameDashboard = new DashboardForm();
        jFrameDashboard.show();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAlterar;
    private javax.swing.JButton bttnCancelar;
    private javax.swing.JButton bttnConcluir;
    private javax.swing.JButton bttnInserir;
    private javax.swing.JButton bttnPesquisar;
    private javax.swing.JButton bttnReabrir;
    private javax.swing.JButton bttnVisualizar;
    private javax.swing.JComboBox<String> comboPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloVendas;
    private static javax.swing.JTable tableVenda;
    public static javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
