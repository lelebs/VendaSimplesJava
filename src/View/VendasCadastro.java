package View;

import Exception.BancoException;
import Exception.CampoValorZeroException;
import Exception.CampoVazioException;
import Exception.ConverterCamposDoubleException;
import Exception.LimiteCampoException;
import Model.Mercadoria;
import Model.Pessoa;
import Model.Venda;
import Model.VendaTable;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;


public class VendasCadastro extends javax.swing.JFrame {


    public VendasCadastro(Venda venda, String acao) {
        initComponents();
        limparObjeto();
        receberVenda(venda);
        verificarAcao(acao);
        setIcon();
    }

    private void limparObjeto()
    {
        this.pessoa = null;
        this.mercadoria = null;
    }
    public static Pessoa pessoa = null;
    public static Mercadoria mercadoria = null;
    
    public static void atualizarCampos()
    {
        if(pessoa != null)
        {
            VendasCadastro.txtPessoa.setText(pessoa.getIdPessoa() + " - " + pessoa.getRazaoSocial() 
                + " (" + pessoa.getCpfCnpj() + ")");
        }
        
        if(mercadoria  != null)
        {
            VendasCadastro.txtMercadoria.setText(mercadoria.getCodigo() + " - " + mercadoria.getDescricao());
            VendasCadastro.txtValorUnitario.setText(String.valueOf(mercadoria.getValor()));        
            calcularValor();
        }
    }
    
    private static void verificarAcao(String acao)
    {
        if("v".equals(acao))
        {
            bttnPesquisarMercadoria.setEnabled(false);
            bttnPesquisarPessoa.setEnabled(false);
            bttnSalvar.setEnabled(false);
            lblVenda.setText("Venda - Visualizando");
            txtQuantidade.disable();
            txtValorUnitario.disable();
        }
    }
    
    public static void calcularValor()
    {
        double valorUnitario = Helper.ConverterCamposHelper.converterDouble("Valor Unitário", txtValorUnitario.getText());
        double quantidade = Helper.ConverterCamposHelper.converterDouble("Quantidade", txtQuantidade.getText());
        VendasCadastro.txtValorTotal.setText(String.valueOf(quantidade*valorUnitario));
    }
    
