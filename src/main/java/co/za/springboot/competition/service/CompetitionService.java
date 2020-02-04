package co.za.springboot.competition.service;

import co.za.springboot.competition.controller.v1.command.CompetitionEntryCommand;
import co.za.springboot.competition.model.CompetitionEntry;

public interface CompetitionService {
    /**
     * Posts a competition entry to some 3rd-party API
     * @param entryCommand Competition form field details
     * @return CompetitionEntry containing API success/failure
     */
    CompetitionEntry saveCompetitionEntry(CompetitionEntryCommand entryCommand);
}
