package Homework;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
	private int id;
	private String name;
	private int age;
	private String address;
	private float gpa;

	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println(" Input id student: ");
		id = Integer.parseInt(input.nextLine());
		Edit();

	}

	public void Edit() {
		Scanner input = new Scanner(System.in);
		System.out.println(" Input name student: ");
		name = input.nextLine();
		System.out.println(" Input age student: ");
		age = Integer.parseInt(input.nextLine());
		System.out.println("Input address student");
		address = input.nextLine();
		System.out.println("Input gpa student");
		gpa = Float.parseFloat(input.nextLine());
	}

	public void showInput() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + "]";
	}

	public Student(int id, String name, int age, String address, float gpa) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

}
