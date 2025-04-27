package main;

public class Student {

	private int id;
	private String stuName;
	private String dept;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Student(int id, String stuName, String dept) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", dept=" + dept + "]";
	}
}
