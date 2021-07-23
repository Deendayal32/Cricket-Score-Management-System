package com.cric.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cric.entity.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {
	
	@Query("from Team as t where t.user.id =:userId")
	public List<Team> findTeamByUser(@Param("userId")int userId);
	
	@Query("from Team as t where t.name =:tname")
	public Team findByName(@Param("tname")String name);

	

}
