package acemePackage1;

public class SplitFunction {

	public static void main(String[] args) {

		
		String s1="Mahilara, Gournadi, Barisal, Bangladesh";
		
		String[] split=s1.split(",");
		
		String part1 = split[0];
		String part2 = split[1];
		String part3 = split[2];
		
		System.out.println("SplitFunction   ---"+part1);
		System.out.println("SplitFunction   ---"+part2);
		System.out.println("SplitFunction   ---"+part3);

	}
	

}
