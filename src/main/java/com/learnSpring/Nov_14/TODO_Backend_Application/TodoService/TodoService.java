package com.learnSpring.Nov_14.TODO_Backend_Application.TodoService;

import com.learnSpring.Nov_14.TODO_Backend_Application.Model.Todo;
import com.learnSpring.Nov_14.TODO_Backend_Application.TodoRepository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public Todo createTask(Todo todo){
        return todoRepository.save(todo);
    }

    public  Todo getTaskById(Long id){
        return todoRepository.findById(id).orElseThrow(()-> new RuntimeException("No Task available for "+id));
    }

    public List<Todo> getAllTask(){
        return todoRepository.findAll();
    }

    public Page<Todo> getTaskByPage(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return  todoRepository.findAll(pageable);
    }
    public  Todo updateTaskById(Long id,Todo todo){
        return todoRepository.findById(id).map(existing ->{
            BeanUtils.copyProperties(todo,existing,"id");
            return  todoRepository.save(existing);

        }).orElseThrow(()-> new RuntimeException("No Task available for "+id));
    }



    public boolean deleteTaskByID(Long id){
         if(todoRepository.existsById(id)){
             todoRepository.deleteById(id);
             return  true;
         }else{
             return  false;
         }
    }

}
