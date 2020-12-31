package com.yanbu.toDoApp.api;

import com.yanbu.toDoApp.model.Task;
import com.yanbu.toDoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Repeatable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
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
    public ResponseEntity<List<Task>> getAllTasks(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("userId");
        List<Task> taskList = taskService.fetchAllTasks(userId);
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(HttpServletRequest request,
                            @PathVariable("taskId") Integer taskId
                            ){
        int userId = (Integer) request.getAttribute(("userId"));
        Task task = taskService.fetchTaskById(userId, taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addTask(HttpServletRequest request,
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
        Integer taskId = null;
        try {
            taskId = taskService.addTask(userId, name, description, taskType, dateCreated, dateToComplete, dateCompleted, status);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(taskId, HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Map<String, Boolean>> updateTask(HttpServletRequest request,
                                                           @PathVariable("taskId") Integer taskId,
                                                           @RequestBody Task task
                                                           ){
        int userId = (Integer) request.getAttribute(("userId"));
        taskService.updateTask(userId, taskId, task);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Update success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Map<String,Boolean>> deleteTask(HttpServletRequest request,
                                                          @PathVariable("taskId") Integer taskId
                                                          ){
        int userId = (Integer) request.getAttribute(("userId"));
        taskService.removeTask(userId, taskId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Delete success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
