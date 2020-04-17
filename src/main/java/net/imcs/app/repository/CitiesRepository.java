package net.imcs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.imcs.app.entity.Cities;

public interface CitiesRepository extends JpaRepository<Cities,Long>{

	List<Cities> findByStateIdOrderByNameAsc(Integer stateId);
}

