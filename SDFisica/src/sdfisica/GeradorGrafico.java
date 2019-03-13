package sdfisica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BasicStroke;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Helbert Monteiro
 */
public class GeradorGrafico {
    
    private final DefaultCategoryDataset dadoLinha = new DefaultCategoryDataset();
    private JFreeChart                   graficoLinha;
    private ChartPanel                   chartPanelLinha;
    private CategoryPlot                 categoryPlot;
    
    public void addValor(float x, float y, float z, int i){
        if(i==0){
            dadoLinha.clear();
        }
        dadoLinha.addValue(x, "x", String.valueOf(i));
        dadoLinha.addValue(y, "y", String.valueOf(i));
        dadoLinha.addValue(z, "z", String.valueOf(i));
    }
    
    private void criaGrafico(){
        graficoLinha = ChartFactory.createLineChart("Acelerômetro", "passo", "m/s²", dadoLinha, PlotOrientation.VERTICAL, true, true, false);
        
        categoryPlot = (CategoryPlot) graficoLinha.getPlot();
        
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
        renderer.setSeriesStroke( 0, new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f, new float[] {1.0f, 1.0f}, 0.0f ));
        renderer.setSeriesStroke( 1, new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f, new float[] {1.0f, 1.0f}, 0.0f ));
        renderer.setSeriesStroke( 2, new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f, new float[] {1.0f, 1.0f}, 0.0f ));
    }
    
    public ChartPanel exibeGrafico(int largura, int altura){
        criaGrafico();
        chartPanelLinha = new ChartPanel(graficoLinha, true);
        chartPanelLinha.setSize(largura, altura);
        chartPanelLinha.setVisible(true);
        
        return chartPanelLinha;
    }
    
    public void salvar(OutputStream out) throws IOException {
        ChartUtilities.writeChartAsPNG(out, graficoLinha, 500, 350);
    }

    
}
