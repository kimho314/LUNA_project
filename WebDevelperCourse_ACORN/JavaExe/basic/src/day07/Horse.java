package day07;

public class Horse extends Mammal implements Flyable {
	
	@Override
	public void eating()
	{
		System.out.println("풀을 뜯어 먹고 있어요");
	}
	
	@Override
	public void sleeping()
	{
		System.out.println("들판에서 잠을 자고 있어요");
	}
	
	public void running()
	{
		System.out.println("말 달리자");
	}
	
	@Override
	public void fly()
	{
		System.out.println("펄렁펄렁 날아요");
	}
}
