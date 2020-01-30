package co.za.omf.visa.model.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@EnableJpaAuditing(auditorAwareRef = "auditorProvider")

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
public class Auditable {
    @CreatedDate
    private Date dateCreated;

    @LastModifiedDate
    private Date lastUpdated;

    public Auditable(Date dateCreated, Date lastUpdated) {
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
}
