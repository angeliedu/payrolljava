package ProjectPayroll;

import java.util.ArrayList;
import java.util.Scanner;

public class payroll {
    static ArrayList<employeeFT> arremployeeFT = new ArrayList<employeeFT>();
    static ArrayList<employeePT> arremployeePT = new ArrayList<employeePT>();
    static ArrayList<employeeINTL> arremployeeINTL = new ArrayList<employeeINTL>();
    
    
    static Scanner input = new Scanner(System.in);

    static String name = "";
    static String ID;
    static String age;
    static int type;
    static double salary;
    static double bonus;
    static double rate;
    static double hours;
    static double stipend;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        employee e1 = new employee();

        while (!name.equals("999")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter name: ");
            name = input.nextLine();

            if (name.equals("999")) {
                break;
            }
            System.out.println("Enter your age: ");
            age = input.nextLine();
            
            
            System.out.println("Enter if you have a car (1 to have a car or 2 no have car): ");
            int car = input.nextInt();
            // veichle V1 = null;
            veichle V1 = new veichle();
            if (car == 1) {
                
                
                System.out.println("Enter who make the car:");
                String make = input.next();
                
                System.out.println("Enter model of the car:");
                String model = input.next();
                
                V1.make = make;
                V1.model = model;
                
                
                // System.out.println("The company make your car is "+make + " and the model is " + model);
                input.nextLine(); // consume the newline
            } else if (car == 2) {
                System.out.println("You don't have a car.");
                input.nextLine();
            }
			
			
            
            System.out.println("Enter your ID: ");
            ID = input.nextLine();

            System.out.println("Enter your type of contract (1 to Full-Time, 2 to Part-time or 3 to Intern): ");
            type = input.nextInt();

            if (type == 1) {
                employeeFT FT_e1 = new employeeFT();

                System.out.println("Enter your salary: ");
                salary = input.nextDouble();
                System.out.println("Enter your bonus: ");
                bonus = input.nextDouble();

                FT_e1.name = name;
                FT_e1.age = age;
                FT_e1.ID = ID;
                FT_e1.V1 = V1;
                FT_e1.salary = salary;
                FT_e1.bonus = bonus;

                double FT_earning = FT_e1.calcEarnings();

                System.out.println("Full-time earnings is " + FT_earning);

                arremployeeFT.add(FT_e1);
            } else if (type == 2) {
                employeePT PT_e1 = new employeePT();

                System.out.println("Enter your rate: ");
                rate = input.nextDouble();

                System.out.println("Enter your hours of work: ");
                hours = input.nextDouble();

                PT_e1.name = name;
                PT_e1.age = age;
                PT_e1.ID = ID;
                PT_e1.V1 = V1;
                PT_e1.ratepay = rate;
                PT_e1.hourswork = hours;

                double PT_earning = PT_e1.calcEarnings();

                System.out.println("Part-time earnings is " + PT_earning);

                arremployeePT.add(PT_e1);
            } else if (type ==3) {
            	employeeINTL INT_e1 = new employeeINTL();
            	
            	System.out.println("Enter your stipend: ");
            	stipend = input.nextDouble();
            	
            	INT_e1.name = name;
            	INT_e1.age = age;
            	INT_e1.ID = ID;
            	INT_e1.V1 = V1;
            	INT_e1.stipend = stipend;
            	
            	double INTL_earning = INT_e1.calcEarnings();
            	
            	System.out.println("Intern earning is: " + INTL_earning);
            	
            	arremployeeINTL.add(INT_e1);
            	
            }
            
        }

        for (int i = 0; i < arremployeeFT.size(); i++) {
            employeeFT ftEmployee = arremployeeFT.get(i);
            System.out.println("Full-Time Employee Details:");
            System.out.println("Name: " + ftEmployee.name);
            System.out.println("Age: " + ftEmployee.age);
            System.out.println("ID: " + ftEmployee.ID);
            System.out.println("Salary: " + ftEmployee.salary);
            System.out.println("Bonus: " + ftEmployee.bonus);
            //System.out.println("CAR manufacturer is " + ftEmployee.V1.make +" and your car model is " + ftEmployee.V1.model);
            if (ftEmployee.V1.make != null && !ftEmployee.V1.make.isEmpty() && ftEmployee.V1.model != null && !ftEmployee.V1.model.isEmpty()) {
                System.out.println("CAR manufacturer is " + ftEmployee.V1.make +" and your car model is " + ftEmployee.V1.model); 
            }
            System.out.println("Total earnings: " + (ftEmployee.salary + ftEmployee.bonus));
            System.out.println();
        }

        for (int i = 0; i < arremployeePT.size(); i++) {
            employeePT ptEmployee = arremployeePT.get(i);
            System.out.println("Part-Time Employee Details:");
            System.out.println("Name: " + ptEmployee.name);
            System.out.println("Age: " + ptEmployee.age);
            System.out.println("ID: " + ptEmployee.ID);
            System.out.println("Rate: " + ptEmployee.ratepay);
            System.out.println("Hours Worked: " + ptEmployee.hourswork);
           //System.out.println("CAR manufacturer is " + ptEmployee.V1.make +" and your car model is " + ptEmployee.V1.model);
            if (ptEmployee.V1.make != null && !ptEmployee.V1.make.isEmpty() && ptEmployee.V1.model != null && !ptEmployee.V1.model.isEmpty()) {
                System.out.println("CAR manufacturer is " + ptEmployee.V1.make +" and your car model is " + ptEmployee.V1.model);
            }
            System.out.println("Total earnings: " + (ptEmployee.ratepay * ptEmployee.hourswork));
            System.out.println();
        }
        for (int i = 0; i < arremployeeINTL.size(); i++) {
            employeeINTL intEmployee = arremployeeINTL.get(i);
            System.out.println("Part-Time Employee Details:");
            System.out.println("Name: " + intEmployee.name);
            System.out.println("Age: " + intEmployee.age);
            System.out.println("ID: " + intEmployee.ID);
            System.out.println("Stipend: " + intEmployee.stipend);
            System.out.println("TAX: " + intEmployee.taxes);
            //System.out.println("CAR manufacturer is " + intEmployee.V1.make +" and your car model is " + intEmployee.V1.model);
            if (intEmployee.V1.make != null && !intEmployee.V1.make.isEmpty() && intEmployee.V1.model != null && !intEmployee.V1.model.isEmpty()) {
                System.out.println("CAR manufacturer is " + intEmployee.V1.make +" and your car model is " + intEmployee.V1.model);
            }
            System.out.println("Total earnings: " + (intEmployee.stipend - intEmployee.taxes));
            System.out.println();
        }
    }
}
       

