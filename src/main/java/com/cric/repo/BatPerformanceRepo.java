package com.cric.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.cric.entity.BatPerformance;

public interface BatPerformanceRepo extends JpaRepository<BatPerformance, Integer> {
	@Query("from BatPerformance as b where b.matchId =:userId")
	List<BatPerformance> findByMatchId(@Param("userId")int i);

}