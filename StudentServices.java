package in.sb.main.services;

import java.util.List;

import in.sb.main.entities.Student;

public interface StudentServices {
	public boolean addStudentDetails(Student std);
	public List<Student>getAllStudentDetails();
	public Student getStudentDetails(long id);
	public boolean updateStudentDetails(long id,float cgpa);
	public boolean deleteStudentDetails(long id);
	
	

	

}
