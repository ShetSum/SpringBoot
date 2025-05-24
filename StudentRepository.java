package in.sb.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sb.main.entities.Student;

public interface StudentRepository extends JpaRepository <Student,Long>   {

	
}
