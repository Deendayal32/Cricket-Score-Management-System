package com.cric.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cric.entity.BowlingPerformance;

public interface BowlingPerformanceRepo extends JpaRepository<BowlingPerformance, Integer>{

	@Query("from BowlingPerformance as b where b.mId =:userId")
	List<BowlingPerformance> findBymId(@Param("userId")int getmId);

	

	
	
	
	

}
