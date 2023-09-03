package com.repository;

import com.domain.Problem;
import com.domain.type.ProblemTypeTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long>  {
    Optional<Problem> findByType(ProblemTypeTag typeTag);
}
