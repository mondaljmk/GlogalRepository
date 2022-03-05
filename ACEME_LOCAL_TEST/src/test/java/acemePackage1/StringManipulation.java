package acemePackage1;

public class StringManipulation {

	public static void main(String[] args) {

		String str = "The rains have started here";
		String str1 = "The rains have started here";
		String str2 = "The ains have started here";

		// length of the above string
		System.out.println(str.length());// 27

		// what is the value of the 5th index?
		System.out.println(str.charAt(5));// a

		// what is the position of "s"?
		System.out.println(str.indexOf('s'));// 8
		
		// what is the index of 2nd "s"?
		System.out.println(str.indexOf('s', 9));// 15

		// avoiding the hard coded value of '9'
		System.out.println(str.indexOf("s", str.indexOf('s') + 1));// 15

		// what is the position of 'have'
		System.out.println(str.indexOf("have"));// 10

		// what is the index of "hello"?
		System.out.println(str.indexOf("hello"));// -1// not available

		// string comparison// verify that the both string equal
		System.out.println(str.equals(str1));// true

		// string comparison// verify that the both string equal
		System.out.println(str.equals(str2));// false
		// substring
		System.out.println(str.substring(0, 9));// The rains

		// trim
		String string = " Lalmohon Mondal ";
		System.out.println(string.trim());// Lalmohon Mondal

		// middle trim
		System.out.println(string.replace(" ", ""));// LalmohonMondal

		// replace
		String string2 = "01-01-2021";
		System.out.println(string2.replace("-", "/"));// 01/01/2021

		// split
		String string3 = "Dell_HP_Lenovo_Asus_ChromrBook";

		String array[] = string3.split("_");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);

		}
	}

}
