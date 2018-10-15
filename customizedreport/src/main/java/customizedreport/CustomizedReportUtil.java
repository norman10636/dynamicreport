package customizedreport;

public class CustomizedReportUtil {

	public String addStyle(String styleName, String foreColor) {
		StringBuilder style = new StringBuilder();
		style.append(" <style name=\"" + styleName + "\" forecolor=\"#" + foreColor + "\">\n");
		style.append("<conditionalStyle>\n");
		style.append("<conditionExpression/>\n");
		style.append("<style backcolor=\"#aabbcc\"/>\n");
		style.append("</conditionalStyle>\n");
		style.append("</style>\n");
		return style.toString();
	}
	
	public String addStyleWithFont(String styleName, int fontSize, String foreColor, boolean isBold) {
		StringBuilder styleWithFont = new StringBuilder();
		String isBoldString = "false";
		if (isBold) {
			isBoldString = "true";
		}
		styleWithFont.append("<style name=\"" + styleName +  "\" fontSize=\"" + fontSize + "\" forecolor=\"#" + foreColor + "\" isBold=\"" + isBoldString +"\">\n");
		styleWithFont.append("<conditionalStyle>\n");
		styleWithFont.append("<conditionExpression/>\n");
		styleWithFont.append("<style backcolor=\"#aabbcc\"/>\n");
		styleWithFont.append("</conditionalStyle>\n");
		styleWithFont.append("</style>\n");
		return styleWithFont.toString();
	}
	
