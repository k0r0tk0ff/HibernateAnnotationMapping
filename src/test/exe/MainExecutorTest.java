package exe;

import entity.Address;
import entity.Employee;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AddressRepository;
import repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.Calendar;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;


/**
 * Created by k0r0tk0ff on 4/15/2017.
 */
public class MainExecutorTest {

    @Test
    public void ConnectToDbAddOneRowAndCheckIt () throws SQLException {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        AddressRepository addressTestRepository = context.getBean(AddressRepository.class);

        //Add Address
        Address addressTest = new Address();
        addressTest.setId(1L);
        addressTest.setCountry("DC");
        addressTest.setCity("Gotham city");
        addressTest.setStreet("Arkham street 1");
        addressTest.setPostcode("350020");

        addressTestRepository.save(addressTest);

        assertThat(1L, is(addressTestRepository.count()));
    }

    @Test
    public void ConnectToDbAddOneRowFromEmployeeRepoAndCheckIt () throws SQLException {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        Employee testEmployee = new Employee();
        testEmployee.setId(1L);
        testEmployee.setFirstName("James");
        testEmployee.setLastName("Gordon");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);
        testEmployee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));

        employeeRepository.save(testEmployee);

        assertThat(1L, is(employeeRepository.count()));
    }
}