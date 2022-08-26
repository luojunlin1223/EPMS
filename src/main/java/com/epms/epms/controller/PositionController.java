package com.epms.epms.controller;

import com.epms.epms.model.entity.Position;
import com.epms.epms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PositionController {
    @Autowired
    PositionService positionService;

    @RequestMapping("/position")
    public String index(Model model){
        var result=positionService.findAll();
        model.addAttribute("tableName","Position");
        model.addAttribute("tableData",result);
        model.addAttribute("page","position");
        return "index";
    }

    @RequestMapping("/position/new-position")
    public String newDepartment(Model model)
    {
        model.addAttribute("page","new-position");
        return "index";
    }

    @RequestMapping("/position/new-position/save")
    public String save(Model model, @RequestParam("position") String name, @RequestParam("level") int level)
    {
        var temp=new Position();
        temp.setName(name);
        temp.setLevel(level);
        positionService.save(temp);
        var result=positionService.findAll();
        model.addAttribute("tableName","Position");
        model.addAttribute("tableData",result);
        model.addAttribute("page","position");
        return "index";
    }
    @RequestMapping("/position/delete")
    public String delete(Model model,@RequestParam("id") Long id){
        positionService.deleteById(id);
        var result=positionService.findAll();
        model.addAttribute("tableName","Position");
        model.addAttribute("tableData",result);
        model.addAttribute("page","position");
        return "index";
    }
    @RequestMapping("/position/update")
    public String update(Model model,@RequestParam("id") Long id){
        Position position = null;
        var optional=positionService.findById(id);
        if (optional.isPresent()) {
            position = optional.get();
        }
        model.addAttribute("id",id);
        model.addAttribute("positionInfo",position);
        model.addAttribute("page","update-position");
        return "index";
    }
    @RequestMapping("/position/update/save")
    public String update(Model model,@RequestParam("id") Long id,
                         @RequestParam("name") String name,
                         @RequestParam("level") int level) {
        var position = positionService.findById(id);
        position.ifPresent(value -> {
            value.setName(name);
            value.setLevel(level);
        });

        position.ifPresent(value -> positionService.save(value));
        var result = positionService.findAll();
        model.addAttribute("tableName", "Position");
        model.addAttribute("tableData", result);
        model.addAttribute("page", "position");
        return "index";
//    }
    }

}
