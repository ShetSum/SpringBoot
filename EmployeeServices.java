package in.sb.main.services;

import in.sb.main.entities.Employee;
import java.util.List;

import java.util.Optional;



public interface EmployeeServices
{
   public Employee createEmployee(Employee employee);
   public List<Employee>getAllEmployees();
   public Optional<Employee> getEmployeeDetails(int id);
   public Employee updateEmployeeDetails(int id,Employee employee);
   public void deleteEmployee(int id);
   
   
}