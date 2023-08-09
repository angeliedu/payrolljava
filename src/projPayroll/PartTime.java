package projPayroll;

public class PartTime extends Employee {
	double dRate = 0;
	double dHrs = 0;
	double dEarning = 0;
	double dTax = 0;
	double dTaxPercent = 0;
	double dGrossIncome = 0;

	public double calcEarnings() {
		return (this.dHrs * this.dRate) - this.dTax;
	}

	public double calcTax() {
		return (this.dHrs * this.dRate) * this.dTaxPercent;
	}
	
	public double getdGrossIncome() {
		return dGrossIncome;
	}

	public void setdGrossIncome(double dGrossIncome) {
		this.dGrossIncome = dGrossIncome;
	}

	public double getdTaxPercent() {
		return dTaxPercent;
	}

	public void setdTaxPercent(double dTaxPercent) {
		this.dTaxPercent = dTaxPercent / 100;
	}

	public double getdTax() {
		return dTax;
	}

	public void setdTax(double dTax) {
		this.dTax = dTax;
	}
	
	public double getdRate() {
		return dRate;
	}

	public void setdRate(double dRate) {
		this.dRate = dRate;
	}

	public double getdHrs() {
		return dHrs;
	}

	public void setdHrs(double dHrs) {
		this.dHrs = dHrs;
	}

	public double getdEarning() {
		return dEarning;
	}

	public void setdEarning(double dEarning) {
		this.dEarning = dEarning;
	}
	
}
