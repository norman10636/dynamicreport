package customizedreport;

public class Table {
	
	private String column1Name;
	private String column2Name;
	private String column3Name;
	private String column4Name;
	private String column5Name;
	private String column6Name;
	private String column7Name;
	private String column8Name;
	private Object column1;
	private Object column2;
	private Object column3;
	private Object column4;
	private Object column5;
	private Object column6;
	private Object column7;
	private Object column8;
	

	public Table() {
		this.column1Name = "";
		this.column2Name = "";
		this.column3Name = "";
		this.column4Name = "";
		this.column5Name = "";
		this.column6Name = "";
		this.column7Name = "";
		this.column8Name = "";
		this.column1 = new Object();
		this.column2 = new Object();
		this.column3 = new Object();
		this.column4 = new Object();
		this.column5 = new Object();
		this.column6 = new Object();
		this.column7 = new Object();
		this.column8 = new Object();
	}
	public Table(String column1Name, String column2Name, String column3Name, String column4Name, String column5Name,
			String column6Name, String column7Name, String column8Name, Object column1, Object column2, Object column3,
			Object column4, Object column5, Object column6, Object column7, Object column8) {
		super();
		this.column1Name = column1Name;
		this.column2Name = column2Name;
		this.column3Name = column3Name;
		this.column4Name = column4Name;
		this.column5Name = column5Name;
		this.column6Name = column6Name;
		this.column7Name = column7Name;
		this.column8Name = column8Name;
		this.column1 = column1;
		this.column2 = column2;
		this.column3 = column3;
		this.column4 = column4;
		this.column5 = column5;
		this.column6 = column6;
		this.column7 = column7;
		this.column8 = column8;
	}
	public String getColumn1Name() {
		return column1Name;
	}
	public void setColumn1Name(String column1Name) {
		this.column1Name = column1Name;
	}
	public String getColumn2Name() {
		return column2Name;
	}
	public void setColumn2Name(String column2Name) {
		this.column2Name = column2Name;
	}
	public String getColumn3Name() {
		return column3Name;
	}
	public void setColumn3Name(String column3Name) {
		this.column3Name = column3Name;
	}
	public String getColumn4Name() {
		return column4Name;
	}
	public void setColumn4Name(String column4Name) {
		this.column4Name = column4Name;
	}
	public String getColumn5Name() {
		return column5Name;
	}
	public void setColumn5Name(String column5Name) {
		this.column5Name = column5Name;
	}
	public String getColumn6Name() {
		return column6Name;
	}
	public void setColumn6Name(String column6Name) {
		this.column6Name = column6Name;
	}
	public String getColumn7Name() {
		return column7Name;
	}
	public void setColumn7Name(String column7Name) {
		this.column7Name = column7Name;
	}
	public String getColumn8Name() {
		return column8Name;
	}
	public void setColumn8Name(String column8Name) {
		this.column8Name = column8Name;
	}
	public Object getColumn1() {
		return column1;
	}
	public void setColumn1(Object column1) {
		this.column1 = column1;
	}
	public Object getColumn2() {
		return column2;
	}
	public void setColumn2(Object column2) {
		this.column2 = column2;
	}
	public Object getColumn3() {
		return column3;
	}
	public void setColumn3(Object column3) {
		this.column3 = column3;
	}
	public Object getColumn4() {
		return column4;
	}
	public void setColumn4(Object column4) {
		this.column4 = column4;
	}
	public Object getColumn5() {
		return column5;
	}
	public void setColumn5(Object column5) {
		this.column5 = column5;
	}
	public Object getColumn6() {
		return column6;
	}
	public void setColumn6(Object column6) {
		this.column6 = column6;
	}
	public Object getColumn7() {
		return column7;
	}
	public void setColumn7(Object column7) {
		this.column7 = column7;
	}
	public Object getColumn8() {
		return column8;
	}
	public void setColumn8(Object column8) {
		this.column8 = column8;
	}
	
	
}
