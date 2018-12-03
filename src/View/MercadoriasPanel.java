/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Mercadoria;
import Table.TabelaMercadoria;
import Table.TabelaVenda;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MercadoriasPanel extends javax.swing.JPanel { 
    private static int idLinha = 0; 
    
    private final int INSERIR = 1;
    private final int ALTERAR = 2;

    private List<Mercadoria> lista;
    private static TabelaMercadoria dadosTabela;
    
    public MercadoriasPanel() {
        initComponents();
        inicializar();
    }

    private void inicializar()
    {
        lista = new ArrayList<>();
        dadosTabela = new TabelaMercadoria(lista);
        tableMercadoria.setModel(dadosTabela);
    }
    public static void adicionarNaTabela (Mercadoria mercadoria){
        dadosTabela.adicionar(mercadoria);
    }
    
    public static void deletarNaTabela(int linha)
    {
        dadosTabela.excluir(linha);
    }
    
    @SuppressWarnings("empty-statement")
    public static void limparTabela()
    {        
        while(tableMercadoria.getRowCount() > 0)
        {
            deletarNaTabela(0);
        }
    }
    
    public static void listarTodosGrid(String campo, String valor)
    {
        limparTabela();
        ArrayList<Mercadoria> arrayList = Mercadoria.listarTodas(campo, valor);
        limparTabela();
        
        for(Mercadoria mercadoria : arrayList)
        {
            dadosTabela.adicionar(mercadoria);
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
        lblTituloMercadorias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMercadoria = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        bttnPesquisar = new javax.swing.JButton();
        pnlBttn = new javax.swing.JPanel();
        bttnInserir = new javax.swing.JButton();
        bttnAlterar = new javax.swing.JButton();
        bttnExcluir = new javax.swing.JButton();
        comboPesquisa = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTituloMercadorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTituloMercadorias.setText("Cadastro de Mercadorias");

        tableMercadoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMercadoria.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableMercadoria);

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
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
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

        pnlBttn.setLayout(new java.awt.GridLayout(1, 0));

        bttnInserir.setBackground(new java.awt.Color(255, 255, 255));
        bttnInserir.setText("Inserir");
        bttnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnInserirActionPerformed(evt);
            }
        });
        pnlBttn.add(bttnInserir);

        bttnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        bttnAlterar.setText("Alterar");
        bttnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAlterarActionPerformed(evt);
            }
        });
        pnlBttn.add(bttnAlterar);

        bttnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        bttnExcluir.setText("Excluir");
        bttnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnExcluirActionPerformed(evt);
            }
        });
        pnlBttn.add(bttnExcluir);

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CÃ³digo", "DescriÃ§Ã£o(Ativo)", "DescriÃ§Ã£o(Todos)" }));
        comboPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPesquisaActionPerformed(evt);
            }
        });
        comboPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboPesquisaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTituloMercadorias))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloMercadorias)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bttnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesquisa)
                    .addComponent(comboPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBttn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMouseClicked
        
    }//GEN-LAST:event_txtPesquisaMouseClicked

    private void txtPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisaFocusLost
        if("".equals(txtPesquisa.getText()))
        {
            txtPesquisa.setText("Pesquisar...");
        }
    }//GEN-LAST:event_txtPesquisaFocusLost

    private void bttnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPesquisarActionPerformed
        if("Pesquisar...".equals(txtPesquisa.getText()))
        {
            txtPesquisa.setText(null);
        }

        listarTodosGrid(comboPesquisa.getSelectedItem().toString(), txtPesquisa.getText());
    }//GEN-LAST:event_bttnPesquisarActionPerformed

    private void bttnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnInserirActionPerformed
        JFrame jFrameMercadoria = new MercadoriasCadastro(null, INSERIR);
        jFrameMercadoria.setTitle("Cadastro de Mercadoria - Inserindo");
        jFrameMercadoria.show();
    }//GEN-LAST:event_bttnInserirActionPerformed

    private void bttnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAlterarActionPerformed
        if(temLinhaSelecionada() == true)
        {
            idLinha = tableMercadoria.getSelectedRow();
            Mercadoria mercadoria = Mercadoria.listarUma((int) tableMercadoria.getValueAt(idLinha, 0));
            JFrame jFrameMercadoria = new MercadoriasCadastro(mercadoria, ALTERAR);
            jFrameMercadoria.setTitle("Cadastro de Pessoa - Alterando");
            jFrameMercadoria.show();
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarSelecioneUmRegistro();
        }
    }//GEN-LAST:event_bttnAlterarActionPerformed

    private void bttnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnExcluirActionPerformed
        if(temLinhaSelecionada() == true)
        {
            if(Mercadoria.deletarMercadoria((int) tableMercadoria.getValueAt(tableMercadoria.getSelectedRow(), 0)) == true)
            {
                Helper.MostrarMensagem.mostrarErroMensagem("Registro excluído com sucesso!");
                idLinha = tableMercadoria.getSelectedRow();
                limparTabela();
                listarTodosGrid(comboPesquisa.getSelectedItem().toString(), txtPesquisa.getText());
            }
            else
            {
                Helper.MostrarMensagem.mostrarErroMensagem("Falha na exclusão do registro");
            }
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarSelecioneUmRegistro();
        }
    }//GEN-LAST:event_bttnExcluirActionPerformed

    private void comboPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboPesquisaKeyPressed
        limparTabela();
    }//GEN-LAST:event_comboPesquisaKeyPressed

    private void comboPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPesquisaActionPerformed
        MercadoriasPanel.limparTabela();
    }//GEN-LAST:event_comboPesquisaActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        if("Pesquisar...".equals(txtPesquisa.getText()))
        {
            txtPesquisa.setText("");
        }
    }//GEN-LAST:event_txtPesquisaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAlterar;
    private javax.swing.JButton bttnExcluir;
    private javax.swing.JButton bttnInserir;
    private javax.swing.JButton bttnPesquisar;
    private javax.swing.JComboBox<String> comboPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloMercadorias;
    private javax.swing.JPanel pnlBttn;
    private static javax.swing.JTable tableMercadoria;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    private Object newImageIcon(URL resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
