package ProjectPayroll;

public class employeeFT extends employee{
	Double salary = 0.0;
	Double bonus = 0.0;
	Double earnings = 0.0;
	
	public double calcEarnings() {
		return this.salary + this.bonus;
		
			
	}
	
}
