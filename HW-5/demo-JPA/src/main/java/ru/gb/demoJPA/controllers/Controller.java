package ru.gb.demoJPA.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.demoJPA.model.Task;
import ru.gb.demoJPA.model.TaskStatus;
import ru.gb.demoJPA.services.TaskResult;
import ru.gb.demoJPA.services.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private  final TaskService service;

    /**
     * Получение списка задач
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<?> getAllTasks(){
        List<Task> tasks = service.getTasks();
        if(!tasks.isEmpty())
            return ResponseEntity.ok().body(tasks);
        else
            return new ResponseEntity<>(new TaskResult(HttpStatus.NO_CONTENT.value(),
                    "Tasks list is empty!"),
                    HttpStatus.NOT_FOUND);
    }

    /**
     * Получение задачи по ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") Long id) {
        try {
            Task task = service.getTaskById(id).orElseThrow();
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new TaskResult(HttpStatus.NOT_FOUND.value(),
                    "Task with id " + id + " not found!"),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Добавление новой задачи: /add, в теле POST-запроса строка с названием задачи.
     * @param descriptionTask
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody String descriptionTask) {
        service.addTask(descriptionTask);
        return new ResponseEntity<>(new TaskResult(HttpStatus.OK.value(),
                "New task added!"),
                HttpStatus.OK);
    }

    /**
     * Получение списка задач по статусу
     * @param status
     * @return
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getTasksByStatus(@PathVariable("status") TaskStatus status){
        List<Task> tasks = service.getTasksByStatus(status);
        if(!tasks.isEmpty())
            return ResponseEntity.ok().body(tasks);
        else
            return new ResponseEntity<>(new TaskResult(HttpStatus.NO_CONTENT.value(),
                    "Tasks list is empty!"),
                    HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение задачи
     * @param id
     * @param task
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        String result = service.updateTask(id, task);
        if(result.equals("Saved!"))
            return new ResponseEntity<>(new TaskResult(HttpStatus.OK.value(),
                    "Task " + id + " saved!"),
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(new TaskResult(HttpStatus.NOT_FOUND.value(),
                    "Task " + id + " not found!"),
                    HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление задачи по ID
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        String result = service.deleteTask(id);
        if(result.equals("Deleted!"))
            return new ResponseEntity<>(new TaskResult(HttpStatus.OK.value(),
                    "Task " + id + " deleted!"),
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(new TaskResult(HttpStatus.NOT_FOUND.value(),
                    "Task " + id + " not found!"),
                    HttpStatus.NOT_FOUND);
    }
}
