package co.za.springboot.competition.service.implementation;

import co.za.springboot.competition.controller.v1.command.CompetitionEntryCommand;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class ExampleRestService implements co.za.springboot.competition.service.RestService {
    static final String URL = "http://localhost:8080/json";


    /**
     * Posts a competition entry to some 3rd-party API
     * @param entryCommand Competition form field details
     * @return CompetitionEntry containing API success/failure
     */
    public boolean postEntry(CompetitionEntryCommand entryCommand){
        //Make the rest call
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CompetitionEntryCommand> response = restTemplate.postForEntity(URL, entryCommand, CompetitionEntryCommand.class);

        return response.getStatusCode().is2xxSuccessful();
    }

}
