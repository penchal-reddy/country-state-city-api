package net.imcs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.imcs.app.entity.Countries;

public interface CuntriesRepository extends JpaRepository<Countries,Long>{

	List<Countries> findByOrderByNameAsc();
}
