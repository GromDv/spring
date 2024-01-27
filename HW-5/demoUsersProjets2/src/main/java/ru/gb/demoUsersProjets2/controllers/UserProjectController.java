package ru.gb.demoUsersProjets2.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.demoUsersProjets2.model.User;
import ru.gb.demoUsersProjets2.model.Project;
import ru.gb.demoUsersProjets2.services.UserProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserProjectController {
    private final UserProjectService service;

    /**
     * Получить список пользователей проекта
     * @param id проекта
     * @return
     */
    @GetMapping("/project/{project_id}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable("project_id") Long id){
        return ResponseEntity.ok().body(service.getUsersByProjectId(id));
    }

    /**
     * Получить список проектов пользователя
     * @param id пользователя
     * @return
     */
    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Project>> getProjectsByUserId(
            @PathVariable("user_id") Long id){
        return ResponseEntity.ok().body(service.getProjectsByUserId(id));
    }

    /**
     * Добавить пользователя в проект
     * @param userId
     * @param projectId
     * @return
     */
    @PutMapping("/add/{user_id}/{project_id}")
    public ResponseEntity<String> addUserToProject(
            @PathVariable("user_id") Long userId,
            @PathVariable("project_id") Long projectId){
        String msg = service.addUserToProject(userId, projectId);
        return ResponseEntity.ok().body(msg);
    }

    /**
     * Удалить пользователя из проекта
     * @param userId
     * @param projectId
     * @return
     */
    @DeleteMapping("/remove/{user_id}/{project_id}")
    public ResponseEntity<String> removeUserFromProject(
            @PathVariable("user_id") Long userId,
            @PathVariable("project_id") Long projectId) {
        String msg = service.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().body(msg);
    }
}
