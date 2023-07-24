package ProjectPayroll;

public class employeeINTL extends employee{
	Double stipend = 0.0;
	Double taxes = 50.00;
	
	
	
	public  double calcEarnings() {
		return this.stipend - this.taxes;
		
		
	}

}


