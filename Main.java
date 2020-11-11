package Homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Student> studentList = new ArrayList<>();
		int choose;
		do {
			showMenu();
			choose = Integer.parseInt(input.nextLine());
			switch (choose) {
			case 1:
				System.out.println("Input students to add");
				int n = Integer.parseInt(input.nextLine());
				for (int i = 0; i < n; i++) {
					Student std = new Student();
					std.input();
					studentList.add(std);
				}
				break;
			case 2:
				System.out.println("Input id edit: ");
				int id = Integer.parseInt(input.nextLine());
				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).getId() == id) {
						studentList.get(i).Edit();
						break;
					} else {
						System.out.println("No this student");
					}
				}
				break;
			case 3:
				System.out.println("Input id student to be delete ");
				int deleteId = Integer.parseInt(input.nextLine());
				for (int i = 0; i < studentList.size(); i++) {
					if (studentList.get(i).getId() == deleteId) {
						studentList.remove(i);
						break;
					} else {
						System.out.println("No this student");
					}
				}

				break;
			case 4:
				Collections.sort(studentList, new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {
						// TODO Auto-generated method stub
						// Giảm dần
						if (o1.getGpa() < o2.getGpa()) {
							return -1;
						}
						return 1;
					}
				});
				for (int i = 0; i < studentList.size(); i++) {
					studentList.get(i).showInput();
				}
				break;
			case 5:
				Collections.sort(studentList, (o1, o2) -> {
					return o1.getName().compareTo(o2.getName());
				});
				for (int i = 0; i < studentList.size(); i++) {
					studentList.get(i).showInput();
				}
				break;
			case 6:
				for (int i = 0; i < studentList.size(); i++) {
					studentList.get(i).showInput();
				}
				break;
			case 7:
				FileOutputStream fos = null;
				ObjectOutputStream oos = null;
				try {
					fos = new FileOutputStream("student.dat");
					oos = new ObjectOutputStream(fos);
					oos.writeObject(studentList);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (fos != null) {
							fos.close();
						}
						if (oos != null) {
							oos.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			case 8:
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				try {
					fis = new FileInputStream("student.dat");
					ois = new ObjectInputStream(fis);
					studentList = (List<Student>) ois.readObject();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (fis != null) {
							fis.close();
						}
						if (ois != null) {
							ois.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				break;

			case 9:
				System.out.println("Goodbye");
				break;
			default:
				System.err.println("Input fail.!!");
				break;
			}
		} while (choose != 9);
	}

	public static void showMenu() {
		System.out.println("---------------------------------------");
		System.out.println("1. Add students");
		System.out.println("2. Edit students by id");
		System.out.println("3. Delete student by id");
		System.out.println("4. Sort students by gpa");
		System.out.println("5. Sort student by name");
		System.out.println("6. Show students");
		System.out.println("7. Save students in file student.obj");
		System.out.println("8. Read students in file sutdent.obj");
		System.out.println("9. Exit");
		System.out.println("-----------------------------------------s");
		System.out.println("Choose: ");
	}
}
