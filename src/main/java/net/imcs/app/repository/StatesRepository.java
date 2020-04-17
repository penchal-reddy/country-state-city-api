package net.imcs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.imcs.app.entity.States;

public interface StatesRepository extends JpaRepository<States,Long>{

	List<States> findByCountryIdOrderByNameAsc(int countryId);
}
