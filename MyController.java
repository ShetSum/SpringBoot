package in.sb.main.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sb.main.entities.Employee;
import in.sb.main.services.EmployeeServices;
@RestController
public class MyController {
	@Autowired
	private EmployeeServices employeeService;
	
	@PostMapping("/employee")
	public Employee addEmployeeDetails(@RequestBody Employee employee)
	{
		
		return employeeService.createEmployee(employee);
		
	}
	@GetMapping("/employee")
	public List<Employee> getAllEmployeeDeatails()
	{
		
		return employeeService.getAllEmployees();
		
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable int id)
	{
		Employee employee=employeeService.getEmployeeDetails(id).orElse(null);
		if(employee!=null)
		{
			return ResponseEntity.ok().body(employee);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
@PutMapping("/employee/{id}")
public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable int id,@RequestBody Employee employee)
	{
		Employee updatedEmployee=employeeService.updateEmployeeDetails(id,employee);
		if(updatedEmployee!=null)
		{
			return ResponseEntity.ok(updatedEmployee);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/employee/{id}")
	
	public ResponseEntity<String>deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("user deleted succesfully");
	}
	}

