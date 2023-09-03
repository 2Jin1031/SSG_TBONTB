package com.dto.work;

import com.domain.Work;
import com.domain.type.GenreType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkDto {
    private Long id;

    private String writer;

    private Integer publicationYear; // 출판 연도

    private GenreType genre; // 장르

    private String workContent; // 작품 설명

    public WorkDto(Work work) {
        this.id = work.getId();
        this.writer = work.getWriter();
        this.publicationYear = work.getPublicationYear();
        this.genre = work.getGenre();
        this.workContent = work.getWorkContent();
    }

    public WorkDto() {
    }
}
