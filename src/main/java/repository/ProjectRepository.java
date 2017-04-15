package repository;

import entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by k0r0tk0ff on 4/15/2017.
 */

/**
 * JpaRepository <Project, Long>
 *     Long - type of PrimaryKey (Id)
 */
public interface ProjectRepository extends JpaRepository <Project, Long> {
}
