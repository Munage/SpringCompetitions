package co.za.omf.visa.model;

import co.za.omf.visa.model.base.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
public class VisaCompetitionEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
    private boolean sentToEverlytic;

    @Override
    public String toString() {
        return "VisaCompetitionEntry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", acceptedTermsAndConditions=" + acceptedTermsAndConditions +
                ", sentToEverlytic=" + sentToEverlytic +
                '}';
    }
}
