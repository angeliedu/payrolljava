package ProjectPayroll;

public class employeePT  extends employee{
	Double ratepay = 0.0;
	Double hourswork = 0.0;
	Double earnings = 0.0;
	
	
	
	public  double calcEarnings() {
		return this.hourswork * this.ratepay;
		
		
	}

}
