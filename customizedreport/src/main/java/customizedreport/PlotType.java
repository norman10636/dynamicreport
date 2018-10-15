package customizedreport;

public enum PlotType {
	DONUTCHART("donut"),
	PIECHART("pie"),
	BARCHART("bar");
	
	private String type;
	PlotType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
