package com.main.admin.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.Role;

@Repository
public interface RoleDAO extends CrudRepository<Role,Integer>{
	@Query("select r from Role r where r.roleName = ?1")
	public Role findByRoleName(String roleName);
	
	@Query("select r from Role r where r.roleName = 'ROLE_ADMIN' and r.roleName = 'ROLE_MEMBER'")
	public List<Role> findByAdminAndMember();
}
