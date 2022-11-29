package studio9;

import assignment7.Student;
import java.util.Map;

public class UniversityDatabase {
	private final Map<String, Student> m;
	private List String<>
	public UniversityDatabase(Map a) {
		m = a;
	}
	public class Student {
		private String Firstname ;
		private String Lastname;
		private String Fullname;
		private int ID;
		private int AttempC;
		private int PassC;
		private double TotalGradeQualityP;
		private double balance;
		private double GPA;
		private double cashout;

		
		public Student(String Fname, String Lname, int id) {
			Firstname = Fname;
			Lastname = Lname;
			Fullname = Fname + " " + Lname;
			ID = id;
		}
		
		/**
		 * 
		 * @return lastname
		 */
		
		public String getLastname() {
			return Lastname;
		}
		
		/**
		 * 
		 * @return Fullname
		 */
		public String getFullName() {
			return Fullname;
		}
		/**
		 * 
		 * @return ID
		 */
		public int getId() {
			return ID;
		}
	/**
	 * 
	 * @param grade
	 * @param credit
	 */
		public void submitGrade(double grade, int credit) {
			AttempC = AttempC + credit;
			TotalGradeQualityP = TotalGradeQualityP + credit*grade;
			if(grade>1.7) {
				PassC = PassC + credit;
			}
		}

		public int getTotalAttemptedCredits() {
			return AttempC;
		}
		public int getTotalPassingCredits() {
			return PassC;
		}
		/**
		 * 
		 * @return GPA
		 */
		public double calculateGradePointAverage() {
			GPA = TotalGradeQualityP/AttempC;
			return GPA;
		}
		/**
		 * 
		 * @return First Year, Sophomore, Junior or Senior
		 */
		public String getClassStanding() {
			if (PassC < 30) {
				return "First Year";
			}else if (PassC >= 30 && PassC<60) {
				return "Sophomore";
			}else if (PassC >= 60 && PassC<90) {
				return "Junior";
			}else{
				return "Senior";
			}
		}
		
		/**
		 * 
		 * @return true or false
		 */
		
		public boolean isEligibleForPhiBetaKappa() {
			calculateGradePointAverage();
			if (PassC >= 98 && GPA >=3.60) {
				return true;
			}
			if (PassC >= 75 && GPA >=3.80) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void depositBearBucks(double amount) {
			balance += amount;
		}
		
		public void deductBearBucks(double amount) {
			balance -= amount;
		}
		
		public double getBearBucksBalance() {
			return balance;
		}
		/**
		 * 
		 * @return cash out amount
		 */
		public double cashOutBearBucks() {
			if(balance < 10) {
				cashout = balance - balance;
			}else{
				cashout = balance - 10;
			}
			balance = 0;
			return cashout;
		}
		/**
		 * 
		 * @param firstName
		 * @param other
		 * @param isHyphenated
		 * @param id
		 * @return new student
		 */
		public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
			String Lname = " ";
			if (isHyphenated == true) {
				Lname = getLastname() + "-" + other.getLastname();
			}else {
				Lname = getLastname();
			}
			Student s  = new Student(firstName, Lname, id);
			s.depositBearBucks(other.cashOutBearBucks() + cashOutBearBucks());
			return s;
		}
		
		public String toString() {
			return Fullname + ID;
		}
	}



	public void addStudent(String accountName, Student student) {
		m.put(accountName,student);
	}

	public int getStudentCount() {
		return m.size();
	}

	public String lookupFullName(String accountName) {
		if(m.get(accountName)==null) {
			return null;
		}else {
		return m.get(accountName).getFullName();
		}
	}

	public double getTotalBearBucks() {
		int total=0;
		for(String s:m.keySet()) {
			m.get(s);
			total += m.get(s).getBearBucksBalance();
		}
		return total;
	}
}
