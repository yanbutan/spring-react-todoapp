package com.yanbu.toDoApp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @GetMapping("")
    public String getAllTasks(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("userId");
        return "Walao Eh : " + userId;
    }
}
