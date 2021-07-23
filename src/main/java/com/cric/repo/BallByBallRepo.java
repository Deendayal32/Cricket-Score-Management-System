package com.cric.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cric.entity.BallByBall;


public interface BallByBallRepo extends JpaRepository<BallByBall, Integer> {

	@Query("from BallByBall as b where b.matchId =:userId")
	List<BallByBall> findByMatchId(@Param("userId")int i);

}
