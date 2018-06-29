package org.hfu.kkm.statistic.ui;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hfu.kkm.card.db.CardService;
import org.hfu.kkm.statistic.db.Statistic;
import org.hfu.kkm.statistic.db.StatisticService;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;
 
@Model
public class StatisticController implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	StatisticService statsService;
	@Inject
	CardService cardService;

	private List<Statistic> statsList;
	private List<Statistic> userStat;
	private String topic;
	
    public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}



	private PieChartModel pieModel1;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
    	statsList = statsService.getAll();
        createPieModels();
        createBarModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     

     
    private void createPieModels() {
        createPieModel1();
    }
    
    public void refreshPieModel(){
        for(int i=0; i<userStat.size();i++) {
        	if(userStat.get(i).getTopic().equals(topic)) {
        		pieModel1.set("easy", statsList.get(i).getEasy());
                pieModel1.set("medium", statsList.get(i).getMedium());
                pieModel1.set("hard", statsList.get(i).getHard());
                pieModel1.setTitle(statsList.get(i).getTopic());
                pieModel1.setLegendPosition("w");
        	}
        }
	}
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        userStat = new ArrayList<>();
        for(int i=0; i<statsList.size();i++) {
        	if(statsList.get(i).getUserId()==2) {
        		userStat.add(statsList.get(i));
        	}
        }
        
        pieModel1.set("easy", userStat.get(0).getEasy());
        pieModel1.set("medium", userStat.get(0).getMedium());
        pieModel1.set("hard", userStat.get(0).getHard());

         
        pieModel1.setTitle(userStat.get(0).getTopic());
        pieModel1.setLegendPosition("w");
    }
     
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
    
     
    private void createBarModels() {
        createHorizontalBarModel();
    }
     

     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries easy = new ChartSeries();
        easy.setLabel("easy");
        
        ChartSeries medium = new ChartSeries();
        medium.setLabel("medium");
 
        ChartSeries hard = new ChartSeries();
        hard.setLabel("hard");
        
        for(int i=0; i<userStat.size();i++) {
        	easy.set(userStat.get(i).getTopic(), userStat.get(i).getEasy());
        	medium.set(userStat.get(i).getTopic(), userStat.get(i).getMedium());
        	hard.set(userStat.get(i).getTopic(), userStat.get(i).getHard());
        }
 
        horizontalBarModel.addSeries(easy);
        horizontalBarModel.addSeries(medium);
        horizontalBarModel.addSeries(hard);
         
        horizontalBarModel.setTitle("Overview");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Learning Progress Cards");
        xAxis.setMax(20);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Topic");        
    }
     
}