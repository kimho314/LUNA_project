package day07;

public class TestMain6 {
	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Dog d = new Dog();
		Whale w = new Whale();
		Horse h = new Horse();
		Bear b = new Bear();
		
		r.eating();
		d.eating();
		w.eating();
		
		h.eating();
		h.sleeping();
		h.running();
		
		b.eating();
		b.sleeping();
		
		
		System.out.println("====================");
		h.fly();
		w.fly();
		
		System.out.println("====================");
		// 다형성(polymorphism)
		// 동일한 조작 방법으로 동작시키지만
		// 대상에 따라 다른 실행을 하게 하는 것
		Flyable f = new Horse(); 
		f.fly();
		f = w;
		f.fly();
	}
}
