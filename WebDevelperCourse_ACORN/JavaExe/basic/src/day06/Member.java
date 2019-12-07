package day06;

public class Member {
	private int no;
	private String name, id, pw;
	private int grade;
	
	public Member()
	{
		no = 0;
		name = "none";
		id = "none";
		pw = "nono";
		grade = 0;
	}
	
	public Member(int no, String name, String id, String pw, int grade)
	{
		this.no = no;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.grade = grade;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
