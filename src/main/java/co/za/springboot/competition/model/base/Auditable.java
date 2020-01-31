package co.za.springboot.competition.model.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@EnableJpaAuditing(auditorAwareRef = "auditorProvider")

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
public class Auditable {
    @CreationTimestamp
    protected LocalDateTime createDateTime;
    @UpdateTimestamp
    protected LocalDateTime updateDateTime;
}
