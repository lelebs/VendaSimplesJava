package View;

import Exception.BancoException;
import Exception.CampoValorZeroException;
import Exception.CampoVazioException;
import Exception.ConverterCamposDoubleException;
import Exception.LimiteCampoException;
import Model.Mercadoria;
import java.awt.Toolkit;
import java.sql.SQLException;

public class MercadoriasCadastro extends javax.swing.JFrame {

    private int idMercadoria = 0;
    private int acaoFrame = 0;
    private final int INSERIR = 1;
    private final int ALTERAR = 2;
    
    private void receberMercadoria(Mercadoria mercadoria)
    {
        if(mercadoria != null)
        {
            idMercadoria = mercadoria.getIdMercadoria();
            this.txtCodigo.setText(mercadoria.getCodigo());
            this.txtDescricao.setText(mercadoria.getDescricao());
            this.txtValor.setText(String.valueOf(mercadoria.getValor()).replace(".", ","));
            if("Não".equals(mercadoria.isAtivo()))
            {
                this.checkAtivo.setSelected(false);
            }
        }
    }
    
    public MercadoriasCadastro(Mercadoria mercadoria, int acao) {
        initComponents();
        receberMercadoria(mercadoria);
        setIcon();
        acaoFrame = acao;
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        checkAtivo = new javax.swing.JCheckBox();
        panelButtons = new javax.swing.JPanel();
        bttnSalvar = new javax.swing.JButton();
        bttnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoa - Inserindo");
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblCodigo.setText("CÃ³digo");

        lblDescricao.setText("DescriÃ§Ã£o");

        lblValor.setText("Valor de Venda");

        txtValor.setText("1,00");

        checkAtivo.setBackground(new java.awt.Color(255, 255, 255));
        checkAtivo.setSelected(true);
        checkAtivo.setText("Ativo");

        panelButtons.setLayout(new java.awt.GridLayout(1, 0));

        bttnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        bttnSalvar.setText("Salvar");
        bttnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttnSalvarMouseClicked(evt);
            }
        });
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkAtivo))
                            .addComponent(txtDescricao)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescricao)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblValor))
                                .addGap(326, 326, 326))))
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescricao)
                .addGap(6, 6, 6)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lblValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Cadastro de Mercadorias - Inserindo");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttnSalvarMouseClicked
        
    }//GEN-LAST:event_bttnSalvarMouseClicked

    private void bttnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSalvarActionPerformed

        double valor = 0.0;
        
        try
        {
            String codigoStr = txtCodigo.getText();
            String descricaoStr = txtDescricao.getText();
            String valorStr = txtValor.getText();
            
            Helper.ConverterCamposHelper.validarCampoVazio("Código", codigoStr);
            Helper.ConverterCamposHelper.validarCampoVazio("Descrição", descricaoStr);
            Helper.ConverterCamposHelper.validarCampoVazio("Valor", valorStr);
            
            Helper.ConverterCamposHelper.validarCampoValorZero("Valor", valor, 0.0);
            
            Helper.ConverterCamposHelper.validarMaiorQue("Código", codigoStr, 8);
            Helper.ConverterCamposHelper.validarMaiorQue("Descrição", descricaoStr, 20);
                    
            valor = Helper.ConverterCamposHelper.converterDouble("Valor", valorStr);
            
            Mercadoria mercadoria = new Mercadoria();
            mercadoria.setCodigo(codigoStr);
            mercadoria.setDescricao(descricaoStr);
            mercadoria.setValor(valor);
            if(checkAtivo.isSelected())
            {
                mercadoria.setAtivo("Sim");
            }
            else
            {
                mercadoria.setAtivo("Não");
            }

            if(acaoFrame == INSERIR && Mercadoria.validarSeCodigoExiste(mercadoria.getCodigo()) == false)
            {
                mercadoria = Mercadoria.inserirMercadoria(mercadoria);
                MercadoriasPanel.adicionarNaTabela(mercadoria);
                this.dispose();
            }

            else if(acaoFrame == INSERIR && Mercadoria.validarSeCodigoExiste(mercadoria.getCodigo()) == true)
            {
                Helper.MostrarMensagem.mostrarErroMensagem("Registro já cadastrado!");
            }

            else if(acaoFrame == ALTERAR && Mercadoria.permitirAlteracao(mercadoria.getIdMercadoria(), mercadoria.getCodigo()) == false)
            {
                mercadoria.setIdMercadoria(idMercadoria);
                MercadoriasPanel.limparTabela();
                MercadoriasPanel.adicionarNaTabela(Mercadoria.alterarMercadoria(mercadoria));
                this.dispose();
            }
            
            else
            {
                Helper.MostrarMensagem.mostrarErroMensagem("Registro já cadastrado!");
            }
        }
        
        catch(ConverterCamposDoubleException | LimiteCampoException | CampoVazioException | CampoValorZeroException | BancoException ex)
        {
            Helper.MostrarMensagem.mostrarErroMensagem(ex.getMessage());
        }        
    }//GEN-LAST:event_bttnSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void bttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bttnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(MercadoriasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MercadoriasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MercadoriasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MercadoriasCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(Mercadoria mercadoria, int acao) {
                new MercadoriasCadastro(mercadoria, acao).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnCancelar;
    private javax.swing.JButton bttnSalvar;
    private javax.swing.JCheckBox checkAtivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
