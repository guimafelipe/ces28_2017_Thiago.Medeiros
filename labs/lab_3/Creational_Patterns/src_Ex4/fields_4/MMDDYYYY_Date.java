package fields_4;

public class MMDDYYYY_Date extends Date {	
	public MMDDYYYY_Date(String day, String month, String year) {
		day_ = day;
		month_ = month;
		year_ = year;
	}
	
	public String toPrint() {
		return month_ + "/" + day_ + "/" + year_;
	}
}