package org.example.competanceservice.services;

import org.example.competanceservice.dtos.CompetenceDTO;
import org.example.competanceservice.dtos.SubCompetenceDTO;
import org.example.competanceservice.entities.Competence;
import org.example.competanceservice.entities.SubCompetence;
import org.example.competanceservice.mappers.CompetenceMapper;
import org.example.competanceservice.mappers.SubCompetenceMapper;
import org.example.competanceservice.repositories.CompetenceRepository;
import org.example.competanceservice.repositories.SubCompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {
    private final CompetenceMapper mapper;
    private final CompetenceRepository repository;
    private final SubCompetenceRepository subCompetenceRepository;
    private final SubCompetenceMapper subCompetenceMapper;


    public CompetenceService(CompetenceMapper mapper, CompetenceRepository repository, SubCompetenceRepository subCompetenceRepository, SubCompetenceMapper subCompetenceMapper) {
        this.mapper = mapper;
        this.repository = repository;
        this.subCompetenceRepository = subCompetenceRepository;
        this.subCompetenceMapper = subCompetenceMapper;
    }

    public CompetenceDTO addCompetence(CompetenceDTO dto){
        Competence competence = mapper.toEntity(dto);
        Competence savedCompetence = repository.save(competence);
        return mapper.toDTO(savedCompetence);
//        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public CompetenceDTO updateCompetence(Long id, CompetenceDTO dto){
        Competence competence = repository.findById(id)
                .orElseThrow(()->new RuntimeException("competence not found"));
        competence.setName(dto.getName());
        competence.setDescription(dto.getDescription());
//        CompetenceDTO competenceDTO = mapper.toDTO(repository.save(competence));
//        return competenceDTO;
        return mapper.toDTO(repository.save(competence));
    }

    public List<CompetenceDTO> getAll(){
        List<Competence> competenceList = repository.findAll();

        CompetenceDTO competenceDTO;
        return mapper.toDTOs(competenceList);
    }

    public CompetenceDTO getCompetenceById(Long id) {
        Competence competence = repository.getCompetenceById(id);

        if (competence == null) {
            throw new RuntimeException("Competence not found with id: " + id);
        }
        return mapper.toDTO(competence);
    }

    public List<Competence> getAll2(){
        List<Competence> competenceList = repository.findAll();

        return competenceList;
    }

    public List<SubCompetenceDTO> getByCompetenceById(Long id){
        List<SubCompetence> subCompetenceList = subCompetenceRepository.findAllByCompetence_Id(id);
        List<SubCompetenceDTO> subCompetenceDTOList = subCompetenceMapper.toDTOs(subCompetenceList);
        return subCompetenceDTOList;
    }

    public void deleteCompetence(Long id){
        repository.deleteById(id);
    }

//    public boolean isAcquired(Long competenceId) {
//        List<SubCompetence> subCompetenceList = subCompetenceRepository.findAllByCompetence_Id(competenceId);
//        return subCompetenceList != null &&
//                !subCompetenceList.isEmpty() &&
//                subCompetenceList.stream().allMatch(SubCompetence::isValidated);
//    }
}
