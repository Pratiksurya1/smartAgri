
public class xyx {
	static int num1=m1();
	
	
	static int m1() {
		System.out.println("num1 value set..");
		return 10;
	}
	static {
		System.out.println("Supar Static Block is exequted..");
	}
	{
		System.out.println("Supar Non Static Block is exequted...");
	}
	xyx(){
		System.out.println("Supar constractar is exequted...");
	}
}
