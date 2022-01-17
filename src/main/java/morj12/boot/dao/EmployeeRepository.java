package morj12.boot.dao;

import morj12.boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * Interface which contains all SQL CRUD methods
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
