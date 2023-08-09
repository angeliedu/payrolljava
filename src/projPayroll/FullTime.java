package projPayroll;

public class FullTime extends Employee {
	double dSalary = 0;
	double dBonus = 0;
	double dEarning = 0;
	double dTax = 0;
	double dTaxPercent = 0;
	double dGrossIncome = 0;

	public double calcEarnings() {
		return (this.dSalary + this.dBonus) - this.dTax ;
	}
	
	public double calcTax() {
		return (this.dSalary + this.dBonus)* this.dTaxPercent;
	}
	
	public double getdGrossIncome() {
		return dGrossIncome;
	}

	public void setdGrossIncome(double dGrossIncome) {
		this.dGrossIncome = dGrossIncome;
	}

	public double getdTax() {
		return dTax;
	}

	public void setdTax(double dTax) {
		this.dTax = dTax;
	}
	public double getdTaxPercent() {
		return dTaxPercent;
	}

	public void setdTaxPercent(double dTaxPercent) {
		this.dTaxPercent = dTaxPercent / 100;
	}
	
	public double getdSalary() {
		return dSalary;
	}

	public void setdSalary(double dSalary) {
		this.dSalary = dSalary;
	}

	public double getdBonus() {
		return dBonus;
	}

	public void setdBonus(double dBonus) {
		this.dBonus = dBonus;
	}

	public double getdEarning() {
		return dEarning;
	}

	public void setdEarning(double dEarning) {
		this.dEarning = dEarning;
	}
	

}
