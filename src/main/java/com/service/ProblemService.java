package com.service;


import com.domain.Problem;
import com.dto.problem.ProblemDto;
import com.dto.problem.ProblemUpdateAllDto;
import com.exception.NotFoundException;
import com.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.service.TotalUpdateService.convertProblemToProblemDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ProblemService {

    private final ProblemRepository problemRepository;

    public List<ProblemDto> findAll() {
        List<Problem> all = problemRepository.findAll();
        List<ProblemDto> problemDtoList = convertProblemToProblemDto(all);
        return problemDtoList;
    }

    @Transactional
    public Long addProblem(ProblemDto infoDto){
        Problem problem = Problem.builder()
                .problemName(infoDto.getProblemName())
                .problemContent(infoDto.getProblemContent())
                .problemTag(infoDto.getProblemTag())
                .diffculty(infoDto.getDiffculty())
                .flag(infoDto.getFlag())
                .build();

        problemRepository.save(problem);
        return problem.getId();
    }


}

