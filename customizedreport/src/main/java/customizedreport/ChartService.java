package customizedreport;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;
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
	
	private DefaultPieDataset createDonutDataSet(Map<String, Number> map){
		DefaultPieDataset dataset = new DefaultPieDataset();
		if (map==null || map.size()==0){
			return dataset;
		}
		Map<String, Number> sortedMap = sortDonutMapData(map);
		List<Map.Entry<String, Number>> list = new ArrayList<Map.Entry<String, Number>>(map.entrySet());
		for (int i=0;i<list.size();i++){
			dataset.setValue(list.get(i).getKey(), list.get(i).getValue());
		}
		return dataset;		
	}
	
	private Map<String, Number> sortDonutMapData(Map<String, Number> map){
		List<Map.Entry<String, Number>> maplist = new ArrayList<Map.Entry<String,Number>>(map.entrySet());
		Comparator<Map.Entry<String, Number>> comparator = (o1,o2)->{return o2.getValue().intValue()-o1.getValue().intValue();}; 
		Collections.sort(maplist, comparator);
		Map<String, Number> linkedMap = new LinkedHashMap<>();
		for(Map.Entry<String, Number> m:maplist){
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
	
	public void createDonutChart(Map<String, Number> map, String title, boolean isShowLegend, String imagePath){
		paints = initializePaintsForPie();
		DefaultPieDataset dataset = createDonutDataSet(map);
		
		JFreeChart chart = ChartFactory.createRingChart(
		    title,  // chart title
		    dataset,             // data
		    isShowLegend,               // legend
		    false,				// tooltips?
		    false				// uri?
		);
		
		// setting background color white
//		chart.setBackgroundPaint(new Color(0xf0f0f5));    
//		chart.getPlot().setBackgroundPaint(new Color(0xf0f0f5));
		chart.setBackgroundPaint(new Color(0xffffff));  // not seen        
		chart.getPlot().setBackgroundPaint(new Color(0xffffff));
		// remove chart border
		RingPlot plot = (RingPlot) chart.getPlot();
		plot.setOutlineVisible(false);
		plot.setSectionDepth(0.3);
		plot.setLegendItemShape(new Rectangle(50,30));
		
		if (dataset.getItemCount()==0 || map==null){
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

			paintPiechart(plot,paints,dataset.getItemCount());
			
			//set label generator
			//StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("value: "+"{1}"+"\n"+"percentage: "+"{2}");
			StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{2}");
			labelGenerator.getPercentFormat().setMaximumFractionDigits(0);
			plot.setLabelGenerator(labelGenerator);
			
			//set legend
			LegendTitle legend = chart.getLegend();
			if (legend!=null){
				legend.setBorder(0.0, 0.0, 0.0, 0.0);  
				legend.setPosition(RectangleEdge.RIGHT);				
//				legend.setPosition(RectangleEdge.BOTTOM);
//				legend.setBackgroundPaint(new Color(0xf0f0f5));
			}
			
			// font size, legend, title
			Font font = new Font("Dialog", Font.PLAIN, 50);
			if(legend!=null){
				legend.setItemFont(font);
			}		
			chart.setTitle(new TextTitle(title,font));
	
			//font size,label
			Font font3 = new Font("Dialog", Font.PLAIN, 22); 
			plot.setLabelFont(font);			
		}
		
		String fileName = imagePath;
		try {
			ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 2000, 800);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}
