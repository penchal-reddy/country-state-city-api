package net.imcs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.imcs.app.entity.Immigration;

public interface ImmigrationRepository extends JpaRepository<Immigration,Long>{
	
	/*
	 * @Query("from immigration i left join employees e on i.emp_id=e.id left join visa_types v on v.visa_id=i.visa_id where i.emp_id=?1"
	 * ) List<Immigration> FindAllWithDescriptionQuery(int empId);
	 */
	
}
