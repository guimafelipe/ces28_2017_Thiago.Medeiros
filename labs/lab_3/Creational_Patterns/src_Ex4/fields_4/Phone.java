package fields_4;

public class Phone {
	private String country_;
	private String area_;
	private String number_;
	
	public Phone(String country, String area, String number) {
		country_ = country;
		area_ = area;
		number_ = number;
	}
	
	public String country() { return country_; }
	public String area() { return area_; }
	public String number() { return number_; }	
}
