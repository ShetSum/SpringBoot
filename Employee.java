package in.sb.main.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private int id;
	@Column
    private String name;
	@Column
    private String department;
	@Column
    private double salary;
	@Column
    private int experience;

    public Employee() {}

    public Employee(int id, String name, String department, double salary, int experience) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
    }

    public int getId()
    {
    	return id; 
    }
    public void setId(int id)
    { 
    	this.id = id; 
    }

    public String getName() 
    { 
    	return name; 
    }
    public void setName(String name) 
    { 
    	this.name = name;
    }

    public String getDepartment() 
    { 
    	return department; 
    }
    public void setDepartment(String department) 
    { 
    	this.department = department;
    	
    }

    public double getSalary() 
    {
    	return salary; 
    }
    public void setSalary(double salary) 
    { 
    	this.salary = salary; 
    }

    public int getExperience() 
    { 
    	return experience;
    }
    public void setExperience(int experience)
    {
    	this.experience = experience; 
    }
}
