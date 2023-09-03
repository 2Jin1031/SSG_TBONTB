package com.dto.problem;

import com.domain.Post;
import com.domain.Problem;
import com.domain.type.ProblemTypeTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
public class ProblemUpdateAllDto {
    private String problemName; // 문제 이름

    private String problemContent; // 문제 설명

    private ProblemTypeTag problemTag; // 문제 태그

    private String diffculty; // 난이도

    private String flag; // 정답

    public ProblemUpdateAllDto(Problem problem) {
        this.problemName = problem.getProblemName();
        this.problemContent = problem.getProblemContent();
        this.problemTag = problem.getProblemTag();
        this.diffculty = problem.getDiffculty();
        this.flag = problem.getFlag();
    }

}
