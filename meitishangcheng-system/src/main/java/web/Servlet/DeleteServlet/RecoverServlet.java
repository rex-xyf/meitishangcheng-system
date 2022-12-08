package web.Servlet.DeleteServlet;

import pojo.Delete;
import pojo.Employee;
import service.DeleteService;
import service.EmployeeService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recoverServlet")
public class RecoverServlet extends HttpServlet {
    DeleteService deleteService = new DeleteService();
    EmployeeService employeeService = new EmployeeService();
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getReader().readLine());
        Delete delete = deleteService.selectById(id);
        Employee employee = new Employee(delete.getId(),delete.getName(),delete.getAddress(),delete.getHourWages(),delete.getDepartment(),delete.getWorkShifts());
        employeeService.addId(employee);
        deleteService.delete(id);
        scheduleService.updateState(id,1);
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
