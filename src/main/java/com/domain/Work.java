package com.domain;

import com.domain.type.GenreType;
import com.domain.type.ProblemTypeTag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Long id;

    @Column(name = "writer")
    private String writer;

    @Column(name = "publicationYear")
    private Integer publicationYear; // 출판 연도

    @Column(name = "genre")
    private GenreType genre; // 장르

    @Column(name = "workContent")
    private String workContent; // 작품 설명

}
