package com.karolina.football.repository;

import com.karolina.football.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m GROUP BY m.id ORDER BY SUM(m.goalsAway+m.goalsHome) DESC")
    List<Match> getMatchesSortedByMostGoalsTotal();

}
