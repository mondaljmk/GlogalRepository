package acemePackage1;

import org.testng.annotations.Test;

public class ConstructorDemo2 {

	@Test
	public void test() {

		ConstructorDemo1 obj =new ConstructorDemo1("Kalachad", "Male", 703911);
		
		obj.displayInformation();
	}
}
