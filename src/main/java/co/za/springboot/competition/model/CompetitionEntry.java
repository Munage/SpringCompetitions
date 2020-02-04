package co.za.springboot.competition.model;

import co.za.springboot.competition.model.base.Auditable;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class is what gets mapped to the database layer.
 * The annotated constraints are applied to the table if using SQL.
 */

@Entity
@Data
public class CompetitionEntry extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String cellphone;
    @NotBlank
    private String idNumber;
    @NotBlank
    private String gender;
    private boolean acceptedTermsAndConditions;
    @NotNull
    private boolean sentViaApi;
}
