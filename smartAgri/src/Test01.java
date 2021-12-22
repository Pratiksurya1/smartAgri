
public class Test01 extends xyx {
	static int num2=m1();
	static int m1() {
		System.out.println("num2 value set..");
		return 10;
	}
	static {
		System.out.println("test01 Static Block is exequted..");
	}
	{
		System.out.println("test01 Non Static Block is exequted...");
	}
	Test01(){
		System.out.println("test01 constractar is exequted...");
	}


}
