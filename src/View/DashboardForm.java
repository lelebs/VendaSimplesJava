/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Chart.GraficoBarras;
import Model.Dashboard;
import Table.TabelaDashboard;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author leandro
 */
public class DashboardForm extends javax.swing.JFrame {
    
    private List<Dashboard> lista;
    private static TabelaDashboard dadosTabela;

    public DashboardForm() {
        initComponents();
        inicializar();
                
    }
    
    private void inicializar() {
        lista = new ArrayList<>();
        dadosTabela = new TabelaDashboard(lista);
        tableDados.setModel(dadosTabela);
    }
        
    private void atualizarGrafico(){
        ChartPanel modeloGrafico = GraficoBarras.criar(lista);
        Dimension dimensao = new Dimension(pnlChart.getWidth(), pnlChart.getHeight());
        pnlChart.removeAll();
        pnlChart.setPreferredSize(dimensao);
        pnlChart.setLayout(new BorderLayout());
        pnlChart.add(modeloGrafico, BorderLayout.CENTER);
        pnlChart.validate();
        
    }
        
        
    public static void adicionarNaTabela (Dashboard dashboard){
        dadosTabela.adicionar(dashboard);
    }
    
    public static void deletarNaTabela(int linha)
    {
        dadosTabela.excluir(linha);
    }
    
    @SuppressWarnings("empty-statement")
    public static void limparTabela()
    {        
        while(tableDados.getRowCount() > 0)
        {
            deletarNaTabela(0);
        }
    }
    
    public static void listarTodosGrid()
    {
        limparTabela();
        ArrayList<Dashboard> arrayList = Dashboard.recuperarDados();
        
        for(Dashboard dashboard : arrayList)
        {
            dadosTabela.adicionar(dashboard);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFundo = new javax.swing.JPanel();
        pnlFill = new javax.swing.JPanel();
        lblDashboard = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();
        lblTabela = new javax.swing.JLabel();
        jScroll = new javax.swing.JScrollPane();
        tableDados = new javax.swing.JTable();
        bttnAtualizar = new javax.swing.JButton();
        pnlChart = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboards");
        setBackground(new java.awt.Color(0, 102, 204));
        setUndecorated(true);

        pnlFundo.setBackground(new java.awt.Color(64, 149, 216));

        pnlFill.setBackground(new java.awt.Color(255, 255, 255));

        lblDashboard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDashboard.setText("Dashboard - Mercadorias mais vendidas");

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTabela.setText("Tabela de dados");

        tableDados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScroll.setViewportView(tableDados);

        bttnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        bttnAtualizar.setBorderPainted(false);
        bttnAtualizar.setContentAreaFilled(false);
        bttnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(lblTabela)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnAtualizar)
                .addContainerGap())
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlChart.setBackground(new java.awt.Color(255, 255, 255));
        pnlChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlChartLayout = new javax.swing.GroupLayout(pnlChart);
        pnlChart.setLayout(pnlChartLayout);
        pnlChartLayout.setHorizontalGroup(
            pnlChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pnlChartLayout.setVerticalGroup(
            pnlChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/error.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFillLayout = new javax.swing.GroupLayout(pnlFill);
        pnlFill.setLayout(pnlFillLayout);
        pnlFillLayout.setHorizontalGroup(
            pnlFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFillLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFillLayout.createSequentialGroup()
                        .addComponent(lblDashboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFillLayout.setVerticalGroup(
            pnlFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFillLayout.createSequentialGroup()
                .addGroup(pnlFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFillLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDashboard))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFundoLayout = new javax.swing.GroupLayout(pnlFundo);
        pnlFundo.setLayout(pnlFundoLayout);
        pnlFundoLayout.setHorizontalGroup(
            pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFundoLayout.setVerticalGroup(
            pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAtualizarActionPerformed
        listarTodosGrid();
        atualizarGrafico();
    }//GEN-LAST:event_bttnAtualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAtualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblTabela;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel pnlFill;
    private javax.swing.JPanel pnlFundo;
    private javax.swing.JPanel pnlTable;
    private static javax.swing.JTable tableDados;
    // End of variables declaration//GEN-END:variables
}
