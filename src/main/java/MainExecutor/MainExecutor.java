package MainExecutor;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 4/12/17.
 */
public class MainExecutor {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Address address = new Address();
		address.setCountry("DC");
		address.setCity("Gotham city");
		address.setStreet("Arkham street 1");
		address.setPostcode("350020");

		//Add Employee
		Employee employee = new Employee();
		employee.setFirstName("James");
		employee.setLastName("Gordon");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1939, Calendar.MAY, 1);
		employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
		employee.setAddress(address);

		//Add Project
		Project project = new Project();
		project.setTitle("data_for_project");

		Set<Project> projects = new HashSet<>();
		projects.add(project);

		employee.setProjects(projects);

		session.save(address);
		session.save(employee);
		session.save(project);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
