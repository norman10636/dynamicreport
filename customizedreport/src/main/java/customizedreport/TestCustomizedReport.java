package customizedreport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestCustomizedReport {

	private Logger logger = LoggerFactory.getLogger(TestCustomizedReport.class);
	
	private static final String CURRENT_PAGE_NUMBER = "${CURRENT_PAGE_NUMBER}";
	
	private static final String TOTAL_PAGE_NUMBER = "${TOTAL_PAGE_NUMBER}";	
	
	private CustomizedTable customizedTable;
	
	private List<CustomizedTable> customizedTables;
	
	private Map<String, Object> jRMap = new HashMap<String, Object>(); 
	
	private String cloudApplication = "Azure";
	
	JasperPrint jasperPrint = null;
	
	private CustomizedReportUtil reportUtil = new CustomizedReportUtil();
	
	private ChartService chartService = new ChartService();
	
	private String donutChartPath = "./donutchart.jpg";
	
	@Before
	public void beforeTest(){
	
	}
	
	@Test
	public void testCreateCLevelReport() throws JRException, IOException{
		createReport();
	}
	
	@Test
	public void testWriteDatatoFile() throws JRException {
		createReportGenerateTemplateByAPI();
	}
	
	@Test
	public void testCreateDonutChart() {
		createDonutChart();
	}
	
	private void createReportGenerateTemplateByAPI() throws JRException {
		
        FileWriter fw;
        String title = "Usage of unsanctioned cloud application";
        String titleContext = "The usage of cloudapplication report providevisibility into what cloud apps are being used organization-wide and who is using them. Unsanctioned cloud applications are cloudApplications not approved or monitored by your security organizations. Unsanctioned applications could present a risk to your organization.";
        String userInputText1 = "Customized Report";
        String userInputText2 = "Table1";
        String userInputText3 = "Table2";
        String userInputText4 = "Table3";
        String userInputText5 = "Table4";
        String userInputText6 = "Table5";
        String userInputText7 = "Table6";
        String userInputText8 = "Table7";
        String userInputText9 = "Table8";
        String chartTitle = "Donut Chart";
        
        createDonutChart();
        
		jRMap.put("UserinputText1", userInputText1);
		jRMap.put("UserinputText2", userInputText2);
		jRMap.put("UserinputText3", userInputText3);
		jRMap.put("UserinputText4", userInputText4);
		jRMap.put("UserinputText5", userInputText5);
		jRMap.put("UserinputText6", userInputText6);
		jRMap.put("UserinputText7", userInputText7);
		jRMap.put("UserinputText8", userInputText8);
		jRMap.put("UserinputText9", userInputText9);
		jRMap.put("Charttitle", chartTitle);
		jRMap.put("Donutchartpath", donutChartPath);
		
		try {
			fw = new FileWriter(getClass().getClassLoader()
					.getResource("customizedgeneratedreport.jrxml").getFile());
			BufferedWriter bufw = new BufferedWriter(fw);
			
			StringBuilder reportText = new StringBuilder();
			reportText.append(reportUtil.addJasperreportHead())
							.append(reportUtil.addStyleWithFont("PlainText", 25, "3C699B", false))
							.append(reportUtil.addStyleWithFont("Executivesummary", 14, "3C699B", false))
							.append(reportUtil.addStyleWithFont("Titlecontext", 14, "000000", false))
							.append(reportUtil.addStyle("CoverTitle", "1f3d7a"))
							.append(reportUtil.addStyle("CoverSubTitle", "1f497d"))
							.append(reportUtil.addDefaultParameter())
							.append(reportUtil.addParameter("UserinputText1", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText2", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText3", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText4", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText5", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText6", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText7", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText8", ParameterType.STRING))
							.append(reportUtil.addParameter("UserinputText9", ParameterType.STRING))
							.append(reportUtil.addParameter("Titletext", ParameterType.STRING))
							.append(reportUtil.addParameter("Titlecontent", ParameterType.STRING))
							.append(reportUtil.addParameter("Charttitle", ParameterType.STRING))
							.append(reportUtil.addParameter("Donutchartpath", ParameterType.STRING))							
							.append(reportUtil.addDefaultField())
							.append(reportUtil.addBackGround())
							.append(reportUtil.addTitle())
							.append(reportUtil.addPageHeader())
							.append(reportUtil.addDetailHead())
							.append(reportUtil.addText("UserinputText1", "PlainText", 30, 20))
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("Titletext", "PlainText", 30, 20))
							.append(reportUtil.addText("Titlecontent", "Titlecontext", 30, 12))
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("UserinputText2", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table1", "Tablecolumn1"))
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("UserinputText3", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table2", "Tablecolumn2"))
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("UserinputText4", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table3", "Tablecolumn3"))
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("UserinputText5", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table4", "Tablecolumn4"))
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("UserinputText6", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table5", "Tablecolumn5"))
							.append(reportUtil.addBlank())							
							.append(reportUtil.addText("UserinputText7", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table6", "Tablecolumn6"))
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("UserinputText8", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table7", "Tablecolumn7"))	
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("UserinputText9", "Executivesummary", 30, 20))
							.append(reportUtil.addTable("Table8", "Tablecolumn8"))			
							.append(reportUtil.addBlank())
							.append(reportUtil.addText("Charttitle", "Executivesummary", 30, 20))
							.append(reportUtil.addImage("Donutchartpath", "111111"))	
							.append(reportUtil.addDetailTail())
							.append(reportUtil.addPageFooter())
							.append(reportUtil.addJasperreportTail());
						
	        bufw.write(reportText.toString());  
	        bufw.flush();  
	        bufw.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
		File input  = new File(getClass().getClassLoader()
				.getResource("customizedgeneratedreport.jrxml").getFile());
		JasperReport report = JasperCompileManager.compileReport(input.getAbsolutePath());
		
		File tableColumn1Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn1.jrxml").getFile());
		JasperReport tableColumn1 = JasperCompileManager.compileReport(tableColumn1Input.getAbsolutePath());
		
		File tableColumn2Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn2.jrxml").getFile());
		JasperReport tableColumn2 = JasperCompileManager.compileReport(tableColumn2Input.getAbsolutePath());
		
		File tableColumn3Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn3.jrxml").getFile());
		JasperReport tableColumn3 = JasperCompileManager.compileReport(tableColumn3Input.getAbsolutePath());
		
		File tableColumn4Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn4.jrxml").getFile());
		JasperReport tableColumn4 = JasperCompileManager.compileReport(tableColumn4Input.getAbsolutePath());
		
		File tableColumn5Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn5.jrxml").getFile());
		JasperReport tableColumn5 = JasperCompileManager.compileReport(tableColumn5Input.getAbsolutePath());
		
		File tableColumn6Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn6.jrxml").getFile());
		JasperReport tableColumn6 = JasperCompileManager.compileReport(tableColumn6Input.getAbsolutePath());
		
		File tableColumn7Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn7.jrxml").getFile());
		JasperReport tableColumn7 = JasperCompileManager.compileReport(tableColumn7Input.getAbsolutePath());
		
		File tableColumn8Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn8.jrxml").getFile());
		JasperReport tableColumn8 = JasperCompileManager.compileReport(tableColumn8Input.getAbsolutePath());		
		
		jRMap.put("Tablecolumn1", tableColumn1);
		jRMap.put("Tablecolumn2", tableColumn2);
		jRMap.put("Tablecolumn3", tableColumn3);
		jRMap.put("Tablecolumn4", tableColumn4);
		jRMap.put("Tablecolumn5", tableColumn5);
		jRMap.put("Tablecolumn6", tableColumn6);
		jRMap.put("Tablecolumn7", tableColumn7);
		jRMap.put("Tablecolumn8", tableColumn8);
		jRMap.put("Titletext", title);
		jRMap.put("Titlecontent", titleContext);
	

		jRMap.put("Date", "2017-12-13");
		jRMap.put("Company", "fortinet");
		jRMap.put("CompanyCover", "coverlogo.jpg");
		jRMap.put("CompanyLogo", "fortinetLogo.jpg");
		jRMap.put("DateRange", "2017-10-13 to 2017-10-12");
		jRMap.put("CloudApplication", cloudApplication);
		jRMap.put("Background", "newcover.png");
		jRMap.put("Reporttitle", "Customized");
				
		customizedTable = new CustomizedTable();
		customizedTables = new ArrayList<CustomizedTable>();
		addDataToCustomizedTableList();
		customizedTables.add(customizedTable);
	
		JRDataSource dataSource = new JRBeanCollectionDataSource(customizedTables);
		
		jasperPrint = JasperFillManager.fillReport(report, jRMap ,dataSource);

//		jasperPrint = JasperFillManager.fillReport(report, jRMap ,new JREmptyDataSource());
		
		filltext(jasperPrint);
		String output = "./customizedgenerate.pdf";

		JasperExportManager.exportReportToPdfFile(jasperPrint,output);		
	}
	
	private void createReport() throws JRException {
		File input  = new File(getClass().getClassLoader()
				.getResource("customizedmainreport.jrxml").getFile());
		JasperReport report = JasperCompileManager.compileReport(input.getAbsolutePath());

		File tableColumn1Input  = new File(getClass().getClassLoader()
				.getResource("tablecolumn1.jrxml").getFile());
		JasperReport tableColumn1 = JasperCompileManager.compileReport(tableColumn1Input.getAbsolutePath());
		jRMap.put("Tablecolumn1", tableColumn1);		
		
//		File table1Input  = new File(getClass().getClassLoader()
//				.getResource("gdprtable1.jrxml").getFile());
//		JasperReport table1Report = JasperCompileManager.compileReport(table1Input.getAbsolutePath());
//		jRMap.put("Table1Report1", table1Report);

		
		jRMap.put("Date", "2017-12-13");
		jRMap.put("Company", "fortinet");
		jRMap.put("CompanyCover", "coverlogo.jpg");
		jRMap.put("CompanyLogo", "fortinetLogo.jpg");
		jRMap.put("DateRange", "2017-10-13 to 2017-10-12");
		jRMap.put("CloudApplication", cloudApplication);
		jRMap.put("Background", "newcover.png");
		jRMap.put("Reporttitle", "Customized");
		

		customizedTable = new CustomizedTable();
		customizedTables = new ArrayList<CustomizedTable>();
		addDataToCustomizedTableList();
		customizedTables.add(customizedTable);
		
		
		JRDataSource dataSource = new JRBeanCollectionDataSource(customizedTables);

				
		jasperPrint = JasperFillManager.fillReport(report, jRMap ,dataSource);
//		jasperPrint = JasperFillManager.fillReport(report, jRMap ,new JREmptyDataSource());
		
		filltext(jasperPrint);
		String output = "./customized.pdf";

		JasperExportManager.exportReportToPdfFile(jasperPrint,output);				
	}

	private void createDonutChart() {
		Map<String, Number> population = new HashMap<String, Number>();
		population.put("Japan", 100000000);
		population.put("U.S.A", 300000000);
		population.put("China", 1600000000);
		chartService.createDonutChart(population, "", true, "./donutchart.jpg");
	}
	
	private void addDataToCustomizedTableList() {
		List<Table> table1s = new ArrayList<Table>();
		Table table11 = new Table();
		table11.setColumn1Name("Date");
		
		table11.setColumn1("2018-09-12");
		table1s.add(table11);
		
		Table table12 = new Table();
		table12.setColumn1Name("Date");
		
		table12.setColumn1("2018-09-22");
		table1s.add(table12);
		
		customizedTable.setTable1(table1s);
		
		List<Table> table2s = new ArrayList<Table>();
		Table table21 = new Table();
		table21.setColumn1Name("Date");
		table21.setColumn2Name("Name");
		
		table21.setColumn1("2018-09-12");
		table21.setColumn2("NT");
		table2s.add(table21);
		
		Table table22 = new Table();
		table22.setColumn1Name("Date");
		table22.setColumn2Name("Name");
		
		table22.setColumn1("2018-09-22");
		table22.setColumn2("JJ");
		table2s.add(table22);
		
		customizedTable.setTable2(table2s);
		
		List<Table> table3s = new ArrayList<Table>();
		Table table31 = new Table();
		table31.setColumn1Name("Date");
		table31.setColumn2Name("Name");
		table31.setColumn3Name("Event");
		
		table31.setColumn1("2018-09-12");
		table31.setColumn2("NT");
		table31.setColumn3("Event A");
		table3s.add(table31);
		
		Table table32 = new Table();
		table32.setColumn1Name("Date");
		table32.setColumn2Name("Name");
		table32.setColumn3Name("Event");
		
		table32.setColumn1("2018-09-22");
		table32.setColumn2("JJ");
		table32.setColumn3("Event B");
		table3s.add(table32);
		
		customizedTable.setTable3(table3s);
		
		List<Table> table4s = new ArrayList<Table>();
		Table table41 = new Table();
		table41.setColumn1Name("Date");
		table41.setColumn2Name("Name");
		table41.setColumn3Name("Event");
		table41.setColumn4Name("File Name");
		
		table41.setColumn1("2018-09-12");
		table41.setColumn2("NT");
		table41.setColumn3("Event A");
		table41.setColumn4("123.txt");
		table4s.add(table41);
		
		Table table42 = new Table();
		table42.setColumn1Name("Date");
		table42.setColumn2Name("Name");
		table42.setColumn3Name("Event");
		table42.setColumn4Name("File Name");
		
		table42.setColumn1("2018-09-22");
		table42.setColumn2("JJ");
		table42.setColumn3("Event B");
		table42.setColumn4("123.txt");
		table4s.add(table42);
		
		customizedTable.setTable4(table4s);
		
		List<Table> table5s = new ArrayList<Table>();
		Table table51 = new Table();
		table51.setColumn1Name("Date");
		table51.setColumn2Name("Name");
		table51.setColumn3Name("Event");
		table51.setColumn4Name("File Name");
		table51.setColumn5Name("City");
		
		table51.setColumn1("2018-09-12");
		table51.setColumn2("NT");
		table51.setColumn3("Event A");
		table51.setColumn4("123.txt");
		table51.setColumn5("LA");
		table5s.add(table51);
		
		Table table52 = new Table();
		table52.setColumn1Name("Date");
		table52.setColumn2Name("Name");
		table52.setColumn3Name("Event");
		table52.setColumn4Name("File Name");
		table51.setColumn5Name("City");
		
		table52.setColumn1("2018-09-22");
		table52.setColumn2("JJ");
		table52.setColumn3("Event B");
		table52.setColumn4("123.txt");
		table52.setColumn5("NY");
		table5s.add(table52);
		
		customizedTable.setTable5(table5s);
		
		List<Table> table6s = new ArrayList<Table>();
		Table table61 = new Table();
		table61.setColumn1Name("Date");
		table61.setColumn2Name("User");
		table61.setColumn3Name("Event");
		table61.setColumn4Name("File Name");
		table61.setColumn5Name("City");
		table61.setColumn6Name("ID");
		
		table61.setColumn1("2018-09-12");
		table61.setColumn2("NT");
		table61.setColumn3("Event A");
		table61.setColumn4("123.txt");
		table61.setColumn5("LA");		
		table61.setColumn6("ABC123465");
		table6s.add(table61);
		
		Table table62 = new Table();
		table62.setColumn1Name("Date");
		table62.setColumn2Name("User");
		table62.setColumn3Name("Event");
		table62.setColumn4Name("File Name");
		table62.setColumn5Name("City");
		table62.setColumn6Name("ID");
		
		table62.setColumn1("2018-09-22");
		table62.setColumn2("JJ");
		table62.setColumn3("Event B");
		table62.setColumn4("abc.txt");
		table62.setColumn5("NY");		
		table62.setColumn6("AAA555");		
		table6s.add(table62);
		
		customizedTable.setTable6(table6s);
		
		List<Table> table7s = new ArrayList<Table>();
		Table table71 = new Table();
		table71.setColumn1Name("Date");
		table71.setColumn2Name("User");
		table71.setColumn3Name("Event");
		table71.setColumn4Name("File Name");
		table71.setColumn5Name("Country/Region");
		table71.setColumn6Name("City");
		table71.setColumn7Name("ID");
		
		table71.setColumn1("2018-09-12");
		table71.setColumn2("NT");
		table71.setColumn3("Event A");
		table71.setColumn4("123.txt");
		table71.setColumn5("USA");
		table71.setColumn6("LA");		
		table71.setColumn7("ABC123465");
		table7s.add(table71);
		
		Table table72 = new Table();
		table72.setColumn1Name("Date");
		table72.setColumn2Name("User");
		table72.setColumn3Name("Event");
		table72.setColumn4Name("File Name");
		table72.setColumn5Name("Country/Region");
		table72.setColumn6Name("City");
		table72.setColumn7Name("ID");
		
		table72.setColumn1("2018-09-22");
		table72.setColumn2("JJ");
		table72.setColumn3("Event B");
		table72.setColumn4("abc.txt");
		table72.setColumn5("USA");
		table72.setColumn6("NY");		
		table72.setColumn7("AAA555");		
		table7s.add(table72);
		
		customizedTable.setTable7(table7s);
		
		List<Table> table8s = new ArrayList<Table>();
		Table table81 = new Table();
		table81.setColumn1Name("Date");
		table81.setColumn2Name("User");
		table81.setColumn3Name("Event");
		table81.setColumn4Name("File Name");
		table81.setColumn5Name("Country/Region");
		table81.setColumn6Name("City");
		table81.setColumn7Name("ID");
		table81.setColumn8Name("Other");
		
		table81.setColumn1("2018-09-12");
		table81.setColumn2("NT");
		table81.setColumn3("Event A");
		table81.setColumn4("123.txt");
		table81.setColumn5("USA");
		table81.setColumn6("LA");		
		table81.setColumn7("ABC123465");
		table81.setColumn8("no comment");
		table8s.add(table81);
		
		Table table82 = new Table();
		table82.setColumn1Name("Date");
		table82.setColumn2Name("User");
		table82.setColumn3Name("Event");
		table82.setColumn4Name("File Name");
		table82.setColumn5Name("Country/Region");
		table82.setColumn6Name("City");
		table82.setColumn7Name("ID");
		table82.setColumn8Name("Other");
		
		table82.setColumn1("2018-09-22");
		table82.setColumn2("JJ");
		table82.setColumn3("Event B");
		table82.setColumn4("abc.txt");
		table82.setColumn5("USA");
		table82.setColumn6("NY");		
		table82.setColumn7("AAA555");	
		table82.setColumn8("no comment");
		table8s.add(table82);
		
		customizedTable.setTable8(table8s);

	
	}
	
	@After
	public void afterTest(){
		
	}
	
	public void filltext(JasperPrint jasperPrint){
		  int totalPageNumber = jasperPrint.getPages().size();
		  List<JRPrintPage> pages = jasperPrint.getPages();
		  int currentPage = 0;
		  for (JRPrintPage jrPrintPage : pages){
			  List<JRPrintElement> elements = jrPrintPage.getElements();

			  for(JRPrintElement jrPrintElement : elements){
				  int tmp = 0;
				  if (jrPrintElement instanceof JRPrintText){
					  JRPrintText jrPrintText = (JRPrintText)jrPrintElement;
//						  if (SUMMARY.equals(jrPrintText.getValue())){
//							  jrPrintText.setText("No Data Available");
//							  continue;
//						  }
					  if (CURRENT_PAGE_NUMBER.equals(jrPrintText.getValue())){
//							  if (currentPage==0){
//								  jrPrintText.setText("Created at: "+createdStr);
//							  } else {
//								  jrPrintText.setText("Page " + currentPage + " of " +(totalPageNumber-1));
//								  continue;										  
//							  }
						  jrPrintText.setText("Page " + currentPage + " of " +(totalPageNumber-1));
						  continue;
					  }
					  if (TOTAL_PAGE_NUMBER.equals(jrPrintText.getValue())){
						  jrPrintText.setText("");
					  }
				  }
			  }
			  currentPage++;
		  }					  	
	}	
}
