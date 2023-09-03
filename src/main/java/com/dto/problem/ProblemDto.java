package com.dto.problem;

import com.domain.Problem;
import com.domain.type.ProblemTypeTag;
import lombok.Data;

@Data
public class ProblemDto {
    private Long id;

    private String problemName; // 문제 이름

    private String problemContent; // 문제 설명

    private ProblemTypeTag problemTag; // 문제 태그

    private String diffculty; // 난이도

    private String flag; // 정답

    public ProblemDto(Problem problem) {
        this.id = problem.getId();
        this.problemName = problem.getProblemName();
        this.problemContent = problem.getProblemContent();
        this.problemTag = problem.getProblemTag();
        this.diffculty = problem.getDiffculty();
        this.flag = problem.getFlag();
    }

    public ProblemDto() {
    }
}
