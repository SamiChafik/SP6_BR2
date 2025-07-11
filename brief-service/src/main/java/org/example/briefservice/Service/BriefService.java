package org.example.briefservice.Service;

import org.example.briefservice.Dto.BriefDto;
import org.example.briefservice.Entity.Brief;
import org.example.briefservice.Mapper.BriefMapper;
import org.example.briefservice.Repository.BriefRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefService{

    private final BriefRepo repo;
    private final BriefMapper mapper;

    public BriefService(BriefRepo repo, BriefMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public BriefDto saveBrief(BriefDto dto){
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public BriefDto getBriefById(Long id){
        Brief brief  = repo.findById(id).orElseThrow(()->new RuntimeException("Brief not found"));
        return mapper.toDto(brief);
    }

    public List<BriefDto> getAllBriefs(){
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    public BriefDto editBrief(Long id, BriefDto dto){
        Brief brief = repo.findById(id).get();
        brief.setId(dto.getId());
        brief.setTitle(dto.getTitle());
        brief.setDescription(dto.getDescription());
        brief.setDateCreation(dto.getDateCreation());

        return mapper.toDto(repo.save(brief));
    }

    public void deleteBrief(Long id){
        repo.deleteById(id);
    }
}
