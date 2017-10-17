package fields_3;

public class Date {
	protected String day_;
	protected String month_;
	protected String year_;
	
	public Date(String day, String month, String year) {
		day_ = day;
		month_ = month;
		year_ = year;
	}
	
	public String MMDDYYYY() {
		return month_ + "/" + day_ + "/" + year_;
	}

	public String DDMMYYYY() {
		return day_ + "/" + month_ + "/" + year_;
	}
}
