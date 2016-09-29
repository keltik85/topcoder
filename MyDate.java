
import java.util.*;

public class MyDate
{
	static String [] WEEKDAYS = {
		/*0*/"Monday",
		/*1*/"Tuesday",
		/*2*/"Wednesday",
		/*3*/"Thursday",
		/*4*/"Friday",
		/*5*/"Saturday",
		/*6*/"Sunday"
	};
	static HashMap<Integer,Integer> MONTH_MAP;
	
	public MyDate(){
		MONTH_MAP = new HashMap<Integer,Integer>();
		MONTH_MAP.put(1,31);
		MONTH_MAP.put(3,31);
		MONTH_MAP.put(5,31);
		MONTH_MAP.put(7,31);
		MONTH_MAP.put(8,31);
		MONTH_MAP.put(10,31);
		MONTH_MAP.put(12,31);
		MONTH_MAP.put(4,30);
		MONTH_MAP.put(6,30);
		MONTH_MAP.put(9,30);
		MONTH_MAP.put(11,30);
		MONTH_MAP.put(2,28);
	}
	
	public String getDay(int month, int day, int year){
		int sumOfDays = 0;
		for(int i = 1; i <= month; i++){
			if(i == month){
				sumOfDays = sumOfDays + day;
			}else{
				sumOfDays = sumOfDays + MONTH_MAP.get(i);
			}
		}
		if(year == 1992 || year == 1996){
			sumOfDays = sumOfDays + 1;	
		}
		
		for(int j = 1990; j < year; j++){
			if(j == 1992 || j == 1996){
				sumOfDays = sumOfDays + 366;
			}else{
				sumOfDays = sumOfDays + 365;
			}
		}
		int magicModulo = (sumOfDays % 7) - 1;
		if(magicModulo == -1){
			magicModulo = 6;
		}
		System.out.println("date: " + month + ", " + day + ", " + year + " ---> " + WEEKDAYS[magicModulo]);
		return WEEKDAYS[magicModulo];
	}
}
