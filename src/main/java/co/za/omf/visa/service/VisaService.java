package co.za.omf.visa.service;

import co.za.omf.visa.dto.VisaEntryDto;
import co.za.omf.visa.model.VisaCompetitionEntry;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VisaService {
    final String uri = "http://localhost:8080/json";

    public void postEntry(VisaCompetitionEntry entry){
        RestTemplate restTemplate = new RestTemplate();

        VisaEntryDto visaEntryDto = new VisaEntryDto();
        BeanUtils.copyProperties(entry, visaEntryDto);

        ResponseEntity<VisaEntryDto> response = restTemplate.postForEntity(uri, visaEntryDto, VisaEntryDto.class);
        HttpStatus status = response.getStatusCode();
        if(response.getStatusCode().is2xxSuccessful()){
            entry.setSentToEverlytic(true);
        }
    }

}
