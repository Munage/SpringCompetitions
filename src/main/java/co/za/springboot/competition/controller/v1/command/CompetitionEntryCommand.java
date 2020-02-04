package co.za.springboot.competition.controller.v1.command;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

/**
 * Command objects represent requests from the presentation layer.
 * Once a form is submitted, all the individual attributes are mapped/bound to this object.
 * On the way up to presentation, Command Object properties may be used to pre/populate the form.
 */

@Getter
@Setter
public class CompetitionEntryCommand {
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
