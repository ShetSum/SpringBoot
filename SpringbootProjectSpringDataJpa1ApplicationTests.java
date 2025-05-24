package in.sb.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sb.main.entities.Student;
import in.sb.main.services.StudentServices;
import in.sb.main.services.StudentServicesImplementation;

@SpringBootApplication
public class SpringbootProjectSpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootProjectSpringDataJpa1Application.class, args);
		StudentServices stdService = context.getBean(StudentServicesImplementation.class);
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("\n------ Student Management System ------");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. View Student by ID");
			System.out.println("4. Update Student CGPA");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
				case 1:
					Student std = new Student();
					System.out.print("Enter Student Name: ");
					std.setName(scanner.nextLine());
					System.out.print("Enter Roll No: ");
					std.setRollno(scanner.nextInt());
					System.out.print("Enter CGPA: ");
					std.setCgpa(scanner.nextFloat());
					scanner.nextLine(); // consume newline
					System.out.print("Enter Department: ");
					std.setDepartment(scanner.nextLine());

					boolean added = stdService.addStudentDetails(std);
					System.out.println(added ? " Student inserted successfully!" : " Student not inserted.");
					break;

				case 2:
					List<Student> studentList = stdService.getAllStudentDetails();
					if (studentList.isEmpty()) {
						System.out.println("No students found.");
					} else {
						for (Student s : studentList) {
							System.out.println("---------------------------------------------------");
							System.out.println("ID        : " + s.getId());
							System.out.println("Name      : " + s.getName());
							System.out.println("Roll No   : " + s.getRollno());
							System.out.println("CGPA      : " + s.getCgpa());
							System.out.println("Department: " + s.getDepartment());
						}
					}
					break;

				case 3:
					System.out.print("Enter Student ID: ");
					long id = scanner.nextLong();
					Student s = stdService.getStudentDetails(id);
					if (s != null) {
						System.out.println("Name      : " + s.getName());
						System.out.println("Roll No   : " + s.getRollno());
						System.out.println("CGPA      : " + s.getCgpa());
						System.out.println("Department: " + s.getDepartment());
					} else {
						System.out.println(" Student not found with ID " + id);
					}
					break;

				case 4:
					System.out.print("Enter Student ID to update CGPA: ");
					long updateId = scanner.nextLong();
					System.out.print("Enter new CGPA: ");
					float newCgpa = scanner.nextFloat();
					boolean updated = stdService.updateStudentDetails(updateId, newCgpa);
					System.out.println(updated ? " Student updated successfully!" : " Update failed.");
					break;

				case 5:
					System.out.print("Enter Student ID to delete: ");
					long deleteId = scanner.nextLong();
					boolean deleted = stdService.deleteStudentDetails(deleteId);
					System.out.println(deleted ? " Student deleted successfully!" : " Deletion failed.");
					break;

				case 6:
					running = false;
					System.out.println("Exiting application...");
					break;

				default:
					System.out.println(" Invalid choice. Please try again.");
			}
		}

		scanner.close();
	}
}

