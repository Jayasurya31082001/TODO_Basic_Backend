package com.learnSpring.Nov_14.TODO_Backend_Application.TodoController;

import com.learnSpring.Nov_14.TODO_Backend_Application.Model.Todo;
import com.learnSpring.Nov_14.TODO_Backend_Application.TodoService.TodoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/createTask")
    public ResponseEntity<Todo> createTask(@RequestBody Todo todo){
        return  new ResponseEntity<>(todoService.createTask(todo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Todo> getTaskById(@PathVariable  Long id){
        try {
            Todo getTodo = todoService.getTaskById(id);
            return new ResponseEntity<>(getTodo, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTask(){
        List<Todo> todoList= todoService.getAllTask();
        if(todoList.size()>0){
            return  new ResponseEntity<>(todoList,HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Todo> updateTaskById( @PathVariable Long id,@RequestBody Todo todo){
        try {
             todoService.updateTaskById(id,todo);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }
        catch (RuntimeException re){
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteTaskById(@PathVariable Long id){
             if(todoService.deleteTaskByID(id)){
                 return  ResponseEntity.ok("task "+id+" deleted successfully.");
             }else {
                 return ResponseEntity.notFound().build();
             }
    }



}
