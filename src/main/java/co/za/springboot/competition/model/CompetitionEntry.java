package co.za.springboot.competition.model;

import co.za.springboot.competition.model.base.Auditable;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CompetitionEntry extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String cellphone;
    private String idNumber;
    private String gender;
    private boolean acceptedTermsAndConditions;
    private boolean sentViaApi;

    @Override
    public String toString() {
        return "CompetitionEntry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", acceptedTermsAndConditions=" + acceptedTermsAndConditions +
                ", sentViaApi=" + sentViaApi +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
