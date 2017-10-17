package fields_2;

public class MMDDYYYY_Date extends Date {	
	public MMDDYYYY_Date(String day, String month, String year) {
		super(day, month, year);
	}
	
	public String toPrint() {
		return month_ + "/" + day_ + "/" + year_;
	}
}