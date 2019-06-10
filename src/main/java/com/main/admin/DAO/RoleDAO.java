package com.main.admin.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.Role;

@Repository
public interface RoleDAO extends CrudRepository<Role,Integer>{

}
