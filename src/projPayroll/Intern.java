package projPayroll;

public class Intern extends Employee {
	double dStipend = 0;
	double dTax = 0;
	double dEarning = 0;
	double dTaxPercent = 0;
	double dGrossIncome = 0;
	
	public double calcEarnings() {
		return this.dStipend - this.dTax;
	}

	public double calcTax() {
		return this.dStipend * this.dTaxPercent;
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

	public double getdStipend() {
		return dStipend;
	}

	public void setdStipend(double dStipend) {
		this.dStipend = dStipend;
	}

	public double getdTax() {
		return dTax;
	}

	public void setdTax(double dTax) {
		this.dTax = dTax ;
	}

	public double getdEarning() {
		return dEarning;
	}

	public void setdEarning(double dEarning) {
		this.dEarning = dEarning;
	}
	
}
