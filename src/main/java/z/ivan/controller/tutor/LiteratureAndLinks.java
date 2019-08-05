package z.ivan.controller.tutor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import z.ivan.dto.LiteratureEditDto;
import z.ivan.service.tutor.LiteratureAndLinksService;
import z.ivan.service.tutor.QuestionsAndAnswersService;
import z.ivan.service.tutor.TopicsAndTestsService;

import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping("tutor/literature_and_links")
public class LiteratureAndLinks {

    private TopicsAndTestsService topicsAndTestsService;
    private QuestionsAndAnswersService questionsAndAnswersService;
    private LiteratureAndLinksService literatueAndLinksService;

    public LiteratureAndLinks(TopicsAndTestsService topicsAndTestsService,
                              QuestionsAndAnswersService questionsAndAnswersService, LiteratureAndLinksService literatueAndLinksService) {
        this.topicsAndTestsService = topicsAndTestsService;
        this.questionsAndAnswersService = questionsAndAnswersService;
        this.literatueAndLinksService = literatueAndLinksService;
    }

    @GetMapping("/tutor/literature_and_links")
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        modelMap.addAttribute("literature", literatueAndLinksService.getLiteratureList());
        modelMap.addAttribute("links", literatueAndLinksService.getLinkList());
        return "tutorUI/edit_literature_and_links";
    }

    @PostMapping("/tutor/literature_and_links")
    public String edit(ModelMap modelMap,
                       @RequestParam String editData) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<LiteratureEditDto> questionList = mapper.readValue(editData, new TypeReference<List<LiteratureEditDto>>() {
        });
        literatueAndLinksService.edit(questionList);
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        modelMap.addAttribute("literature", literatueAndLinksService.getLiteratureList());
        modelMap.addAttribute("links", literatueAndLinksService.getLinkList());
        return "tutorUI/edit_literature_and_links";
    }
}
