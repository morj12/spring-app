package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sample.entity.Employee;
import sample.service.Service;

import java.util.List;

/**
 * A simple controller class. It has five methods to control the
 * application. Each method returns a view for the requested mapping.
 * Has one autowired field, which is used to work with data.
 */


@Controller
public class MyController {

    /**
     * An object which allows us to connect to database
     */
    @Autowired
    private Service<Employee> employeeService;

    /**
     * Gets all employees from the database, sends them to the model
     * and shows the view with all employees.
     *
     * @param model
     * @return main view
     */
    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> emps = employeeService.getAll();
        model.addAttribute("allEmps", emps);
        return "all-employees";
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
        return "employee-info";
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
        employeeService.save(employee);
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
        Employee employee = employeeService.get(id);
        model.addAttribute("employee", employee);
        return "employee-info";
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
        employeeService.delete(id);
        return "redirect:/";
    }


}
