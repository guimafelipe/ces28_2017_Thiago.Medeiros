package fields_4;

public class DDMMYYYY_Date extends Date {	
	public DDMMYYYY_Date(String day, String month, String year) {
		day_ = day;
		month_ = month;
		year_ = year;
	}
	
	public String toPrint() {
		return day_ + "/" + month_ + "/" + year_;
	}
}