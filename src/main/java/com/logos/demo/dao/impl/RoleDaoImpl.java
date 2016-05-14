package com.logos.demo.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logos.demo.dao.RoleDao;
import com.logos.demo.model.Role;



@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public Role findByRole(String role) {
		try {
			return (Role) entityManager.createNamedQuery(Role.FIND_BY_ROLE).setParameter("role", role).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	
}
