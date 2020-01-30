package co.za.omf.visa.controller;

import co.za.omf.visa.model.VisaCompetitionEntry;
import co.za.omf.visa.repository.VisaCompetitionEntryRepository;
import co.za.omf.visa.service.VisaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class VisaController {

    private VisaCompetitionEntryRepository visaCompetitionEntryRepository;
    private VisaService visaService;

    @Autowired
    public VisaController(VisaCompetitionEntryRepository visaCompetitionEntryRepository, VisaService visaService) {
        this.visaCompetitionEntryRepository = visaCompetitionEntryRepository;
        this.visaService = visaService;
    }

    @GetMapping({"", "/", "/entry"})
    public String VisaForm(Model model) {
        model.addAttribute("entry", new VisaCompetitionEntry());
        return "/visa/visaform";
    }

    @PostMapping("/entry")
    public String VisaSubmit(@Valid @ModelAttribute("entry") VisaCompetitionEntry entry, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/visa/visaform";
        }
        visaService.postEntry(entry);
        visaCompetitionEntryRepository.save(entry);

        return "/visa/visathanks";
    }

    @RequestMapping(value = "/test", method = POST)
    public ResponseEntity<String> createEmployee(@RequestBody VisaCompetitionEntry entry)
    {
        System.out.println(entry.toString());
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/json", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public void greetingJson(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        System.out.println(json);
    }
}
