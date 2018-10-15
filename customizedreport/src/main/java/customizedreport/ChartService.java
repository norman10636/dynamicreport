package customizedreport;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.RadarChart;
import org.knowm.xchart.RadarChartBuilder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.style.Styler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ChartService {

	Logger logger = LoggerFactory.getLogger(ChartService.class);

	private List<Paint> paints;
	

	private List<Paint> initializePaintsForPie(){
		paints = new ArrayList<Paint>();
		
		// set 7 color		
//		paints.add(new Color(0x004d4d));	
//		paints.add(new Color(0x006666));
//		paints.add(new Color(0x008080));
//		paints.add(new Color(0x00b3b3));
//		paints.add(new Color(0x1affff));
//		paints.add(new Color(0x80ffff));
//		paints.add(new Color(0xe6ffff));
		
		paints.add(new Color(0x005792));
		paints.add(new Color(0x53CDE2));
		paints.add(new Color(0xD1F4FA));
		paints.add(new Color(0xEDF9FC));	
		
		return paints;
	}
	
	private DefaultPieDataset createDonutDataSet(Map<String, Long> map){
		DefaultPieDataset dataset = new DefaultPieDataset();
		if (map==null || map.size()==0){
			return dataset;
		}
		Map<String, Long> sortedMap = sortMapData(map);
		List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(map.entrySet());
		for (int i=0;i<list.size();i++){
			dataset.setValue(list.get(i).getKey(), list.get(i).getValue());
		}
		return dataset;		
	}

	private Map<String, Long> sortMapData(Map<String, Long> map){
		List<Map.Entry<String, Long>> maplist = new ArrayList<Map.Entry<String,Long>>(map.entrySet());
		Comparator<Map.Entry<String, Long>> comparator = (o1,o2)->{return o2.getValue().intValue()-o1.getValue().intValue();}; 
		Collections.sort(maplist, comparator);
		Map<String, Long> linkedMap = new LinkedHashMap<>();
		for(Map.Entry<String, Long> m:maplist){
			linkedMap.put(m.getKey(), m.getValue());
		}
		return linkedMap;
	}
	
	@SuppressWarnings("deprecation")	
	private void paintPiechart(PiePlot plot,List<Paint> paints, int datasetItemCount){		
		for (int i=0;i<datasetItemCount;i++){
			plot.setSectionPaint(i, paints.get(i));
		}						
	}	
	
	@SuppressWarnings("deprecation")
	public void createPieChart(Map<String, Long> map, String title, boolean isShowLegend, String imagePath, PlotType chartType){
		paints = initializePaintsForPie();
		DefaultPieDataset dataset = createDonutDataSet(map);
		JFreeChart chart = null;
		if (chartType.getType().equals("donut")) {
			chart = ChartFactory.createRingChart(
				    title,  // chart title
				    dataset,             // data
				    isShowLegend,               // legend
				    false,				// tooltips?
				    false				// uri?
				);
		} else if (chartType.getType().equals("pie")){
			chart = ChartFactory.createPieChart(
				    title, 
				    dataset,             
				    isShowLegend,               
				    false,				
				    false				
				);
		}		
		// setting background color white
		chart.setBackgroundPaint(new Color(0xffffff));  // not seen        
		chart.getPlot().setBackgroundPaint(new Color(0xffffff));
		
		if (chartType.getType().equals("donut")) {
			RingPlot ringPlot = (RingPlot) chart.getPlot();
			ringPlot.setOutlineVisible(false);
			ringPlot.setSectionDepth(0.3);
			ringPlot.setLegendItemShape(new Rectangle(50,30));
			if (dataset.getItemCount()==0 || map==null){
				// set no data to display
				ringPlot.setNoDataMessage("no data available");
				// set no data font size
				Font font = new Font("Dialog", Font.PLAIN, 70);
				ringPlot.setNoDataMessageFont(font);
			} else{
				//set charts no shadow
				ringPlot.setShadowXOffset(0);
				ringPlot.setShadowYOffset(0);
				
				//set label format
				ringPlot.setLabelOutlinePaint(null);
				ringPlot.setLabelShadowPaint(null);
				ringPlot.setLabelBackgroundPaint(null);

				paintPiechart(ringPlot, paints,dataset.getItemCount());
				
				//set label generator
				//StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("value: "+"{1}"+"\n"+"percentage: "+"{2}");
				StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{2}");
				labelGenerator.getPercentFormat().setMaximumFractionDigits(0);
				ringPlot.setLabelGenerator(labelGenerator);
				
				//set legend
				LegendTitle legend = chart.getLegend();
				if (legend!=null){
					legend.setBorder(0.0, 0.0, 0.0, 0.0);  
					legend.setPosition(RectangleEdge.RIGHT);				
//					legend.setPosition(RectangleEdge.BOTTOM);
//					legend.setBackgroundPaint(new Color(0xf0f0f5));
				}
				
				// font size, legend, title
				Font font = new Font("Dialog", Font.PLAIN, 50);
				if(legend!=null){
					legend.setItemFont(font);
				}		
				chart.setTitle(new TextTitle(title,font));
		
				//font size,label
				Font font3 = new Font("Dialog", Font.PLAIN, 22); 
				ringPlot.setLabelFont(font);							
			}				
		} else if (chartType.getType().equals("pie")) {
			// remove chart border
			PiePlot plot = (PiePlot) chart.getPlot();
			plot.setOutlineVisible(false);	
			if (dataset.getItemCount()==0||map==null){
				// set no data to display
				plot.setNoDataMessage("no data available");
				// set no data font size
				Font font = new Font("Dialog", Font.PLAIN, 70);
				plot.setNoDataMessageFont(font);
				
			} else {
				//set charts no shadow
				plot.setShadowXOffset(0);
				plot.setShadowYOffset(0);
				
				//set label format
				plot.setLabelOutlinePaint(null);
				plot.setLabelShadowPaint(null);
				plot.setLabelBackgroundPaint(null);
				plot.setLegendItemShape(new Rectangle(50,30));
				
				paintPiechart(plot,paints,dataset.getItemCount());
//				for (int i=0;i<dataset.getItemCount();i++){
//					plot.setSectionPaint(i, paints.get(i));
//				}
				
				//set label generator
				//StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("value: "+"{1}"+"\n"+"percentage: "+"{2}");
				StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{2}");
				labelGenerator.getPercentFormat().setMaximumFractionDigits(2);
				plot.setLabelGenerator(labelGenerator);
				
				//set legend
				LegendTitle legend = chart.getLegend();
				if (legend!=null){
				//	        	legend.setPosition(RectangleEdge.RIGHT);
					legend.setBorder(0.0, 0.0, 0.0, 0.0);   
					legend.setPosition(RectangleEdge.RIGHT);
					legend.setBackgroundPaint(new Color(0xffffff));
				}
				
				// font size, legend, title
				Font font = new Font("Dialog", Font.PLAIN, 50);
				if (legend!=null){
					legend.setItemFont(font);				
				}			
				chart.setTitle(new TextTitle(title,font));
				
				//font size,label
				Font font3 = new Font("Dialog", Font.PLAIN, 22); 
				plot.setLabelFont(font);			
			}			
		}

		String fileName = imagePath;
		try {
			ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 2000, 800);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void createBarchart(Map<String, Long> map, String title, boolean isShowLegend, String imagePath){
		// process category name if value is zero
		Map<String, Long> afterDetectZeroValueOfMap = detectZeroValueOfMap(map);
		DefaultCategoryDataset dataset = getBarChartdataSet(afterDetectZeroValueOfMap);
		JFreeChart chart = ChartFactory.createBarChart(
				"" // title
				, "" // x column category
				, "" //y column category
				, dataset
				, PlotOrientation.HORIZONTAL // horizontal or vertical
				, false // include legend
				, false // tooltips (use false)
				, false // URLs?
			);			
		// setting background color white
		chart.setBackgroundPaint(new Color(0xffffff));  // not seen        
		chart.getPlot().setBackgroundPaint(new Color(0xffffff));
		
		CategoryPlot plot = chart.getCategoryPlot();
//		plot.setRangeGridlinesVisible(false);
		plot.setOutlineVisible(false);
        plot.setDomainGridlinePaint(new Color(0xffffff));
        plot.setRangeGridlinePaint(new Color(0xffffff));
        
        // x column setting
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setMaximumCategoryLabelLines(3);
        domainAxis.setVisible(false);
        domainAxis.setTickLabelsVisible(false);
        domainAxis.setLabelAngle(Math.PI/2.0);
        domainAxis.setMinorTickMarksVisible(true);
         
        // y column setting
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setVisible(false);
        
        DecimalFormat format = new DecimalFormat("##");
        // bar setting
        BarRenderer renderer = (BarRenderer)plot.getRenderer();
        
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator(" {1}",format));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setShadowVisible(false);

        // remove gradient effect
        renderer.setGradientPaintTransformer(null);        
        renderer.setBarPainter(new StandardBarPainter());
        
        // set bar color
        Paint color0 = new Color(0xFDD835);

        // color every category
        renderer.setSeriesPaint(0, color0);
        
        int width = 2000, height = 800;
        if (dataset==null || dataset.getColumnCount()==0){
            plot.setNoDataMessage("no data");
            rangeAxis.setVisible(false);
            domainAxis.setVisible(false);
        	// no data section
            Font font4 = new Font("Dialog", Font.PLAIN, 70); 
            plot.setNoDataMessageFont(font4);
        } else {
//            if(dataset.getColumnCount()==1){
//        	    //this can avoid x y axis label over the image
        	    chart.setPadding(new RectangleInsets(50, 100, 50, 100));     
//                rangeAxis.setUpperBound(120);
            	renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3,TextAnchor.CENTER_LEFT));
            	renderer.setItemMargin(-1.0f);
            	renderer.setMaximumBarWidth(0.3);
                domainAxis.setLowerMargin(0.0);
                domainAxis.setUpperMargin(0.0);
//            } else {
//                rangeAxis.setUpperBound(120);
//            	renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3,TextAnchor.CENTER_LEFT));      	
//            }      
            // font size, x column, y column
            Font font = new Font("Dialog", Font.PLAIN, 30);
            domainAxis.setLabelFont(font);        
            rangeAxis.setLabelFont(font);
            renderer.setBaseItemLabelFont(font);
            // x column category, y column range
            Font font2 = new Font("Dialog", Font.PLAIN, 40);              
            domainAxis.setTickLabelFont(font2);
            rangeAxis.setTickLabelFont(font2);
        }
        
		try {
			ChartUtilities.saveChartAsJPEG(new File(imagePath), chart, width, height);		   			
		} catch (IOException e) {
			e.printStackTrace();
		}	        	      
	}
	
	private Map<String, Long> detectZeroValueOfMap(Map<String, Long> map){
		Map<String, Long> result = new HashMap<String, Long>();
		Object[] keys = map.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			if (map.get(keys[i]) == 0 || map.get(keys[i]) == null) {
				result.put(keys[i].toString(), 1l);
			} else {
				result.put(keys[i].toString(), map.get(keys[i]));
			}
		}
		return result;
	}
	
	private DefaultCategoryDataset getBarChartdataSet(Map<String, Long> map){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (map==null||map.size()==0){
			return dataset;
		} 
		Map<String, Long> sortedMap = sortMapData(map);
		List<Map.Entry<String, Long>> list = new ArrayList<>(sortedMap.entrySet());
		for (int i=0;i<list.size();i++){
			dataset.setValue(list.get(i).getValue(),list.get(i).getKey(), list.get(i).getKey());
		}		
		return dataset;
	}	
	
	public void createRadarChart(Map<String, Double> map, String title, boolean isShowLegend, String imagePath, Integer score, boolean scoreIsZero){
		
		RadarChart chart = new RadarChartBuilder().width(1000).height(400).title(title).build();
		chart.getStyler().setLegendVisible(isShowLegend);	
		
		Styler styler = chart.getStyler();
		styler.setChartBackgroundColor(new Color(0xffffff));
		styler.setLegendBorderColor(new Color(0xffffff));
		styler.setPlotBorderColor(new Color(0xffffff));
		chart.getStyler().setHasAnnotations(true);
		styler.setAnnotationsFont(new Font("Dialog", Font.PLAIN, 30));
		styler.setBaseFont(new Font("Dialog", Font.PLAIN, 60));
		
		Color[] colors = new Color[1];
		if (score >= 80){
			colors[0] = new Color(0xC0504D);
		} else if (score < 80 && score >= 60){
			colors[0] = new Color(0xE36C09);
		} else if (score < 60){
			colors[0] = new Color(0xFFC000);
		}		
		styler.setSeriesColors(colors);
		
		Map<String, Double> normalizedMap = radarDataProcess(map);
		createRadarDataSet(chart, normalizedMap);
		String outputFileName = imagePath;
		if (chart.getVariableLabels().length==0){
			DefaultPieDataset emptyDataset = new DefaultPieDataset();
			JFreeChart emptyChart = ChartFactory.createPieChart(
				    title,  // chart title
				    emptyDataset,             // data
				    false,               // legend
				    false,				// tooltips?
				    false				// uri?
				);	
			// setting background color white
			emptyChart.setBackgroundPaint(Color.WHITE);  // not seen        
			emptyChart.getPlot().setBackgroundPaint(Color.WHITE);
			
			// remove chart border
			PiePlot plot = (PiePlot) emptyChart.getPlot();
			plot.setOutlineVisible(false);
			
			// set no data to display
			if (scoreIsZero){
				plot.setNoDataMessage("N/A");
			} else {
				plot.setNoDataMessage("no data available");
			}
			
			// set no data font size
			Font font = new Font("Dialog", Font.PLAIN, 70);
			plot.setNoDataMessageFont(font);
			try {
				ChartUtilities.saveChartAsJPEG(new File(outputFileName), emptyChart, 2000, 800);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				BitmapEncoder.saveBitmap(chart, outputFileName, BitmapFormat.JPG);
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}	
	}	
	
	private Map<String, Double> radarDataProcess(Map<String, Double> map){
		Map<String, Double> result = new HashMap<String,Double>();
		Object[] keys = map.keySet().toArray();
		for (int i=0;i<keys.length;i++){
			if (!((map.get(keys[i]).doubleValue()<1)&&(map.get(keys[i]).doubleValue()>0))){
				if (map.get(keys[i]).doubleValue()>100){
					result.put(keys[i].toString(), 1.0);
				} else if (map.get(keys[i]).doubleValue()<0){
					result.put(keys[i].toString(), 0.0);
				} else {
					double normalized = map.get(keys[i]).doubleValue()/100.0;
					result.put(keys[i].toString(), normalized);
				}
			} else {
				result.put(keys[i].toString(), map.get(keys[i]).doubleValue());
			}
		}
		return result;
	}
	
	private void createRadarDataSet(RadarChart chart,Map<String, Double> map){		
		if (map==null||map.size()==0){
			chart.setVariableLabels(new String[]{});
			chart.addSeries(" ", new double[]{});			
		} else {
			String[] labels = new String[map.size()];
			double[] variable = new double[map.size()];
			Object[] keys = map.keySet().toArray();
			for (int i=0;i<keys.length;i++){
				labels[i] = (String)keys[i];
				variable[i] = (map.get(keys[i])).doubleValue();
			}			
			chart.setVariableLabels(labels);
			chart.addSeries(" ",variable);
		}
	}
}
