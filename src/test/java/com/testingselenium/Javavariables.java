package com.testingselenium;

public class Javavariables {
	char ch = 'r';
	int employeeNumber = 9875;
	String employeeName = "prakash";
	static int xyz = 479;

	public int salary(int x, int y) {
		return x * y;
	}
	public static void dispaly() { 
		System.out.println("This is javavariables in Selelinu");
	}

	public static void main(String[] args) {
		Javavariables obj = new Javavariables();
		// TODO Auto-generated method stub
		System.out.println(xyz);
		System.out.println(obj.employeeName);
		System.out.println(obj.employeeNumber);
		System.out.println(obj.salary(10, 10));
		dispaly();
		
	}

}
