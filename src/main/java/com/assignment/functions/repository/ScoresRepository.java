package com.assignment.functions.repository;

import com.assignment.functions.model.Scores;
import org.springframework.data.repository.CrudRepository;

public interface ScoresRepository extends CrudRepository<Scores,Integer> {
}
