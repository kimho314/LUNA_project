package day06;

public class Person {
	private String name;
	private int age;
	private String gender;
	private float height;
	private float weight;
	
	
	public Person()
	{
		this.name = "none";
		this.age = 0;
		this.gender = "none";
		this.height = 0.0f;
		this.weight = 0.0f;
		System.out.println("Person 클래스의 기본생성자");
	}
	
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
		System.out.println("매개변수 2개짜리 생성자");
	}
	
	public Person(String name, int age, String gender, float height, float weight) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		System.out.println("Person 클래스의 매개변수 있는 생성자");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}