    public static void receberVenda(Venda venda)
    {
        if(venda != null)
        {
            txtCodigo.setText(String.valueOf(venda.getIdVenda()));
            pessoa = Pessoa.listarUma(venda.getIdPessoa());
            mercadoria = Mercadoria.listarUma(venda.getIdMercadoria());
            txtValorUnitario.setText(String.valueOf(venda.getValorUnitario()));
            txtQuantidade.setText(String.valueOf(venda.getQuantidade()));
            atualizarCampos();
            lblVenda.setText("Venda - Alterando");
            txtSituacao.setText(venda.getSituacao());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblVenda = new javax.swing.JLabel();
        lblPessoa = new javax.swing.JLabel();
        txtPessoa = new javax.swing.JTextField();
        bttnPesquisarPessoa = new javax.swing.JButton();
        lblMercadoria = new javax.swing.JLabel();
        txtMercadoria = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblValorUnitario = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        lblValorTotal = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        lblVezes = new javax.swing.JLabel();
        lblIgual = new javax.swing.JLabel();
        panelButtons = new javax.swing.JPanel();
        bttnSalvar = new javax.swing.JButton();
        bttnCancelar = new javax.swing.JButton();
        bttnPesquisarMercadoria = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtSituacao = new javax.swing.JTextField();
        lblSituacao = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVenda.setText("Nova Venda");

        lblPessoa.setText("Pessoa:");

        txtPessoa.setEditable(false);

        bttnPesquisarPessoa.setBackground(new java.awt.Color(255, 255, 255));
        bttnPesquisarPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/magnifying-glass (1).png"))); // NOI18N
        bttnPesquisarPessoa.setBorderPainted(false);
        bttnPesquisarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPesquisarPessoaActionPerformed(evt);
            }
        });

        lblMercadoria.setText("Mercadoria:");

        txtMercadoria.setEditable(false);

        lblQuantidade.setText("Quantidade");

        txtQuantidade.setText("1,00");
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        lblValorUnitario.setText("Valor Unitário");

        txtValorUnitario.setText("1,00");
        txtValorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorUnitarioFocusLost(evt);
            }
        });
        txtValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorUnitarioKeyTyped(evt);
            }
        });

        lblValorTotal.setText("Valor Total");

        txtValorTotal.setText("1,00");
        txtValorTotal.setEnabled(false);

        lblVezes.setText("x");

        lblIgual.setText("=");

        panelButtons.setLayout(new java.awt.GridLayout(1, 0));

        bttnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        bttnSalvar.setText("Salvar");
        bttnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSalvarActionPerformed(evt);
            }
        });
        panelButtons.add(bttnSalvar);

        bttnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        bttnCancelar.setText("Cancelar");
        bttnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCancelarActionPerformed(evt);
            }
        });
        panelButtons.add(bttnCancelar);

        bttnPesquisarMercadoria.setBackground(new java.awt.Color(255, 255, 255));
        bttnPesquisarMercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/magnifying-glass (1).png"))); // NOI18N
        bttnPesquisarMercadoria.setBorderPainted(false);
        bttnPesquisarMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPesquisarMercadoriaActionPerformed(evt);
            }
        });

        lblCodigo.setText("Código:");

        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setText("0");
        txtCodigo.setEnabled(false);

        txtSituacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSituacao.setEnabled(false);

        lblSituacao.setText("Situação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPessoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMercadoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMercadoria)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bttnPesquisarPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttnPesquisarMercadoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorUnitario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblVezes)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblQuantidade)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIgual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorTotal)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVenda)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSituacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(369, Short.MAX_VALUE)
                    .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPessoa))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttnPesquisarMercadoria)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMercadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMercadoria))))
                    .addComponent(bttnPesquisarPessoa))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorUnitario)
                    .addComponent(lblQuantidade)
                    .addComponent(lblValorTotal))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVezes))
                .addGap(137, 137, 137))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(229, Short.MAX_VALUE)
                    .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(93, 93, 93)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttnPesquisarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPesquisarPessoaActionPerformed
        JFrame pessoaPesquisaPopUp = new PessoasPesquisaPopUp();
        pessoaPesquisaPopUp.show();
    }//GEN-LAST:event_bttnPesquisarPessoaActionPerformed

    private void bttnPesquisarMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPesquisarMercadoriaActionPerformed
        JFrame mercadoriPesquisaPopUp = new MercadoriasPesquisaPopUp();
        mercadoriPesquisaPopUp.show();
    }//GEN-LAST:event_bttnPesquisarMercadoriaActionPerformed

    private void bttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bttnCancelarActionPerformed

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        calcularValor();
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        calcularValor();
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void bttnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSalvarActionPerformed
        char acao = 'i';
        
        String quantidadeStr = txtQuantidade.getText();
        String valorUnitarioStr = txtValorUnitario.getText();
        String valorTotalStr = txtValorTotal.getText();
        
        if("Venda - Alterando".equals(this.getTitle()))
            acao = 'a';
        
        try
        {
            Helper.ConverterCamposHelper.validarCampoVazio("Pessoa", txtPessoa.getText());
            Helper.ConverterCamposHelper.validarCampoVazio("Mercadoria", txtMercadoria.getText());
            Helper.ConverterCamposHelper.validarCampoVazio("Quantidade", quantidadeStr);
            Helper.ConverterCamposHelper.validarCampoVazio("Valor Unitário", valorTotalStr);
            
            Helper.ConverterCamposHelper.validarMaiorQue("Quantidade", quantidadeStr, 6);
            Helper.ConverterCamposHelper.validarMaiorQue("Valor Unitário", valorUnitarioStr, 6);
            
            double quantidade = Helper.ConverterCamposHelper.converterDouble("Quantidade", quantidadeStr);
            double valorUnitario = Helper.ConverterCamposHelper.converterDouble("Valor Unitário", valorUnitarioStr);
            double valorTotal = Helper.ConverterCamposHelper.converterDouble("Valor total", valorTotalStr);
            
            Helper.ConverterCamposHelper.validarCampoValorZero("Quantidade", quantidade, 0);
            Helper.ConverterCamposHelper.validarCampoValorZero("Valor Unitário", valorUnitario, 0);

            Date data = new Date();
            
            Venda venda = new Venda();
            venda.setIdMercadoria(mercadoria.getIdMercadoria());
            venda.setIdPessoa(pessoa.getIdPessoa());
            venda.setQuantidade(quantidade);
            venda.setValorUnitario(valorUnitario);
            venda.setValorTotal(valorTotal);
            venda.setSituacao("ABERTA");
            venda.setDataCadastro(data);
            
            VendaTable vendaTable = null;
            
            if(acao == 'i')
            {
                vendaTable = Venda.inserirVenda(venda);
                VendasPanel.limparTabela();
                VendasPanel.txtPesquisa.setText("");
                VendasPanel.adicionarNaTabela(vendaTable);
                this.dispose();
            }

            else if(acao == 'a')
            {
                int id = Integer.parseInt(txtCodigo.getText());
                venda.setIdVenda(id);
                VendasPanel.limparTabela();
                VendasPanel.txtPesquisa.setText("");
                VendasPanel.adicionarNaTabela(Venda.alterarVenda(venda));
                this.dispose();
            }
        }
        
        catch(CampoVazioException | LimiteCampoException | ConverterCamposDoubleException | CampoValorZeroException | BancoException ex)
        {
            Helper.MostrarMensagem.mostrarErroMensagem(ex.getMessage());
        }
    }//GEN-LAST:event_bttnSalvarActionPerformed

    private void txtValorUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioKeyTyped
        calcularValor();
    }//GEN-LAST:event_txtValorUnitarioKeyTyped

    private void txtValorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitarioFocusLost
        calcularValor();
    }//GEN-LAST:event_txtValorUnitarioFocusLost

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
            java.util.logging.Logger.getLogger(VendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(Venda venda, String acao) {
                new VendasCadastro(venda, acao).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnCancelar;
    private static javax.swing.JButton bttnPesquisarMercadoria;
    private static javax.swing.JButton bttnPesquisarPessoa;
    private static javax.swing.JButton bttnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblIgual;
    private javax.swing.JLabel lblMercadoria;
    private javax.swing.JLabel lblPessoa;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblValorUnitario;
    private static javax.swing.JLabel lblVenda;
    private javax.swing.JLabel lblVezes;
    private javax.swing.JPanel panelButtons;
    private static javax.swing.JTextField txtCodigo;
    private static javax.swing.JTextField txtMercadoria;
    private static javax.swing.JTextField txtPessoa;
    private static javax.swing.JTextField txtQuantidade;
    private static javax.swing.JTextField txtSituacao;
    private static javax.swing.JTextField txtValorTotal;
    private static javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
