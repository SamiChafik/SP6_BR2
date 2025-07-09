package org.example.briefservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BriefDto {
    private Long id;
    private String title;
    private String description;
    private Date dateCreation;
}
