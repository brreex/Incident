package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Incident;
import mum.edu.model.Solution;

@Repository
public interface ISolutionDAO extends JpaRepository<Solution, Integer>{
	public Solution findByincident(Incident incident);
}
