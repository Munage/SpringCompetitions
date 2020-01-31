package co.za.springboot.competition.service;

import co.za.springboot.competition.dto.CompetitionEntryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    static final String URL = "http://localhost:8080/json";

    /**
     * Posts a competition entry to some 3rd-party API
     * @param entry Competition form field details
     * @return CompetitionEntry containing API success/failure
     */
    public boolean postEntry(CompetitionEntryDto entry){
        //Make the rest call
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CompetitionEntryDto> response = restTemplate.postForEntity(URL, entry, CompetitionEntryDto.class);

        return response.getStatusCode().is2xxSuccessful();
    }

}
