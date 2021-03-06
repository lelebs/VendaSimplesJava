/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author lab4d
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setIcon();
    }
    
    private int inserirNoTab(String nomeFrame, JPanel frame, int quantidade)
    {
        if(validarSeTemTabAberta(nomeFrame, tabMain) == false)
        {
            tabMain.addTab(nomeFrame, frame);
            return quantidade++;
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarErroJanelaAberta(nomeFrame);
            return quantidade-1;
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

        panelFill = new javax.swing.JPanel();
        tabMain = new javax.swing.JTabbedPane();
        panelInicio = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelTop = new javax.swing.JPanel();
        bttnFechar = new javax.swing.JButton();
        bttnPessoas = new javax.swing.JButton();
        bttnMercadorias = new javax.swing.JButton();
        bttnVendas = new javax.swing.JButton();
        bttnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venda Simples");
        setBackground(new java.awt.Color(255, 255, 255));

        panelFill.setBackground(new java.awt.Color(3, 169, 244));

        tabMain.setBackground(new java.awt.Color(255, 255, 255));

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/inicio.PNG"))); // NOI18N
        jLabel1.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
            .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabMain.addTab("Inicio", panelInicio);

        panelTop.setBackground(new java.awt.Color(179, 229, 252));
        panelTop.setLayout(new java.awt.GridLayout(1, 4, 3, 0));

        bttnFechar.setBackground(new java.awt.Color(255, 255, 255));
        bttnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close.png"))); // NOI18N
        bttnFechar.setBorder(null);
        bttnFechar.setBorderPainted(false);
        bttnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnFecharActionPerformed(evt);
            }
        });
        panelTop.add(bttnFechar);

        bttnPessoas.setBackground(new java.awt.Color(255, 255, 255));
        bttnPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user.png"))); // NOI18N
        bttnPessoas.setBorderPainted(false);
        bttnPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPessoasActionPerformed(evt);
            }
        });
        panelTop.add(bttnPessoas);

        bttnMercadorias.setBackground(new java.awt.Color(255, 255, 255));
        bttnMercadorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/screwdriver.png"))); // NOI18N
        bttnMercadorias.setBorderPainted(false);
        bttnMercadorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnMercadoriasActionPerformed(evt);
            }
        });
        panelTop.add(bttnMercadorias);

        bttnVendas.setBackground(new java.awt.Color(255, 255, 255));
        bttnVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/shopping-cart.png"))); // NOI18N
        bttnVendas.setBorderPainted(false);
        bttnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnVendasActionPerformed(evt);
            }
        });
        panelTop.add(bttnVendas);

        bttnExit.setBackground(new java.awt.Color(255, 255, 255));
        bttnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logout.png"))); // NOI18N
        bttnExit.setBorderPainted(false);
        bttnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnExitActionPerformed(evt);
            }
        });
        panelTop.add(bttnExit);

        javax.swing.GroupLayout panelFillLayout = new javax.swing.GroupLayout(panelFill);
        panelFill.setLayout(panelFillLayout);
        panelFillLayout.setHorizontalGroup(
            panelFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
            .addGroup(panelFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabMain, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );
        panelFillLayout.setVerticalGroup(
            panelFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFillLayout.createSequentialGroup()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(446, Short.MAX_VALUE))
            .addGroup(panelFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFillLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(tabMain, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttnPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPessoasActionPerformed
        JPanel pessoas = new PessoasPanel();
        int indice = inserirNoTab("Pessoas", pessoas, tabMain.getTabCount());
        tabMain.setSelectedIndex(indice);
    }//GEN-LAST:event_bttnPessoasActionPerformed

    private boolean validarSeTemTabAberta(String Nome, JTabbedPane tab)
    {
        int i, contador = 0;
        for(i = 0; i<= tab.getTabCount()-1; i++)
        {
            if(tab.getTitleAt(i) == Nome)
            {
                contador++;
            }
        }
        
        if(contador==0)
        {
            return false;
        }
        return true;
    }
    
    private void bttnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnFecharActionPerformed
        if(tabMain.getTabCount()>1)
        {
            int tab = tabMain.getSelectedIndex();
            tabMain.remove(tab);
        }
        
        else
        {
            Helper.MostrarMensagem.mostrarErroMensagem("Não é permitido remover a última página!");
        }
    }//GEN-LAST:event_bttnFecharActionPerformed

    private void bttnMercadoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnMercadoriasActionPerformed
        JPanel mercadorias = new MercadoriasPanel();
        int indice = inserirNoTab("Mercadorias", mercadorias, tabMain.getTabCount());
        tabMain.setSelectedIndex(indice);
    }//GEN-LAST:event_bttnMercadoriasActionPerformed

    private void bttnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnExitActionPerformed
        int dialogOption = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if(dialogOption == JOptionPane.YES_OPTION)
        {
            this.dispose();
        }
    }//GEN-LAST:event_bttnExitActionPerformed

    private void bttnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnVendasActionPerformed
        JPanel vendas = new VendasPanel();
        int indice = inserirNoTab("Vendas", vendas, tabMain.getTabCount());
        tabMain.setSelectedIndex(indice);
    }//GEN-LAST:event_bttnVendasActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnExit;
    private javax.swing.JButton bttnFechar;
    private javax.swing.JButton bttnMercadorias;
    private javax.swing.JButton bttnPessoas;
    private javax.swing.JButton bttnVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelFill;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTabbedPane tabMain;
    // End of variables declaration//GEN-END:variables


    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
