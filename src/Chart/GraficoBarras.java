package Chart;

import Model.Dashboard;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class GraficoBarras {
    
    private GraficoBarras () {};
    
    public static ChartPanel criar (List<Dashboard> lista){
        
        DefaultCategoryDataset dadosGrafico = new DefaultCategoryDataset();
        for (Dashboard lista1 : lista) {
            dadosGrafico.addValue( lista1.getQuantidadeVendida(), lista1.getCodigo(), "");
                        
        }
        
        JFreeChart modeloGrafico = ChartFactory.createBarChart3D("Total de vendas por produto", "Código do produto", "Número de vendas", dadosGrafico, PlotOrientation.VERTICAL, true, true, false);
        modeloGrafico.setBackgroundPaint(new Color(255,255,255));
        modeloGrafico.getTitle().setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 17));
        modeloGrafico.getLegend().setBorder(0, 0, 0, 0);
        ChartPanel grafico = new ChartPanel(modeloGrafico);
        
        
        return grafico;
    }
}
