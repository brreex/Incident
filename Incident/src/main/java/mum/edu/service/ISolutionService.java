package mum.edu.service;

import org.springframework.stereotype.Service;

import mum.edu.model.Incident;
import mum.edu.model.Solution;

@Service
public interface ISolutionService {
	public Solution saveSolution(Solution solution);
	public Solution findByIncident(Incident incident);
}
