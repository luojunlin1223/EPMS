package com.epms.epms.controller;

import com.epms.epms.model.entity.Department;
import com.epms.epms.service.DepartmenServiceImpl;
import com.epms.epms.service.UserSeriviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmenServiceImpl departmenService;
    @Autowired
    private UserSeriviceImpl userSerivice;

    @RequestMapping("/department")
    public String index(Model model){
        var result=departmenService.findAll();
        model.addAttribute("tableName","Department");
        model.addAttribute("tableData",result);
        model.addAttribute("page","department");
        return "index";
    }

    @RequestMapping("/department/new-department")
    public String newDepartment(Model model)
    {
        model.addAttribute("page","new-department");
        return "index";
    }

    @RequestMapping("/department/new-department/save")
    public String save(Model model,@RequestParam("department") String name,@RequestParam("tel") String tel,@RequestParam("email") String email,
                       @RequestParam("address") String address)
    {
        var temp=new Department();
        temp.setName(name);
        temp.setTel(tel);
        temp.setEmail(email);
        temp.setAddress(address);
        departmenService.save(temp);
        var result=departmenService.findAll();
        model.addAttribute("tableName","Department");
        model.addAttribute("tableData",result);
        model.addAttribute("page","department");
        return "index";
    }
    @RequestMapping("/department/delete")
    public String delete(Model model,@RequestParam("id") Long id){
        departmenService.deleteById(id);
        var result=departmenService.findAll();
        model.addAttribute("tableName","Department");
        model.addAttribute("tableData",result);
        model.addAttribute("page","department");
        return "index";
    }
    @RequestMapping("/department/update")
    public String update(Model model,@RequestParam("id") Long id){
        Department department = null;
        var optional=departmenService.findById(id);
        if (optional.isPresent()) {
            department = optional.get();
        }
        var userData=userSerivice.findAll();
        model.addAttribute("id",id);
        assert department != null;
        model.addAttribute("userDataName",department.getLeader().getUsername());
        model.addAttribute("userData",userData);
        model.addAttribute("departmentInfo",department);
        model.addAttribute("page","update-department");
        return "index";
    }
    @RequestMapping("/department/update/save")
    public String update(Model model,@RequestParam("id") Long id,
                         @RequestParam("name") String name,
                         @RequestParam("tel") String tel,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address){
        var department=departmenService.findById(id);
        department.ifPresent(value -> {
            value.setName(name);
            value.setTel(tel);
            value.setEmail(email);
            value.setAddress(address);
        });

        department.ifPresent(value -> departmenService.save(value));
        var result=departmenService.findAll();
        model.addAttribute("tableName","Department");
        model.addAttribute("tableData",result);
        model.addAttribute("page","department");
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "form-examples";
    }
}
