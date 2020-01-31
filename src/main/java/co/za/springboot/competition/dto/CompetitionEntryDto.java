package co.za.springboot.competition.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CompetitionEntryDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Surname is required")
    private String surname;
    @NotBlank(message = "Cellphone is required")
    private String cellphone;
    @NotBlank(message = "ID is required")
    private String idNumber;
    @NotBlank(message = "Gender is required")
    private String gender;
    @AssertTrue(message = "Please accept the terms & conditions")
    private boolean acceptedTermsAndConditions;
}
