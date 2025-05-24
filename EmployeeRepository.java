package in.sb.main.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import in.sb.main.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
