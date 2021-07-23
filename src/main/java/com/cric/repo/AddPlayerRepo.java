package com.cric.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cric.entity.AddPlayer;

public interface AddPlayerRepo extends JpaRepository<AddPlayer, Integer> {
	@Query("from AddPlayer as b where b.teamId =:teamid")
	ArrayList<AddPlayer> findAllByTeamId(@Param("teamid")int teamid);

	

}
