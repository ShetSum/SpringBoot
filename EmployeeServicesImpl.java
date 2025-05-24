package in.sb.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sb.main.entities.Employee;
import in.sb.main.repositories.EmployeeRepository;
@Service
public class EmployeeServicesImpl implements EmployeeServices
{
	@Autowired
	private EmployeeRepository employeeRepsitory;
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		return employeeRepsitory.save(employee);
	}
@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepsitory.findAll();
	}
@Override
	public Optional<Employee> getEmployeeDetails(int id) {
		
		return employeeRepsitory.findById(id);
	}
@Override
	public Employee updateEmployeeDetails(int id, Employee newEmployee) {
		
		Employee employeeData=employeeRepsitory.findById(id).orElse(null);
		if(employeeData !=null)
		{
		  return employeeRepsitory.save(newEmployee);
		}
		return null;
	}
@Override
	public void deleteEmployee(int id)
	{
		employeeRepsitory.deleteById(id);
	
	}
}


