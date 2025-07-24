package org.example.apprenantservice.services;

import org.example.apprenantservice.dtos.BriefDto;
import org.example.apprenantservice.dtos.CompetenceDTO;
import org.example.apprenantservice.dtos.RenduDTO;
import org.example.apprenantservice.entities.Rendu;
import org.example.apprenantservice.feign.BriefServiceClient;
import org.example.apprenantservice.feign.CompetenceServiceClient;
import org.example.apprenantservice.mappers.RenduMapper;
import org.example.apprenantservice.repositories.RenduRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RenduServices {

    private final RenduRepository renduRepository;
    private final RenduMapper renduMapper;
    private final BriefServiceClient briefServiceClient;
    private final CompetenceServiceClient competenceServiceClient;

    public RenduServices(RenduRepository renduRepository, RenduMapper renduMapper, BriefServiceClient briefServiceClient, CompetenceServiceClient competenceServiceClient) {
        this.renduRepository = renduRepository;
        this.renduMapper = renduMapper;
        this.briefServiceClient = briefServiceClient;
        this.competenceServiceClient = competenceServiceClient;
    }

    public List<RenduDTO> getAllRendus() {
        List<Rendu> rendus = renduRepository.findAll();
        return rendus.stream()
                .map(renduMapper::toDTO)
                .collect(Collectors.toList());
    }

//    public List<RenduDTO> getAllRendus() {
//        List<Rendu> rendus = renduRepository.findAll();
//
//        return rendus.stream()
//                .map(rendu -> {
//                    RenduDTO renduDTO = renduMapper.toDTO(rendu);
//
//                    // Map competence IDs to SimpleCompetenceDTOs
//                    List<CompetenceDTO> simpleCompetences = rendu.getCompetenceIds().stream()
//                            .map(competenceId -> {
//                                CompetenceDTO fullCompetence = competenceServiceClient.getCompetenceById(competenceId);
//                                return new CompetenceDTO(fullCompetence.getId(), fullCompetence.getName());
//                            })
//                            .collect(Collectors.toList());
//
//                    renduDTO.setCompetences(simpleCompetences);
//                    return renduDTO;
//                })
//                .collect(Collectors.toList());
//    }

    public RenduDTO getRenduById(Long id) {
        Rendu rendu = renduRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rendu not found with id: " + id));

        RenduDTO renduDTO = renduMapper.toDTO(rendu);

        List<CompetenceDTO> competenceDTOs = rendu.getCompetenceIds().stream()
                .map(competenceServiceClient::getCompetenceById)
                .collect(Collectors.toList());

        renduDTO.setCompetences(competenceDTOs);
        return renduDTO;
    }

    public RenduDTO createRendu(RenduDTO renduDTO) {
        Rendu rendu = renduMapper.toEntity(renduDTO);
        BriefDto brief = briefServiceClient.getBriefById(renduDTO.getBriefId());

        if (brief == null) {
            throw new RuntimeException("Brief not found with id: " + renduDTO.getBriefId());
        }

        Rendu savedRendu = renduRepository.save(rendu);
        return renduMapper.toDTO(savedRendu);
    }

    public RenduDTO assignCompetenceToRendu(Long renduId, Long competenceId) {
        CompetenceDTO competence = competenceServiceClient.getCompetenceById(competenceId);
        if (competence == null) {
            throw new RuntimeException("Brief not found with id: " + competenceId);
        }

        Rendu rendu = renduRepository.findById(renduId)
                .orElseThrow(() -> new RuntimeException("Rendu not found with id: " + renduId));

        if (!rendu.getCompetenceIds().contains(competenceId)) {
            rendu.getCompetenceIds().add(competenceId);
            renduRepository.save(rendu);
        }

        List<CompetenceDTO> competenceDTOs = rendu.getCompetenceIds().stream()
                .map(competenceServiceClient::getCompetenceById)
                .collect(Collectors.toList());

        RenduDTO renduDTO = renduMapper.toDTO(rendu);
        renduDTO.setCompetences(competenceDTOs);
        return renduDTO;
    }

//    public RenduDTO assignRenduToBrief(Long renduId, Long briefId) {
//        BriefDto brief = briefServiceClient.getBriefById(briefId);
//        if (brief == null) {
//            throw new RuntimeException("Brief not found with id: " + briefId);
//        }
//
//        Rendu rendu = renduRepository.findById(renduId)
//                .orElseThrow(() -> new RuntimeException("Rendu not found with id: " + renduId));
//
//        rendu.setBriefId(briefId);
//        Rendu updatedRendu = renduRepository.save(rendu);
//
//        return renduMapper.toDTO(updatedRendu);
//    }

    public RenduDTO updateRendu(Long id, RenduDTO renduDTO) {
        Rendu existingRendu = renduRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rendu not found with id: " + id));

        existingRendu.setLink(renduDTO.getLink());
        existingRendu.setComment(renduDTO.getComment());

        Rendu updatedRendu = renduRepository.save(existingRendu);
        return renduMapper.toDTO(updatedRendu);
    }

    public void deleteRendu(Long id) {
        if (!renduRepository.existsById(id)) {
            throw new RuntimeException("Rendu not found with id: " + id);
        }
        renduRepository.deleteById(id);
    }

    public Long total(Long id) {
        return renduRepository.total(id);
    }
}