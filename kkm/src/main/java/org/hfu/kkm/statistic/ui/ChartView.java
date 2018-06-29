package org.hfu.kkm.statistic.ui;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;


 
@ManagedBean
public class ChartView implements Serializable {
 
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createPieModels();
        createBarModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     

     
    private void createPieModels() {
        createPieModel1();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Right", 70);
        pieModel1.set("Wrong", 30);

         
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
    }
     
       public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    
     
    private void createBarModels() {
        createHorizontalBarModel();
    }
     

     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Right");
        boys.set("Englisch", 70);
        boys.set("Java", 60);
        boys.set("Logistik", 10);
        boys.set("SAP", 45);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Wrong");
        girls.set("Englisch", 30);
        girls.set("Java", 40);
        girls.set("Logistik", 90);
        girls.set("SAP", 55);
 
        horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Cards");
        xAxis.setMax(100);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Topic");        
    }
     
}