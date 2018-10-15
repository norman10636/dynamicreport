package customizedreport;

public enum ParameterType {

	STRING("string"),
	REPORT("report");
	
	private String type;
	ParameterType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
}
