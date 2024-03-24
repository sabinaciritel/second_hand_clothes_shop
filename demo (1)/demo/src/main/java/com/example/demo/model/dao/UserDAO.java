package com.example.demo.model.dao;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * UserDAO is an interface for generic CRUD operations on a repository for a {@link User} type.
 * It extends {@link CrudRepository}, providing additional methods specifically for {@link User} entities.
 * Through this interface, Spring Data can automatically provide the implementation required to work
 * directly with the data source defined in the application configuration.
 */
public interface UserDAO extends CrudRepository<User, Long> {

    /**
     * Finds a {@link User} entity by its username. This method exemplifies how custom query methods
     * can be defined within Spring Data repositories. The implementation is automatically provided by Spring Data JPA
     * based on method naming conventions.
     *
     * @param username The username of the {@link User} to be found.
     * @return The {@link User} entity with the given username, or {@code null} if no such user exists.
     */
    User findByUsername(String username);

}