package com.yanbu.toDoApp.api;

import com.yanbu.toDoApp.model.Task;
import com.yanbu.toDoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {


    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String getAllTasks(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("userId");
        return "Walao Eh : " + userId;
    }

    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(HttpServletRequest request,
                                        @RequestBody Map<String, String> taskMap
                                        ){
        int userId = (Integer) request.getAttribute(("userId"));
        String name = (String) taskMap.get("name");
        String description = (String) taskMap.get("description");
        String taskType = (String) taskMap.get("taskType");
        String dateCreated = (String) taskMap.get("dateCreated");
        String dateToComplete = (String) taskMap.get("dateToComplete");
        String dateCompleted = (String) taskMap.get("dateCompleted");
        String status = (String) taskMap.get("status");
        Task task = taskService.addTask(userId, name, description, taskType, dateCreated, dateToComplete, dateCompleted, status);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
