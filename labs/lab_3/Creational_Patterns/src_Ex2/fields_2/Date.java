package fields_2;

public abstract class Date {
	protected String day_;
	protected String month_;
	protected String year_;
	
	public Date(String day, String month, String year) {
		day_ = day;
		month_ = month;
		year_ = year;
	}
	
	public String toPrint() { return ""; }
	
	public static Date create(String day, String month, String year, String language) {
		if(language.equals("ENG"))
			return new MMDDYYYY_Date(day, month, year);
		else if(language.equals("PT-BR"))
			return new DDMMYYYY_Date(day, month, year);
		
		return null;
	}
}