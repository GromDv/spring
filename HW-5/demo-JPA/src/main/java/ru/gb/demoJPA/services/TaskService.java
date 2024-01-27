package ru.gb.demoJPA.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.demoJPA.model.Task;
import ru.gb.demoJPA.model.TaskStatus;
import ru.gb.demoJPA.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    /**
     * Получить список всех задач
     * @return
     */
    public List<Task> getTasks() {
        return repository.findAll();
    }

    /**
     * Добавить новую задачу
     * @param description
     */
    public void addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(TaskStatus.NOT_STARTED);
        task.setDateCreate(LocalDateTime.now());
        repository.save(task);
    }

    /**
     * Получить список задач со статусом status.
     * @param status
     * @return
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    /**
     * Обновить задачу по ID
     * @param id
     * @param task
     * @return
     */
    public String updateTask(Long id, Task task) {
        Task taskToUpdate = getTaskById(id).orElse(null);
        if (taskToUpdate != null) {
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setStatus(task.getStatus());
            repository.save(taskToUpdate);
            return "Saved!";
        } else {
            return "No such task! Not saved!";
        }
    }

    /**
     * Удалить задачу по ID
     * @param id
     * @return
     */
    public String deleteTask(Long id) {
        Task taskToDelete = getTaskById(id).orElse(null);
        if(taskToDelete != null) {
            repository.deleteById(id);
            return "Deleted!";
        } else {
            return "No such task! Nothing to delete.";
        }
    }

}
