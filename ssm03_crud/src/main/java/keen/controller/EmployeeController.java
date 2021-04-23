package keen.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import keen.bean.Employee;
import keen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 查询员工(分页查询
     *
     * @return
     */
    @RequestMapping("/emps")
    private String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn , Model model) {
        //调用分页方法,传入页码,和每页大小
        PageHelper.startPage(pn, 5);
        //紧跟着startPage的第一个select方法会被分页
        List<Employee> emps = employeeService.getAll();
        //使用pageInfo包装查询后的结果,只需要将pageInfo交给页面就行
        PageInfo page=new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);

        return "list1";
    }
}
