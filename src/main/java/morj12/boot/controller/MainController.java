package morj12.boot.controller;

import morj12.boot.dao.EmployeeRepository;
import morj12.boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    /**
     * An object which allows us to connect to database
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Gets all employees from the database, sends them to the model
     * and shows the view with all employees.
     *
     * @param model
     * @return main view
     */
    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> emps = employeeRepository.findAll();
        model.addAttribute("allEmps", emps);
        return "all-employees.jsp";
    }

    /**
     * Creates a new employee field in the model and shows the view
     * with the form to put the employee information.
     *
     * @param model
     * @return view with a form to add new employee
     */
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info.jsp";
    }

    /**
     * Saves the created employee in the database and redirects to
     * main page.
     *
     * @param employee field before created and stored in the model
     * @return main view
     */
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }

    /**
     * Requests the id of the employee and add an employee with the
     * same id to the model and returns the view to edit employee's fields.
     * It works as an update.
     *
     * @param id
     * @param model
     * @return view with a form to add new employee
     */
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeRepository.getById(id);
        model.addAttribute("employee", employee);
        return "employee-info.jsp";
    }

    /**
     * Takes an id from the model and deletes the employee from the database.
     * Returns main view.
     *
     * @param id
     * @param model
     * @return main view
     */
    @RequestMapping("/deleteEmployee")
    //We delete an employee from our database and redirect to initial page
    public String deleteEmployee(@RequestParam("empId") int id, Model model) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }


}

