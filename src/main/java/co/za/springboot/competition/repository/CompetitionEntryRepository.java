package co.za.springboot.competition.repository;

import co.za.springboot.competition.model.CompetitionEntry;
import org.springframework.data.repository.CrudRepository;

public interface CompetitionEntryRepository extends CrudRepository<CompetitionEntry, Long> {
}
