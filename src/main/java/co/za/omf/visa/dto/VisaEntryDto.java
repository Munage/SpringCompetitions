package co.za.omf.visa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class VisaEntryDto {
    private String name;
    private String surname;
    private String cellphone;
    private String idNumber;
    private String gender;
}
