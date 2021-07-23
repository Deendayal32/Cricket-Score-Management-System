package com.cric.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cric.entity.MatchResult;

public interface MatchResultRepo extends JpaRepository<MatchResult, Integer> {

}
