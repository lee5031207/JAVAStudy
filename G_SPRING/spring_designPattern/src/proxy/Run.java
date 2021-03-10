package proxy;

public class Run {
	public static void main(String[] args) {
		Developer manProxy = new Aspect("proxy.Man");
		Developer womanProxy = new Aspect("proxy.Woman");
		Developer childProxy = new Aspect("proxy.Child");
		
		manProxy.develop();
		System.out.println("=============");
		womanProxy.develop();
		System.out.println("=============");
		childProxy.develop();
	}
}
