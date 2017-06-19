package mum.edu.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

@Service
@Transactional(value=TxType.REQUIRES_NEW)
public class DepartmentService implements IDepartmentService{
	
}
