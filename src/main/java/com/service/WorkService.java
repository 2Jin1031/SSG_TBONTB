package com.service;

import com.domain.Work;
import com.dto.work.WorkDto;
import com.dto.work.WorkUpdateAllDto;
import com.exception.NotFoundException;
import com.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.service.TotalUpdateService.convertWorkToWorkDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class WorkService {

    private final WorkRepository workRepository;

    public List<WorkDto> findAll() {
        List<Work> all = workRepository.findAll();
        List<WorkDto> workDtoList = convertWorkToWorkDto(all);
        return workDtoList;
    }

    @Transactional
    public Long addWork(WorkDto infoDto){
        Work work = Work.builder()
                .writer(infoDto.getWriter())
                .publicationYear(infoDto.getPublicationYear())
                .genre(infoDto.getGenre())
                .workContent(infoDto.getWorkContent())
                .build();

        workRepository.save(work);
        return work.getId();
    }

}
