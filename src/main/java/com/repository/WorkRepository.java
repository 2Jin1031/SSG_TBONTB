package com.repository;

import com.domain.Work;
import com.dto.work.WorkDto;
import com.dto.work.WorkUpdateAllDto;
import com.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.service.TotalUpdateService.convertWorkToWorkDto;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long>  {

}
