package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import sample.dao.DAO;
import sample.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

/**
 * An implementation of the Service class for Employee class.
 * Its method have the annotation transactional, which means
 * that Spring manages transactions itself.
 * <p>
 * At the moment this method doesn't contain much business logic.
 * This is just an example.
 */

@org.springframework.stereotype.Service
public class EmployeeServiceImpl implements Service<Employee> {

    /**
     * Uses a DAO implementation
     */
    @Autowired
    private DAO<Employee> employeeDAO;

    /**
     * Gets all employees
     *
     * @return
     */
    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    /**
     * Saves or updates one employee
     *
     * @param employee
     */
    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    /**
     * Gets an employee by id
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Employee get(int id) {
        return employeeDAO.get(id);
    }

    /**
     * Deletes an employee by id
     *
     * @param id
     */
    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
