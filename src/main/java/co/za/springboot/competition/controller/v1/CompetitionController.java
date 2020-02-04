package co.za.springboot.competition.controller.v1;

import co.za.springboot.competition.controller.v1.command.CompetitionEntryCommand;
import co.za.springboot.competition.model.CompetitionEntry;
import co.za.springboot.competition.service.CompetitionService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class CompetitionController {

    private CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping({"", "/", "/entry"})
    public String enter(Model model) {
        model.addAttribute("entry", new CompetitionEntry());
        model.addAttribute("message", "Hello, Potato");
        return "/competition/competitionform";
    }

    @PostMapping("/entry")
    public String submit(@Valid @ModelAttribute("entry") CompetitionEntryCommand entryCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/competition/competitionform";
        }
        competitionService.saveCompetitionEntry(entryCommand);

        return "/competition/competitionthanks";
    }

    @PostMapping(value = "/json", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public void displayJson(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        System.out.println(json);
    }
}
