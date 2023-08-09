package projPayroll;

import java.util.ArrayList;
import java.util.Scanner;

public class Payroll {
	
	static ArrayList<FullTime> arrEmployeesFT = new ArrayList<FullTime>();	
	static ArrayList<PartTime> arrEmployeesPT = new ArrayList<PartTime>();	
	static ArrayList<Intern> arrEmployeesIntern = new ArrayList<Intern>();	
	static String sPRName = "";
	static String sPRId = "";
	static String sPRAge = "";
	static int iType =0;
	static double dSalary=0;
	static double dBonus = 0;
	static double dRate = 0;
	static double dHrs = 0;
	static double dStipend = 0;
	static double dTax = 0;
	static int iHasCar = 0;
	static String sModel = "";
	static String sMake ="";
	static Vehicle vehicle;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Final Course Project");

		String sAnswer = "";
		boolean bPrinted = false;
		boolean bNewData= true;
		while (bNewData) {
			Scanner input = new Scanner(System.in); 
			if (arrEmployeesFT.isEmpty() && arrEmployeesPT.isEmpty() && arrEmployeesIntern.isEmpty()) {
				displayDetails(input);
			}
			else {
				if (!sAnswer.equals("")) {
					sAnswer = validateEntry(0,sAnswer,new String[]{ "Y", "N"},"Invalid Entry! Enter Y/N only:",true);
				}
				if (sAnswer.equals("Y")){
					bPrinted = false;
					displayDetails(input);
					sAnswer = "";
				}
				else {
					if (sAnswer.equals("N")){
						bNewData = false;
					}
				}
				if (sAnswer.equals("")){
					if (!bPrinted) {
						System.out.println("Do you want to enter new employee earnings (Y/N)?");
						bPrinted = true;
					}
					sAnswer = input.nextLine();
				}
			}
		}
		System.out.println("");
		System.out.println("Employee Earnings Summary");
		double dTotalErnings = 0;
		System.out.println("");
		for (int i =0; i<arrEmployeesFT.size();i++) {
			System.out.println("FULL TIME - Name: " + arrEmployeesFT.get(i).getsName() + ", Age: " + arrEmployeesFT.get(i).getsAge()+", ID: " + arrEmployeesFT.get(i).getsId());
			System.out.println("            Gross Income:" + arrEmployeesFT.get(i).getdGrossIncome()+", Tax: " + arrEmployeesFT.get(i).getdTax()+", Earnings: " + arrEmployeesFT.get(i).getdEarning());
			if (arrEmployeesFT.get(i).vehicle.sMake != null) {
				System.out.println(" ---VEHICLE: Make: " + arrEmployeesFT.get(i).vehicle.getsMake() + ", Model: " + arrEmployeesFT.get(i).vehicle.getsModel());
			}
			else {
				System.out.println(" ---VEHICLE: NONE");
			}
			dTotalErnings = dTotalErnings + arrEmployeesFT.get(i).getdEarning();
		}
		System.out.println("");
		for (int i =0; i<arrEmployeesPT.size();i++) {
			System.out.println("PART TIME - Name: " + arrEmployeesPT.get(i).getsName() + ", Age: " + arrEmployeesPT.get(i).getsAge()+", ID: " + arrEmployeesPT.get(i).getsId());
			System.out.println("            Gross Income:" + arrEmployeesPT.get(i).getdGrossIncome()+", Tax: " + arrEmployeesPT.get(i).getdTax()+", Earnings: " + arrEmployeesPT.get(i).getdEarning());

			if (arrEmployeesPT.get(i).vehicle.sMake != null) {
				System.out.println(" ---VEHICLE: Make: " + arrEmployeesPT.get(i).vehicle.getsMake() + ", Model: " + arrEmployeesPT.get(i).vehicle.getsModel());
			}
			else {
				System.out.println(" ---VEHICLE: NONE");
			}
			dTotalErnings = dTotalErnings + arrEmployeesPT.get(i).getdEarning();
		}
		System.out.println("");
		for (int i =0; i<arrEmployeesIntern.size();i++) {
			System.out.println("INTERN - Name: " + arrEmployeesIntern.get(i).getsName() + ", Age: " + arrEmployeesIntern.get(i).getsAge()+", ID: " + arrEmployeesIntern.get(i).getsId());
			System.out.println("         Gross Income:" + arrEmployeesIntern.get(i).getdGrossIncome()+", Tax: " + arrEmployeesIntern.get(i).getdTax()+", Earnings: " + arrEmployeesIntern.get(i).getdEarning());
			if (arrEmployeesIntern.get(i).vehicle.sMake != null) {
				System.out.println(" ---VEHICLE: Make: " + arrEmployeesIntern.get(i).vehicle.getsMake() + ", Model: " + arrEmployeesIntern.get(i).vehicle.getsModel());
			}
			else {
				System.out.println(" ---VEHICLE: NONE");
			}
			dTotalErnings = dTotalErnings + arrEmployeesIntern.get(i).getdEarning();
		}
		System.out.println("");
		System.out.println("Total of all Employee Earnings: " + dTotalErnings);
	}

	private static void displayDetails(Scanner input) {
		String sAnswer = "";
		System.out.println("Enter Name:");
		sPRName = input.nextLine();
		
		System.out.println("Enter Age");
		sPRAge = input.nextLine();
		sAnswer = sPRAge;
		sAnswer = validateEntry(1,sAnswer,new String[]{},"Invalid Entry! Enter number value only:",false);
		sPRAge = sAnswer;
		
		
		System.out.println("Enter ID");
		sPRId = input.nextLine();
		
		iHasCar = 0;
		System.out.println("Do you have a car (1-YES/2-NO)?");
		sAnswer = input.nextLine();
		vehicle = new Vehicle();
		sAnswer = validateEntry(1,sAnswer,new String[]{ "1", "2"},"Invalid Entry! Enter 1-YES/2-NO only:",true);
		iHasCar = Integer.parseInt(sAnswer);
		
		if (iHasCar ==1) {
			Scanner inputVehicle = new Scanner(System.in); 
			System.out.println("Enter your car's make?");
			sMake = inputVehicle.nextLine();
			vehicle.setsMake(sMake);
			
			System.out.println("Enter your car's model?");
			sModel = inputVehicle.nextLine();
			vehicle.setsModel(sModel);
		}
		
		System.out.println("Enter Type (1 = FullTime 2=PartTime 3=Intern)");
		sAnswer = input.nextLine();
		sAnswer = validateEntry(1,sAnswer,new String[]{ "1", "2","3"},"Invalid Entry! Enter 1 = FullTime 2=PartTime 3=Intern only:",true);
		iType = Integer.parseInt(sAnswer);

		if (iType ==1) {
			FullTime fullTime = new FullTime();
			
			System.out.println("Enter Salary:");
			sAnswer = input.nextLine();
			sAnswer = validateEntry(2,sAnswer,new String[]{},"Invalid Entry! Enter numeric value only:",false);
			dSalary = Double.parseDouble(sAnswer);

			System.out.println("Enter Bonus:");
			sAnswer = input.nextLine();
			sAnswer = validateEntry(2,sAnswer,new String[]{},"Invalid Entry! Enter numeric value only:",false);
			dBonus = Double.parseDouble(sAnswer);
			
			fullTime.setsName(sPRName);
			fullTime.setsAge(sPRAge);
			fullTime.setsId(sPRId);
			fullTime.setVehicle(vehicle);
			fullTime.setdSalary(dSalary);
			fullTime.setdBonus(dBonus);
			fullTime.setdTaxPercent(18.00);
			fullTime.setdTax(fullTime.calcTax());
			fullTime.setdEarning(fullTime.calcEarnings());
			fullTime.setdGrossIncome(fullTime.getdEarning() + fullTime.getdTax());

			arrEmployeesFT.add(fullTime);
			
		}
		else if (iType ==2) {
			PartTime partTime = new PartTime();
			
			System.out.println("Enter Hrs Worked:");
			sAnswer = input.nextLine();
			sAnswer = validateEntry(2,sAnswer,new String[]{},"Invalid Entry! Enter numeric value only:",false);
			dHrs = Double.parseDouble(sAnswer);
			
			System.out.println("Enter Rate:");
			sAnswer = input.nextLine();
			sAnswer = validateEntry(2,sAnswer,new String[]{},"Invalid Entry! Enter numeric value only:",false);
			dRate = Double.parseDouble(sAnswer);
			
			partTime.setsName(sPRName);
			partTime.setsAge(sPRAge);
			partTime.setsId(sPRId);
			partTime.setVehicle(vehicle);
			partTime.setdHrs(dHrs);
			partTime.setdRate(dRate);
			partTime.setdTaxPercent(15.00);
			partTime.setdTax(partTime.calcTax());
			partTime.setdEarning(partTime.calcEarnings());
			partTime.setdGrossIncome(partTime.getdEarning() + partTime.getdTax());
			
			arrEmployeesPT.add(partTime);
		}
		else {
			Intern intern = new Intern();
			
			System.out.println("Enter Stipend:");
			sAnswer = input.nextLine();
			sAnswer = validateEntry(2,sAnswer,new String[]{},"Invalid Entry! Enter numeric value only:",false);
			dStipend = Double.parseDouble(sAnswer);
			
			intern.setsName(sPRName);
			intern.setsAge(sPRAge);
			intern.setsId(sPRId);
			intern.setVehicle(vehicle);
			intern.setdStipend(dStipend);
			intern.setdTaxPercent(15.00);
			intern.setdTax(intern.calcTax());
			intern.setdEarning(intern.calcEarnings());
			intern.setdGrossIncome(intern.getdEarning() + intern.getdTax());
			
			arrEmployeesIntern.add(intern);
		}
	}
	
	private static String validateEntry(int pSource,String pAnswer, String [] pChoices,String pMessage,boolean bCompare) {
		boolean bEntry= true;
		String strAnswer = pAnswer;
		
		while (bEntry) {
			Scanner input = new Scanner(System.in); 
			if (pSource ==0) {
				if (!containsItemFromArray(strAnswer,pChoices)) {
					System.out.println(pMessage);
					strAnswer = input.nextLine();
					bEntry= true;
				}
				else {
					bEntry = false;
				}
			}
			else if (pSource ==1) {
				if (isInteger(strAnswer)) {
					if (bCompare) {
						if (!containsItemFromArray(strAnswer,pChoices)) {
							System.out.println(pMessage);
							strAnswer = input.nextLine();
							bEntry= true;
						}
						else {
							bEntry = false;
						}
					}
					else {
						bEntry = false;
					}
				}
				else {
					System.out.println(pMessage);
					strAnswer = input.nextLine();
					bEntry= true;
				}
			}
			else {
				if (isDouble(strAnswer)) {
					if (bCompare) {
						if (!containsItemFromArray(strAnswer,pChoices)) {
							System.out.println(pMessage);
							strAnswer = input.nextLine();
							bEntry= true;
						}
						else {
							bEntry = false;
						}
					}
					else {
						bEntry = false;
					}
				}
				else {
					System.out.println(pMessage);
					strAnswer = input.nextLine();
					bEntry= true;
				}
			}
			
		}
		return strAnswer;
	}
	public static boolean containsItemFromArray(String inputString, String[] items) {
		boolean bReturn = false;
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].equals (inputString))
			{
				bReturn =  true;
				break;
			}
			else
			{
				bReturn =  false;
			}
		}
		return bReturn;
	}
	
	public static boolean isInteger(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isDouble(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
