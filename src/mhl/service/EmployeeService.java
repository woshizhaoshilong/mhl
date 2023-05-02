package mhl.service;

import mhl.dao.EmployeeDAO;
import mhl.domain.Employee;

/**
 * 业务层
 * 完成对employee的各种操作通过调用
 * */

public class EmployeeService {
    //定义一个
    private EmployeeDAO employeeDAO =new EmployeeDAO();
    //通过emp和pwd返回一个employee对象
    public Employee getEmployeeByIdAndPwd(String empid,String pwd){
        Employee employee = employeeDAO.querySingle("select * from employee where empid=? and pwd=md5(?)", Employee.class, empid, pwd);
        return employee;

    }

}
