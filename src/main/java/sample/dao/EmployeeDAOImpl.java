package sample.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sample.entity.Employee;

import java.util.List;

/**
 * Data Access Object implementation for Employee class.
 */

@Repository
public class EmployeeDAOImpl implements DAO<Employee> {

    /**
     * Autowired object which creates a session between Java and Hibernate.
     */
    @Autowired
    private SessionFactory sf;

    /**
     * Gets current session on which executes a Select instruction.
     *
     * @return a list with all employees
     */
    @Override
    public List<Employee> getAll() {
        Session session = sf.getCurrentSession();
        List<Employee> allEmps = session.createQuery("from Employee ").getResultList();
        return allEmps;
    }

    /**
     * Gets current session on which saves/updates an employee.
     * The instruction @saveOrUpdate() allows to update an employee
     * if it exists. If it doesn't exist, it creates a new one.
     *
     * @param employee
     */
    @Override
    public void save(Employee employee) {
        Session session = sf.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    /**
     * Gets current session on which gets an employee using his id.
     *
     * @param id
     * @return employee object
     */
    @Override
    public Employee get(int id) {
        Session session = sf.getCurrentSession();
        Employee emp = session.get(Employee.class, id);
        return emp;
    }

    /**
     * Get current session on which executes a Delete instruction.
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        Session session = sf.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id = :empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
