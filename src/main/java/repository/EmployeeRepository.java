package repository;

import entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by k0r0tk0ff on 4/15/2017.
 */
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    /**
     *
     * @param firstname - ?1
     * @param lastname - ?2
     * nativeQuery - we will be use native SQL
     * @return result of select from value
     */
    @Query(value = "SELECT * FROM EMPLOYEE WHERE FIRST_NAME=?1 AND LAST_NAME=?2", nativeQuery = true)
    Employee findByFirstnameAndLastname(String firstname, String lastname);

    /**
     * For Spring`s autogenerate methods
     *
     */
    Employee findByLastName(String lastname);
}
