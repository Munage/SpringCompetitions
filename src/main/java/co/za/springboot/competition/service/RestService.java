package co.za.springboot.competition.service;

import co.za.springboot.competition.controller.v1.command.CompetitionEntryCommand;

public interface RestService {

    /**
     * Posts a competition entry to some 3rd-party API
     * @param entryCommand Competition form field details
     * @return CompetitionEntry containing API success/failure
     */
    boolean postEntry(CompetitionEntryCommand entryCommand);
}
