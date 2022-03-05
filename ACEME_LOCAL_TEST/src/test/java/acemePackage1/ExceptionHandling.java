package acemePackage1;


public class ExceptionHandling {

	
	public static void main(String[] args) {

		try {
			int c = 10 / 0;
			System.out.println("The result of division in===" + c);

		} catch (ArithmeticException e) {
			System.out.println("Something is not right " + e.getMessage());

		}

		finally {
			System.out.println("Always run this block");
			int x, y, z;
			x = 100;
			y = 50;
			z = x / y;
			System.out.println("The return result is==" + z);
		}
		
	
		
	}

}
