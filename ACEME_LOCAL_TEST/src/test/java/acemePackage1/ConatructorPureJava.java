package acemePackage1;

public class ConatructorPureJava {

	int age, rollNo, groupNo;
	String lname, fname;

	public ConatructorPureJava(int age, int rollNo, String lname) {
		this.age = age;
		this.rollNo = rollNo;
		this.lname = lname;
	}

	public void Display() {
		System.out.println(age);
	}

	public static void main(String[] args) {
		ConatructorPureJava s1 = new ConatructorPureJava(44, 848, "Mondal");
		ConatructorPureJava s2 = new ConatructorPureJava(33, 333, "Madison");
		ConatructorPureJava s3 = new ConatructorPureJava(55, 444, "Eric");
		
		System.out.println(s1.age);
		System.out.println(s2.age);
		System.out.println(s3.age);
		
		System.out.println("---------------");

		System.out.println(s1.rollNo);
		System.out.println(s2.rollNo);
		System.out.println(s3.rollNo);
		
		System.out.println("----------------");

		System.out.println(s1.lname);
		System.out.println(s2.lname);
		System.out.println(s3.lname);
	}

}
