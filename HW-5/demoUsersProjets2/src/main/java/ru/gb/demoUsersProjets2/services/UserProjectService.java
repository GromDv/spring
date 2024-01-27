package ru.gb.demoUsersProjets2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.demoUsersProjets2.model.User;
import ru.gb.demoUsersProjets2.model.Project;
import ru.gb.demoUsersProjets2.repositories.ProjectRepository;
import ru.gb.demoUsersProjets2.repositories.UserRepository;
import ru.gb.demoUsersProjets2.repositories.UsersProjectRepository;
import ru.gb.demoUsersProjets2.model.UsersProject;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {
    /**
     * Подключение репозиториев
     */
    private final UsersProjectRepository userProjectRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    /**
     * Получение списка пользователей проекта
     *
     * @param projectId
     * @return
     */
    public List<User> getUsersByProjectId(Long projectId) {
        List<Long> userIds = userProjectRepository
                .findAllByProjectId(projectId)
                .stream()
                .map(UsersProject::getUserId)
                .toList();
        return userRepository.findAllById(userIds);
    }

    /**
     * Получение проектов пользователя
     *
     * @param userId идентификатор пользователя.
     * @return список проектов.
     */
    public List<Project> getProjectsByUserId(Long userId) {
        List<Long> projectsId = userProjectRepository.findAllByUserId(userId)
                .stream()
                .map(UsersProject::getProjectId)
                .toList();
        return projectRepository.findAllById(projectsId);
    }

    /**
     * Добавление пользователя в проект
     *
     * @param userId    идентификатор пользователя.
     * @param projectId идентификатор проекта.
     */
    public String addUserToProject(Long userId, Long projectId) {
        UsersProject targetProject = getUserProjectByUserIdAndProjectId(userId, projectId);
        if (targetProject != null) {
            return "Already in project!";
        } else {
            UsersProject usersProject = new UsersProject();
            usersProject.setUserId(userId);
            usersProject.setProjectId(projectId);
            userProjectRepository.save(usersProject);
            return "User added!";
        }
    }

    /**
     * Удаление пользователя из проекта.
     *
     * @param userId
     * @param projectId
     */
    public String removeUserFromProject(Long userId, Long projectId) {
        UsersProject targetProject = getUserProjectByUserIdAndProjectId(userId, projectId);
        if (targetProject != null) {
            userProjectRepository.deleteById(targetProject.getId());
            return "Deleted!";
        } else {
            return "Project not found!";
        }
    }

    /**
     * Проверка участия пользователя в проекте
     *
     * @param userId
     * @param projectId
     * @return объект UserProject или null
     */
    public UsersProject getUserProjectByUserIdAndProjectId(Long userId, Long projectId) {
        List<UsersProject> lst = userProjectRepository.findAllByUserIdAndProjectId(userId, projectId);
        return lst.stream().findFirst().orElse(null);
    }
}
