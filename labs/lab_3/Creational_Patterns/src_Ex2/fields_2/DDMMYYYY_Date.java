package fields_2;

public class DDMMYYYY_Date extends Date {	
	public DDMMYYYY_Date(String day, String month, String year) {
		super(day, month, year);
	}
	
	public String toPrint() {
		return day_ + "/" + month_ + "/" + year_;
	}
}