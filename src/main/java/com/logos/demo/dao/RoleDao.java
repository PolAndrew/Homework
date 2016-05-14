package com.logos.demo.dao;

import com.logos.demo.model.Role;

public interface RoleDao extends BaseDao<Role, Long> {
 
	Role findByRole(String role);
}
