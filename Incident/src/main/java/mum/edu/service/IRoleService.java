package mum.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mum.edu.model.Role;
@Service
public interface IRoleService {
	List<Role> findAll();
}
