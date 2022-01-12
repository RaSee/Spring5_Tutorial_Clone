package main;

import chap07.ExeTimeCalculator;
import chap07.ImpeCalculator;
import chap07.RecCalculator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCal1.factorial(20));
		
		ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factorial(20));
	}

}
