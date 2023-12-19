package com.example.RestfullAPI.Controller;

import com.example.RestfullAPI.DTO.TitleDTO;
import com.example.RestfullAPI.Model.Title;
import com.example.RestfullAPI.Service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/title")
public class TitleController {
    @Autowired
    TitleService titleService;
    @RequestMapping(value = "/add-title-employee", method = RequestMethod.POST)
    public ResponseEntity<?> AddEmployeeTitle(@Validated @RequestBody TitleDTO titleDTO){
        if(titleService.findByid(titleDTO.getId()) == null){
            Title title = new Title();
            title.setId(titleDTO.getId());
            title.setToDate(titleDTO.getToDate());
            titleService.save(title);
            return ResponseEntity.ok(title);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/get-title-employee/{empNo}", method = RequestMethod.GET)
    public ResponseEntity<?> GetTitleEmployee(@PathVariable("empNo") int empNo){
        List<Title> titles = titleService.findAll()
                .stream()
                .filter(title -> title.getId().getEmpNo() == empNo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(titles);
    }
}
