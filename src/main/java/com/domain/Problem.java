package com.domain;

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
@Table(name = "problem")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    @Column(name = "problemName")
    private String problemName; // 문제 이름

    @Column(name = "problemContent")
    private String problemContent; // 문제 설명

    @Enumerated(EnumType.STRING)
    @Column(name = "problemTag")
    private ProblemTypeTag problemTag; // 문제 태그

    @Column(name = "diffculty")
    private String diffculty; // 난이도

    @Column(name = "flag")
    private String flag; // 정답

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;
}
