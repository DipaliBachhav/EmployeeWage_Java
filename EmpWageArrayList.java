import java.util.ArrayList;

public class EmpWageArrayList {

	public final int IS_PART_TIME = 0;
	public final int IS_FULL_TIME = 1;
	public int totalEmpHrs;
	public int empHrs;
        public int empDailyWage;
        public int totalWorkingDays;
        public int empTotalWage;


	ArrayList<Integer> empDailyAndTotalWage = new ArrayList<Integer> ();
	public void callEmpWage(CompanyEmpWage company) {

		while ( totalEmpHrs <= company.getmaxHoursPerMonth() && totalWorkingDays < company.getMaxWorkingDays() ) {
			totalWorkingDays++;
			int empCheck = ((int) Math.floor(Math.random() * 10)) % 3;
			switch(empCheck) {
				case IS_PART_TIME:
					empHrs=4;
					break;
				case IS_FULL_TIME:
					empHrs=8;
					break;
				default:
					empHrs=0;
			}
			totalEmpHrs += empHrs;
			empDailyWage=empHrs*company.getempRatePerHours();
			empDailyAndTotalWage.add(empDailyWage);
			System.out.println("Day : " + totalWorkingDays + " Employee hours : " + empHrs+ " Employee Daily Wage : " +empDailyWage);
		}
		empTotalWage=totalEmpHrs * company.getempRatePerHours();
		empDailyAndTotalWage.add(empTotalWage);
		company.setTotalEmpWage(empTotalWage);
		System.out.println("Total Wage of " + company.getcompanyName() + " Employee is " + company.getTotalEmpWage());
	}

	public static void main(String args[]) {
		System.out.println("Welcome to Employee Wage Computation");
		EmpWageArrayList empwagecomputation = new EmpWageArrayList();
		ArrayList<CompanyEmpWage> company = new ArrayList<CompanyEmpWage>();

		company.add( new CompanyEmpWage("D-Mart",20,2,100));
		empwagecomputation.callEmpWage(company.get(0));
		System.out.println("Total Wage Of Employee Of D-Mart := "+company.get(0).getTotalEmpWage());

		company.add( new CompanyEmpWage("Big Bazar",50,2,100));
		empwagecomputation.callEmpWage(company.get(1));
		System.out.println("Total Wage Of Employee Of Big Bazar := "+company.get(1).getTotalEmpWage());

}

}
class CompanyEmpWage {
	public String companyName;
	public int empRatePerHours;
	public int maxWorkingDays;
	public int maxHoursPerMonth;
	public int totalEmpWage=0;
	public CompanyEmpWage(String companyName,int empRatePerHours, int maxWorkingDays, int maxHoursPerMonth) {
		this.empRatePerHours = empRatePerHours;
		this.maxWorkingDays = maxWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
		this.companyName=companyName;
	}

	public int getempRatePerHours() {
		return empRatePerHours;
	}
	public int getMaxWorkingDays() {
		return maxWorkingDays;
	}
	public int getmaxHoursPerMonth() {
		return maxHoursPerMonth;
	}
	public String getcompanyName() {
		return companyName;
	}
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	public int getTotalEmpWage() {
		return totalEmpWage;
	}
}
