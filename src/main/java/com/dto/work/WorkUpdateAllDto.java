package com.dto.work;

import com.domain.Work;
import com.domain.type.GenreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
public class WorkUpdateAllDto {
    private String writer;

    private Integer publicationYear; // 출판 연도

    private GenreType genre; // 장르

    private String workContent; // 작품 설명


    public WorkUpdateAllDto(Work work) {
        this.writer = work.getWriter();
        this.publicationYear = work.getPublicationYear();
        this.genre = work.getGenre();
        this.workContent = work.getWorkContent();
    }

}
