package com.controller;

import com.dto.problem.ProblemDto;
import com.dto.problem.ProblemUpdateAllDto;
import com.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {
    private final ProblemService problemService;

    @GetMapping("/list")
    public ResponseEntity<List<ProblemDto>> getProblemList() {
        List<ProblemDto> problems = problemService.findAll();
        return new ResponseEntity<>(problems, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Void> updateProblemAll(@RequestBody ProblemDto problemInfo) {
        problemService.addProblem(problemInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/update-all")
//    public ResponseEntity<Void> updateProblemAll(@RequestBody ProblemUpdateAllDto problemInfo) {
//        problemService.updateProblemAll(problemInfo);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
