//package ru.gb.phonebook.config;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ru.gb.phonebook.repository.JdbcAbonentRepository;
//import ru.gb.phonebook.repository.JpaAbonentRepository;
//import ru.gb.phonebook.repository.ListAbonentRepository;
//import ru.gb.phonebook.repository.UniversalRepository;
//
//@Configuration
//@Data
//@AllArgsConstructor
//@ConfigurationProperties(prefix = "repo")
//public class RepoConfig {
//    /**
//     * Тип репозитория
//     */
//    private static String type_repo;
//
//    private final JpaAbonentRepository repoJpa;
//    @Autowired
//    private static final JdbcAbonentRepository repoJdbc;
//    private static final ListAbonentRepository repoList;
//
//    @Bean
//    public static UniversalRepository getRepositoryInstance() {
//        if(type_repo.equals("jdbc"))
//            return repoJdbc;
//        else
//            return repoList;
//    }
//}
