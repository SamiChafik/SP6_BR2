package org.example.briefservice.Controller;


import lombok.Getter;
import org.example.briefservice.Dto.BriefDto;
import org.example.briefservice.Service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brief")
public class BriefController {

    @Autowired
    private BriefService service;

    @PostMapping
    public BriefDto saveBrief(@RequestBody BriefDto dto){
        return service.saveBrief(dto);
    }

    @GetMapping("/{id}")
    public BriefDto getBriefById(@PathVariable Long id){
        return service.getBriefById(id);
    }

    @GetMapping
    public List<BriefDto> getAllBriefs(){
        return service.getAllBriefs();
    }

    @PutMapping("/{id}")
    public BriefDto editBrief(@PathVariable Long id,@RequestBody BriefDto dto){
        return service.editBrief(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBrief(@PathVariable Long id){
        service.deleteBrief(id);
    }
}
