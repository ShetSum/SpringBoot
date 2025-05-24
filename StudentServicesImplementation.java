package in.sb.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.sb.main.SpringbootProjectSpringDataJpa1Application;
import in.sb.main.entities.Student;
import in.sb.main.repository.StudentRepository;

@Service
public class StudentServicesImplementation implements StudentServices {

    private final SpringbootProjectSpringDataJpa1Application springbootProjectSpringDataJpa1Application;
	
	@Autowired
	private StudentRepository studentRepository;

    StudentServicesImplementation(SpringbootProjectSpringDataJpa1Application springbootProjectSpringDataJpa1Application) {
        this.springbootProjectSpringDataJpa1Application = springbootProjectSpringDataJpa1Application;
    }
	@Override
	public boolean addStudentDetails(Student std) {
		boolean status=false;
		try {
		studentRepository.save(std);
		status=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			status=false;
			}
		return status;
		}
	@Override
	public List<Student> getAllStudentDetails() {
		
		return studentRepository.findAll();
	}
	@Override
	public Student getStudentDetails(long id) {
	
		Optional<Student>optional= studentRepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	@Override
	public boolean updateStudentDetails(long id,float cgpa) {
	   Student std=getStudentDetails(id);
	   if(std!=null)
	   {
		 std.setCgpa(cgpa);  
		 studentRepository.save(std);
		 return true;
	   }
		return false;
	}
	@Override
	public boolean deleteStudentDetails(long id) {
		boolean status=false;
		try
		{
			studentRepository.deleteById(id);
			status=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}
}
