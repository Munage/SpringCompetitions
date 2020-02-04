package co.za.springboot.competition.repository;

import co.za.springboot.competition.model.CompetitionEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitionEntryRepository extends CrudRepository<CompetitionEntry, Long> {
    /**
     * Create custom queries here, like the example below
     */
    Optional<List<CompetitionEntry>> findAllBySentViaApi(boolean result);
}
