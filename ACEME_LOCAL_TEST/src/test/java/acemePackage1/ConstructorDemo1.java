package acemePackage1;

public class ConstructorDemo1 {
	
	String name,sex;
	int hp;
	
	public ConstructorDemo1(String n, String s, int phone) {
		
		this.name=n;
		this.sex=s;
		this.hp=phone;
		
	}
	public void displayInformation() {
		
		System.out.println("Name = "+name);
		System.out.println("Sex = "+sex);
		System.out.println("hp = "+hp);
	}
}
