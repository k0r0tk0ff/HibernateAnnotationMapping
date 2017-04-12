package entity;

import javax.persistence.*;

import java.util.Set;

/**
 * Class Project for table PROJECTS
 * @since  4/8/2017.
 */

@Entity
@Table(name="PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE", length = 20)
    private String title;

    /**
     * Need for bind with class "Employee"
     * will be
     * unique object Project <= bind => unique object Employee
     * Generate relation many-to-many
     * EMPL_PROJ - help table name
     */
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project() {}

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for property 'title'.
     *
     * @return Value for property 'title'.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for property 'title'.
     *
     * @param title Value to set for property 'title'.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }


}
