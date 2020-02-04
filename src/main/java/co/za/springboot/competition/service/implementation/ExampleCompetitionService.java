package co.za.springboot.competition.service.implementation;

import co.za.springboot.competition.controller.v1.command.CompetitionEntryCommand;
import co.za.springboot.competition.model.CompetitionEntry;
import co.za.springboot.competition.repository.CompetitionEntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ExampleCompetitionService implements co.za.springboot.competition.service.CompetitionService {
    private CompetitionEntryRepository competitionEntryRepository;
    private ExampleRestService restService;

    public ExampleCompetitionService(CompetitionEntryRepository competitionEntryRepository, ExampleRestService restService) {
        this.competitionEntryRepository = competitionEntryRepository;
        this.restService = restService;
    }

    /**
     * Posts a competition entry to some 3rd-party API and then saves it to the database
     * @param entryCommand Competition form field details
     * @return CompetitionEntry containing API success/failure
     */
    public CompetitionEntry saveCompetitionEntry(CompetitionEntryCommand entryCommand) {
        //Create a CompetitionEntry, post to 3rd-party and save to DB
        CompetitionEntry competitionEntry = new CompetitionEntry();
        BeanUtils.copyProperties(entryCommand, competitionEntry);
        competitionEntry.setSentViaApi(restService.postEntry(entryCommand));
        competitionEntryRepository.save(competitionEntry);
        return competitionEntry;
    }
}