	public String addDefaultParameter() {
		StringBuilder defaultParameter = new StringBuilder();
		defaultParameter.append("<parameter name = \"Date\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name = \"Company\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name = \"CompanyCover\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name = \"CompanyLogo\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name = \"DateRange\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name = \"CloudApplication\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name = \"Background\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name = \"Reporttitle\" class = \"java.lang.String\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn1\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn2\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn3\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn4\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn5\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn6\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn7\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		defaultParameter.append("<parameter name=\"Tablecolumn8\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		return defaultParameter.toString();
	}
	
	
	
	public String addParameter(String paraName, ParameterType paraType) {
		StringBuilder parameter = new StringBuilder();
		parameter.append("<parameter name = \"" + paraName + "\" ");
		if (paraType.getType().equals("string")) {
			parameter.append("class = \"java.lang.String\"/>\n");
		} else if (paraType.getType().equals("report")) {
			parameter.append("class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"\n");
		}
		return parameter.toString();
	}
	
	public String addParameterForTable(String paraName) {
		StringBuilder parameter = new StringBuilder();
		parameter.append("<parameter name=\"" + paraName+ "\" class=\"net.sf.jasperreports.engine.JasperReport\" isForPrompting=\"false\"/>\n");
		return parameter.toString();
	}
	
	public String addDefaultField() {
		StringBuilder defaultField = new StringBuilder();
		defaultField.append("<field name=\"Table1\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table1]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table2\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table2]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table3\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table3]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table4\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table4]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table5\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table5]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table6\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table6]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table7\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table7]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table8\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table8]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table9\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table9]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table10\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table10]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table11\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table11]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table12\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table12]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table13\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table13]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table14\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table14]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table15\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table15]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table16\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table16]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table17\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table17]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table18\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table18]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table19\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table19]]></fieldDescription>\n");
		defaultField.append("</field>\n");
		defaultField.append("<field name=\"Table20\" class=\"java.util.List\">\n");
		defaultField.append("<fieldDescription><![CDATA[table20]]></fieldDescription>\n");
		defaultField.append("</field>\n");
	  
		return defaultField.toString();
	}
	
	public String addField(String fieldName, String attributeOfDataSource) {
		StringBuilder field = new StringBuilder();
		field.append("<field name=\"" + fieldName + "\" class=\"java.util.List\">\n");
		field.append("<fieldDescription><![CDATA[" + attributeOfDataSource + "]]></fieldDescription>\n");
		field.append("</field>\n");
		return field.toString();
	}
	
	public String addJasperreportHead() {
		StringBuilder jasperreportHead = new StringBuilder();
		jasperreportHead.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		jasperreportHead.append("<jasperReport xmlns=\"http://jasperreports.sourceforge.net/jasperreports\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd\" \n");
		jasperreportHead.append("name=\"compliancereport\"\n");
		jasperreportHead.append("pageWidth=\"595\" pageHeight=\"842\"\n");
		jasperreportHead.append("columnWidth=\"555\"\n");
		jasperreportHead.append("leftMargin=\"0\"\n");
		jasperreportHead.append("rightMargin=\"0\" topMargin=\"0\"\n");
		jasperreportHead.append("bottomMargin=\"0\"\n");
		jasperreportHead.append("isSummaryNewPage=\"true\"\n");
		jasperreportHead.append("isSummaryWithPageHeaderAndFooter=\"true\"\n");
		jasperreportHead.append("whenNoDataType=\"NoDataSection\">\n");
		return jasperreportHead.toString();
	}
		
	public String  addBackGround() {
		StringBuilder background = new StringBuilder();
		background.append("<background>\n");
		background.append("<band height=\"842\" splitType=\"Stretch\">\n");
		background.append("<image  scaleImage=\"FillFrame\" vAlign=\"Middle\" hAlign=\"Left\" evaluationTime=\"Now\" hyperlinkType=\"None\"  hyperlinkTarget=\"Self\" >\n");
		background.append("<reportElement x=\"0\" y=\"0\" width=\"595\" height=\"842\">\n");
		background.append("<printWhenExpression><![CDATA[new Boolean(($V{PAGE_NUMBER}.intValue())==1)]]></printWhenExpression>\n");
		background.append(" </reportElement>\n");
		background.append("<box topBorder=\"None\" topBorderColor=\"#000000\" leftBorder=\"None\" leftBorderColor=\"#000000\" rightBorder=\"None\" rightBorderColor=\"#000000\" bottomBorder=\"None\" bottomBorderColor=\"#000000\"/>\n");
		background.append("<graphicElement stretchType=\"NoStretch\"/> \n");
		background.append("<imageExpression class=\"java.lang.String\"><![CDATA[$P{Background}]]></imageExpression>\n");
		background.append("</image>\n");
		background.append("</band>\n");
		background.append("\n");
		background.append("</background>\n");
		return background.toString();
	}
	
	public String addTitle() {
		StringBuilder title = new StringBuilder();
		title.append("<title>\n");
		title.append("<band height = \"690\">\n");
		
		title.append("<textField>\n");
		title.append("<reportElement  x = \"0\" y = \"60\" width = \"595\" height = \"210\"/>\n");
		title.append("<textElement textAlignment=\"Center\" verticalAlignment = \"Middle\"/>\n");
		title.append("<textFieldExpression>\n");
		title.append("<![CDATA[\"\"]]>\n");
		title.append("</textFieldExpression>\n");
		title.append("</textField>\n");
		
		title.append("<image  scaleImage=\"RetainShape\" vAlign=\"Middle\" hAlign=\"Left\" evaluationTime=\"Now\" hyperlinkType=\"None\"  hyperlinkTarget=\"Self\" >\n");
		title.append(" <reportElement x=\"0\" y=\"270\" width=\"595\" height=\"90\">\n");
		title.append("<printWhenExpression><![CDATA[new Boolean(($V{PAGE_NUMBER}.intValue())==1)]]></printWhenExpression>\n");
		title.append("</reportElement>\n");
		title.append("<box topBorder=\"None\" topBorderColor=\"#000000\" leftBorder=\"None\" leftBorderColor=\"#000000\" rightBorder=\"None\" rightBorderColor=\"#000000\" bottomBorder=\"None\" bottomBorderColor=\"#000000\"/>\n");
		title.append("<graphicElement stretchType=\"NoStretch\"/>\n");
		title.append("<imageExpression class=\"java.lang.String\"><![CDATA[$P{CompanyCover}]]></imageExpression>\n");
		title.append("</image>\n");
		
		title.append("<textField isBlankWhenNull = \"true\">\n");
		title.append("<reportElement style=\"CoverTitle\" x = \"50\" y = \"360\" width = \"505\" height = \"50\"/>\n");
		title.append("<textElement textAlignment = \"Left\">\n");
		title.append("<font size = \"35\"/>\n");
		title.append("</textElement>\n");
		title.append("<textFieldExpression class = \"java.lang.String\">\n");
		title.append("<![CDATA[$P{Reporttitle}]]>\n");
		title.append("</textFieldExpression>\n");
		title.append("</textField>\n");
		
		title.append("<textField isBlankWhenNull = \"true\" isStretchWithOverflow=\"true\">\n");
		title.append("<reportElement style=\"CoverSubTitle\" x = \"50\" y = \"410\" width = \"455\" height = \"25\"/>\n");
		title.append("<textElement>\n");
		title.append("<font size = \"16\"/>\n");
		title.append("</textElement>\n");
		title.append("<textFieldExpression class = \"java.lang.String\">\n");
		title.append("<![CDATA[\"Prepared for \"+$P{Company}]]>\n");
		title.append("</textFieldExpression>\n");
		title.append("</textField>\n");
		
		title.append("<textField isBlankWhenNull = \"true\" isStretchWithOverflow=\"true\">\n");
		title.append("<reportElement style=\"CoverSubTitle\" x = \"50\" y = \"450\" width = \"455\" height = \"25\" positionType=\"FixRelativeToBottom\"/>\n");
		title.append("<textElement >\n");
		title.append("<font size = \"12\"/>\n");
		title.append("</textElement>\n");
		title.append("<textFieldExpression class = \"java.lang.String\">\n");
		title.append("<![CDATA[\"Created on : \"+$P{Date}]]>\n");
		title.append("</textFieldExpression>\n");
		title.append("</textField>\n");
		
		title.append("<textField isBlankWhenNull = \"true\" isStretchWithOverflow=\"true\">\n");
		title.append("<reportElement style=\"CoverSubTitle\" x = \"50\" y = \"475\" width = \"455\" height = \"25\" positionType=\"FixRelativeToBottom\"/>\n");
		title.append("<textElement >\n");
		title.append("<font size = \"12\"/>\n");
		title.append("</textElement>\n");
		title.append("<textFieldExpression class = \"java.lang.String\">\n");
		title.append("<![CDATA[\"Date range :\"+$P{DateRange}]]>\n");
		title.append("</textFieldExpression>\n");
		title.append("</textField>\n");
		
		title.append(" <textField isBlankWhenNull = \"true\" isStretchWithOverflow=\"true\">\n");
		title.append("<reportElement style=\"CoverSubTitle\" x = \"50\" y = \"500\" width = \"455\" height = \"25\" positionType=\"FixRelativeToBottom\"/>\n");
		title.append("<textElement>\n");
		title.append("<font size =\"12\"/>\n");
		title.append("</textElement>\n");
		title.append("<textFieldExpression class = \"java.lang.String\">\n");
		title.append("<![CDATA[\"Cloud application: \"+$P{CloudApplication}]]>\n");
		title.append("</textFieldExpression>\n");
		title.append("</textField>\n");
		
		title.append("</band>\n");
		title.append("</title>\n");
		
		return title.toString();
	}
	
	public String addPageHeader() {
		StringBuilder pageHeader = new StringBuilder();
		pageHeader.append("<pageHeader>\n");
		pageHeader.append("<band height=\"80\">\n");
		pageHeader.append("<textField>\n");
		pageHeader.append("<reportElement x = \"0\" y = \"0\" width = \"595\" height = \"30\"/>\n");
		pageHeader.append("<textFieldExpression>\n");
		pageHeader.append("<![CDATA[\"\"]]>\n");
		pageHeader.append("</textFieldExpression>\n");
		pageHeader.append("</textField>\n");
		pageHeader.append("<image  scaleImage=\"RetainShape\" vAlign=\"Middle\" hAlign=\"Left\" evaluationTime=\"Now\" hyperlinkType=\"None\"  hyperlinkTarget=\"Self\" >\n");
		pageHeader.append("<reportElement  x=\"450\" y=\"30\" width=\"100\" height=\"29\" mode=\"Opaque\">\n");
		pageHeader.append("<printWhenExpression><![CDATA[new Boolean(($V{PAGE_NUMBER}.intValue())!=1)]]></printWhenExpression>\n");
		pageHeader.append("</reportElement>\n");
		pageHeader.append("<box topBorder=\"None\" topBorderColor=\"#000000\" leftBorder=\"None\" leftBorderColor=\"#000000\" rightBorder=\"None\" rightBorderColor=\"#000000\" bottomBorder=\"None\" bottomBorderColor=\"#000000\"/>\n");
		pageHeader.append("<graphicElement stretchType=\"NoStretch\"/>\n");
		pageHeader.append("<imageExpression class=\"java.lang.String\"><![CDATA[$P{CompanyLogo}]]></imageExpression>\n");
		pageHeader.append("</image>\n");
		pageHeader.append("<line>\n");
		pageHeader.append("<reportElement x = \"20\" y = \"59\" width = \"555\" height = \"1\" forecolor=\"#0099ff\">\n");
		pageHeader.append("<printWhenExpression><![CDATA[new Boolean(($V{PAGE_NUMBER}.intValue())!=1)]]></printWhenExpression>\n");
		pageHeader.append("</reportElement>\n");
		pageHeader.append("</line>\n");
		pageHeader.append("</band>\n");
		pageHeader.append("</pageHeader>\n");	
		return pageHeader.toString();
	}
	
	public String addDetailHead() {
		return "<detail>\n";
	}
	
	public String addDetailTail() {
		return "</detail>\n";
	}
	
	public String addPageFooter() {
		StringBuilder pageFooter = new StringBuilder();
		pageFooter.append("<pageFooter>\n");
		pageFooter.append("<band height=\"72\">\n");
		pageFooter.append("<line>\n");
		pageFooter.append(" <reportElement x = \"20\" y = \"0\" width = \"555\" height = \"1\" forecolor=\"#cccccc\">\n");
		pageFooter.append("<printWhenExpression><![CDATA[new Boolean(($V{PAGE_NUMBER}.intValue())!=1)]]>\n");
		pageFooter.append("</printWhenExpression>\n");
		pageFooter.append("</reportElement>\n");
		pageFooter.append("</line>\n");
		pageFooter.append("<textField>\n");
		pageFooter.append("<reportElement x=\"20\" y=\"20\" width=\"260\" height=\"30\">\n");
		pageFooter.append("<printWhenExpression><![CDATA[new Boolean(($V{PAGE_NUMBER}.intValue())!=1)]]>\n");
		pageFooter.append("</printWhenExpression>\n");
		pageFooter.append("</reportElement>\n");
		pageFooter.append("<textElement textAlignment = \"Left\">\n");
		pageFooter.append("<font size = \"10\"/>\n");
		pageFooter.append("</textElement>\n");
		pageFooter.append("<textFieldExpression>\n");
		pageFooter.append("<![CDATA[$P{Reporttitle}]]>\n");
		pageFooter.append("</textFieldExpression>\n");
		pageFooter.append("</textField>\n");
		pageFooter.append("<textField>\n");
		pageFooter.append("<reportElement  x=\"280\" y=\"20\" width=\"295\" height=\"30\">\n");
		pageFooter.append("</reportElement>\n");
		pageFooter.append("<textElement textAlignment = \"Right\">\n");
		pageFooter.append("<font size = \"10\"/>\n");
		pageFooter.append("</textElement>\n");
		pageFooter.append("<textFieldExpression>\n");
		pageFooter.append("<![CDATA[\"${CURRENT_PAGE_NUMBER}\"]]>\n");
		pageFooter.append("</textFieldExpression>\n");
		pageFooter.append("</textField>\n");
		pageFooter.append("<textField evaluationTime=\"Report\">\n");
		pageFooter.append("<reportElement  x=\"575\" y=\"20\" width=\"18\" height=\"30\">\n");
		pageFooter.append("</reportElement>\n");
		pageFooter.append("<textElement textAlignment = \"Left\">\n");
		pageFooter.append(" <font size = \"10\"/>\n");
		pageFooter.append("</textElement>\n");
		pageFooter.append("<textFieldExpression class = \"java.lang.String\">\n");
		pageFooter.append("<![CDATA[\"${TOTAL_PAGE_NUMBER}\"]]>\n");
		pageFooter.append("</textFieldExpression>\n");
		pageFooter.append("</textField>\n");
		pageFooter.append("</band>\n");
		pageFooter.append("</pageFooter>\n");
		return pageFooter.toString();
	}
	
	public String addJasperreportTail() {
		return "</jasperReport>\n";
	}

	public String addText(String parameter, String style, int bandHight, int fontSize) {
		// parameter : $P{Parameter_name}
		// fontSize : default band size 30
		StringBuilder text = new StringBuilder();
		text.append("<band height=\" "+ bandHight + "\" splitType=\"Prevent\">\n");
		text.append("<textField isStretchWithOverflow=\"true\">\n");
		text.append("<reportElement style=\"" +  style + "\" x = \"30\" y = \"0\" width = \"520\" height = \"" + bandHight + "\"/>\n");
		text.append("<textElement textAlignment=\"Left\" verticalAlignment = \"Middle\" >\n");
		text.append("<font size = \"" + fontSize + "\"/>\n");
		text.append("</textElement>\n");
		text.append("<textFieldExpression>\n");
		text.append("<![CDATA[$P{"  + parameter + "}]]>\n");
		text.append("</textFieldExpression> \n");
		text.append("</textField>\n");
		text.append("</band>\n");
		return text.toString();
	}
	
	public String addImage(String imagePathParameter, String backColor) {
		// default bandHight 100
	    StringBuilder image = new StringBuilder();
	    image.append("<band height=\"200\" splitType=\"Prevent\">\n");
	    image.append("<image  scaleImage=\"RetainShape\" vAlign=\"Middle\" hAlign=\"Left\" evaluationTime=\"Now\" hyperlinkType=\"None\"  hyperlinkTarget=\"Self\" >\n");
	    image.append("<reportElement x=\"20\" y=\"0\" width=\"500\" height=\"200\" mode=\"Opaque\"/>\n");
	    image.append("<graphicElement stretchType=\"NoStretch\"/>\n");
	    image.append("<imageExpression class=\"java.lang.String\"><![CDATA[$P{" + imagePathParameter + "}]]></imageExpression>\n");
	    image.append("</image>\n");
	    image.append("</band>\n");
	    return image.toString();
	}
	
	public String addTable(String attributeTable, String tableOption) {
		StringBuilder table = new StringBuilder();
		table.append("<band height=\"10\" splitType=\"Prevent\"> \n");
		table.append("<subreport>\n");
		table.append("<reportElement x=\"20\" y=\"9\" width=\"520\" height=\"1\" isRemoveLineWhenBlank=\"true\">\n");
		table.append("</reportElement>\n");
		table.append("<dataSourceExpression>\n");
		table.append("new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource($F{" + attributeTable + "})\n");
		table.append("</dataSourceExpression>\n");
		table.append("<subreportExpression class=\"net.sf.jasperreports.engine.JasperReport\">\n");
		table.append("<![CDATA[$P{" + tableOption + "}]]>\n");
		table.append("</subreportExpression>\n");
		table.append("</subreport>\n");
		table.append("</band>\n");
		return table.toString();
	}
	
	public String addBlank() {
		StringBuilder blank = new StringBuilder();
		blank.append("<band height=\"30\" splitType=\"Prevent\">\n");
		blank.append("<textField isStretchWithOverflow=\"true\">\n");
		blank.append("<reportElement style=\"Executivesummary\" x = \"30\" y = \"0\" width = \"520\" height = \"20\"/>\n");
		blank.append("<textFieldExpression>\n");
		blank.append("<![CDATA[\" \"]]>\n");
		blank.append("</textFieldExpression> \n");
		blank.append("</textField>\n");
		blank.append("</band>\n");
		return blank.toString();
	}
}

