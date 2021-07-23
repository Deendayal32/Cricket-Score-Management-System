package com.cric.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cric.entity.Match;

public interface MatchRepo extends JpaRepository<Match, Integer>  {

}
