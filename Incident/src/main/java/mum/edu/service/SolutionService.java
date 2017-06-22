package mum.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.dataaccess.ISolutionDAO;
import mum.edu.model.Solution;

@Service
public class SolutionService implements ISolutionService {
	
	@Autowired
	ISolutionDAO solutionDAO;
	
	@Override
	public Solution saveSolution(Solution solution) {
		return solutionDAO.save(solution);
	}
}
