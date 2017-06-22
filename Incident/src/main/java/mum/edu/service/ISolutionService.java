package mum.edu.service;

import org.springframework.stereotype.Service;

import mum.edu.model.Solution;

@Service
public interface ISolutionService {
	public Solution saveSolution(Solution solution);
	public Solution findByIncidentId(int id);
}
