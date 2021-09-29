package com.securemetric.infomanager.repository;

import com.securemetric.infomanager.entity.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository {

    @Query("SELECT r FROM Roles r WHERE r.roles = ?1")
    Roles findByRoles(String roles);
}
