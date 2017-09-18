package exercicio_aula_3;

import java.util.LinkedHashMap;

public class Dec2Roman {
	public static String conv(int num) {
		return conv12(num);
	}
	
	public static String conv0(int num) {
		return null;
	}
	
	public static String conv1(int num) {
		return "I";
	}
	
	public static String conv2(int num) {
		 String res = "I";
	     if (num > 1)
	     { res += "I"; }
	     return res;
	}

	public static String conv3(int num) {
		 String res = "I";
	     if (num > 1)
	     { res += "I"; }
	     if (num > 2)
	     { res += "I"; }
	     return res;
	}

	public static String conv4(int num) {
		 String res = "";
		 
		 if(num == 5) {
			 res = "V";
		 }
		 else {
			 res = "I";
		 }
		 
		 if(num == 4) {
			 res += "V";
		 }
		 else if(num < 4){
			 if (num > 1)
		     { res += "I"; }
		     if (num > 2)
		     { res += "I"; }
		 }
		 
	     return res;
	}

	public static String conv5(int num) {
		 String res = "";
		 
		 if(num >= 5) {
			 res = "V";
			 for(int i = 5; i < num; i++) {
				 res += "I";
			 }
		 }
		 else {
			 res = "I";
		 }
		 
		 if(num == 4) {
			 res += "V";
		 }
		 else if(num < 4){
			 for(int i = 1; i < num; i++) {
				 res += "I";
			 }
		 }
		 
	     return res;
	}
	
	public static String conv6(int num) {
		 String res = "";
		 
		 if(num == 9) {
			 res = "IX";
		 }
		 else if(num == 10) {
			 res = "X";
		 }
		 else if(num >= 5) {
			 res = "V";
			 for(int i = 5; i < num; i++) {
				 res += "I";
			 }
		 }
		 else {
			 res = "I";
		 }
		 
		 if(num == 4) {
			 res += "V";
		 }
		 else if(num < 4){
			 for(int i = 1; i < num; i++) {
				 res += "I";
			 }
		 }
		 
	     return res;
	}

	public static String conv7(int num) {
		 String res = "";
		 
		 if(num <= 4 || num == 9) {
			 res = "I";
		 }
		 
		 if(num >= 9) {
			 res += "X";
			 if(num < 14) {
				 for(int i = 10; i < num; i++) {
					 res += "I";
				 }
			 }
			 else {
				 
			 }
		 }
		 else if(num >= 5) {
			 res = "V";
			 for(int i = 5; i < num; i++) {
				 res += "I";
			 }
		 }
		 else if(num == 4) {
			 res += "V";
		 }
		 else if(num < 4){
			 for(int i = 1; i < num; i++) {
				 res += "I";
			 }
		 }
		 
	     return res;
	}
		
	public static String conv8(int num) {
    	LinkedHashMap <Integer, String> Results = new LinkedHashMap <Integer, String>();

    	Results.put(1,"I");	    Results.put(4, "IV");   Results.put(5,"V");	    
    	Results.put(9, "IX");   Results.put(10,"X");   	
    	
    	if(num == 0) {
    		return "";
    	}

    	for(int i = 15; i >= 1; i--) {
            if(Results.containsKey(i) && i <= num) {
                return Results.get(i) + conv8(num - i);
            }    		
    	}
    	
    	return "";
    }

	public static String conv9(int num) {
    	LinkedHashMap <Integer, String> Results = new LinkedHashMap <Integer, String>();

    	Results.put(1,"I");	    Results.put(4, "IV");   Results.put(5,"V");	    
    	Results.put(9, "IX");   Results.put(10,"X");   	Results.put(40, "XL");
    	Results.put(50,"L");    
    	
    	if(num == 0) {
    		return "";
    	}

    	for(int i = 50; i >= 1; i--) {
            if(Results.containsKey(i) && i <= num) {
                return Results.get(i) + conv9(num - i);
            }    		
    	}
    	
    	return "";
    }	
	
	public static String conv10(int num) {
    	LinkedHashMap <Integer, String> Results = new LinkedHashMap <Integer, String>();

    	Results.put(1,"I");	    Results.put(4, "IV");   Results.put(5,"V");	    
    	Results.put(9, "IX");   Results.put(10,"X");   	Results.put(40, "XL");
    	Results.put(50,"L");    Results.put(90, "XC");  Results.put(100,"C");   
    	    	
    	if(num == 0) {
    		return "";
    	}

    	for(int i = 100; i >= 1; i--) {
            if(Results.containsKey(i) && i <= num) {
                return Results.get(i) + conv10(num - i);
            }    		
    	}
    	
    	return "";
    }	

	public static String conv11(int num) {
    	LinkedHashMap <Integer, String> Results = new LinkedHashMap <Integer, String>();

    	Results.put(1,"I");	    Results.put(4, "IV");   Results.put(5,"V");	    
    	Results.put(9, "IX");   Results.put(10,"X");   	Results.put(40, "XL");
    	Results.put(50,"L");    Results.put(90, "XC");  Results.put(100,"C");   
    	Results.put(400, "CD"); Results.put(500,"D");  	
    	
    	if(num == 0) {
    		return "";
    	}

    	for(int i = 500; i >= 1; i--) {
            if(Results.containsKey(i) && i <= num) {
                return Results.get(i) + conv11(num - i);
            }    		
    	}
    	
    	return "";
    }	
	
	public static String conv12(int num) {
    	LinkedHashMap <Integer, String> Results = new LinkedHashMap <Integer, String>();

    	Results.put(1,"I");	    Results.put(4, "IV");   Results.put(5,"V");	    
    	Results.put(9, "IX");   Results.put(10,"X");   	Results.put(40, "XL");
    	Results.put(50,"L");    Results.put(90, "XC");  Results.put(100,"C");   
    	Results.put(400, "CD"); Results.put(500,"D");  	Results.put(900, "CM");
    	Results.put(1000,"M");
    	
    	if(num == 0) {
    		return "";
    	}

    	for(int i = 1000; i >= 1; i--) {
            if(Results.containsKey(i) && i <= num) {
                return Results.get(i) + conv12(num - i);
            }    		
    	}
    	
    	return "";
    }	
}