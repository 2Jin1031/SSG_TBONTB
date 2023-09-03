package com.controller;

import com.dto.work.WorkDto;
import com.dto.work.WorkUpdateAllDto;
import com.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/work")
public class WorkController {
    private final WorkService workService;

    @GetMapping("/list")
    public ResponseEntity<List<WorkDto>> getWorkList() {
        List<WorkDto> works = workService.findAll();
        return new ResponseEntity<>(works, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Void> updateWorkAll(@RequestBody WorkDto workInfo) {
        workService.addWork(workInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/update-all")
//    public ResponseEntity<Void> updateWorkAll(@RequestBody WorkUpdateAllDto workInfo) {
//        workService.updateWorkAll(workInfo);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
