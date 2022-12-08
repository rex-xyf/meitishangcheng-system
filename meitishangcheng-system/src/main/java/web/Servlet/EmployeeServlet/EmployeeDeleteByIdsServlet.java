package web.Servlet.EmployeeServlet;

import com.alibaba.fastjson.JSON;
import mapper.ScheduleMapper;
import pojo.Employee;
import service.DeleteService;
import service.EmployeeService;
import service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeeDeleteByIdsServlet")
public class EmployeeDeleteByIdsServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    DeleteService deleteService = new DeleteService();
    ScheduleService scheduleService = new ScheduleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        int[] ids = JSON.parseObject(s, int[].class);
        List<Employee> employees = employeeService.selectByIds(ids);
        for (Employee employee : employees){
            deleteService.add(employee);
            scheduleService.updateState(employee.getId(),2);
        }
        employeeService.deleteByIds(ids);
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
