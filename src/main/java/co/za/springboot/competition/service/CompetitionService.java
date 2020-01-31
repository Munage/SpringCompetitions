package co.za.springboot.competition.service;

import co.za.springboot.competition.dto.CompetitionEntryDto;
import co.za.springboot.competition.model.CompetitionEntry;
import co.za.springboot.competition.repository.CompetitionEntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService {
    private CompetitionEntryRepository competitionEntryRepository;
    private RestService restService;

    public CompetitionService(CompetitionEntryRepository competitionEntryRepository, RestService restService) {
        this.competitionEntryRepository = competitionEntryRepository;
        this.restService = restService;
    }

    public CompetitionEntry saveCompetitionEntry(CompetitionEntryDto entry) {
        //Create a CompetitionEntry, post to 3rd-party and save to DB
        CompetitionEntry competitionEntry = new CompetitionEntry();
        BeanUtils.copyProperties(entry, competitionEntry);
        competitionEntry.setSentViaApi(restService.postEntry(entry));
        competitionEntryRepository.save(competitionEntry);

        return competitionEntry;
    }
}
