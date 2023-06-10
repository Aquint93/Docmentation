package CEN3024C;

class Recursive extends Thread {
	public int fibonacci(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	@Override
	public void run() {
		for(int i =10; i <= 30; i+=10) {
		long before = System.nanoTime();
		int answer = fibonacci(i);
		long time = System.nanoTime() - before;
		
		System.out.println("Recursive "+i+":\t"+answer+"\t\t"+time+" ns");
		}
	}
}

class Iterative extends Thread {
	
	public static int fibonacci(int n) {
		int v1 = 0;
		int v2 = 1;
		int v3 = 0;
		
		for(int i = 2; i <= n; i++) {
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		}
		return v3;
	}
	@Override
	public void run() {
		for(int i =10; i <= 30; i+=10) {
		long before = System.nanoTime();
		int answer = fibonacci(i);
		long time = System.nanoTime() - before;
		
		System.out.println("Iterative "+i+":\t"+ answer+"\t\t"+time+" ns");
		}
	}
}


public class XYChart {
	
	public static void main(String[] args) {
		Iterative d = new Iterative();
		Recursive r = new Recursive();
	
		System.out.println("Type\t\tAnswer\t\tTime");
		d.start();
		r.start();
	}
	
	
}