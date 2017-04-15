package exe;


import entity.Address;
import entity.Employee;
import entity.Project;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AddressRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by k0r0tk0ff on 4/12/17.
 */
public class MainExecutor {

	public static void main(String[] args) throws SQLException {

		/**
		 *  Connect to our application context XML file
		 *  (for repositories)
		 */
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");

		AddressRepository addressRepository = context.getBean(AddressRepository.class);
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		ProjectRepository projectRepository = context.getBean(ProjectRepository.class);

		/********************   ADD DATA  **************************/
		//Add Address
		Address address = new Address();
		address.setId(1L);
		address.setCountry("DC");
		address.setCity("Gotham city");
		address.setStreet("Arkham street 1");
		address.setPostcode("350020");

		//Add Project
		Project project = new Project();
		project.setId(1L);
		project.setTitle("data_for_project");

		//Add Employee
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("James");
		employee.setLastName("Gordon");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1939, Calendar.MAY, 1);
		employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
		employee.setAddress(address);

		/**********************   Write code for "@many to one"************************/
		Set<Employee> employees = new HashSet<>();
		employees.add(employee);
		project.setEmployees(employees);

		Set<Project> projects = new HashSet<>();
		projects.add(project);
		employee.setProjects(projects);

		/********************** Save data to DB ****************************************/

		addressRepository.save(address);
		employeeRepository.save(employee);
		projectRepository.save(projects);

		/********************** Write queries to DB ***********************************/

		System.out.println("*********************************************** \n");

		/*********** Get all Employee ******/
		List<Employee> employeeList = employeeRepository.findAll();
		for (Employee findEmployee : employeeList ) {
			System.out.println(findEmployee);
		}

		System.out.println("*********************************************** \n");

		/**** Get Employee "James","Gordon" from custom method ******/
		System.out.println(employeeRepository.findByFirstnameAndLastname("James","Gordon"));

		System.out.println("*********************************************** \n");

		/**
		 *  Get count of column in table Employee
		 *  (embedded method)
		 */
		System.out.print("\n Count of rows in table Employees is: ");
		System.out.print(employeeRepository.count());

		System.out.print("\n\n");
	}
}
