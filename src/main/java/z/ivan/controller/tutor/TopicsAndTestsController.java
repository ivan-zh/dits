package z.ivan.controller.tutor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import z.ivan.dto.TestEditDto;
import z.ivan.model.Test;
import z.ivan.service.Tutor.TopicsAndTestsService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("tutor/topics_and_tests")
public class TopicsAndTestsController {

    private TopicsAndTestsService topicsAndTestsService;

    public TopicsAndTestsController(TopicsAndTestsService topicsAndTestsService) {
        this.topicsAndTestsService = topicsAndTestsService;
    }

    @GetMapping("")
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("topics", topicsAndTestsService.getTopicList());
        modelMap.addAttribute("tests", topicsAndTestsService.getTestList());
        modelMap.addAttribute("questions", topicsAndTestsService.getQuestionList());
        return "tutor/edit_topics_and_tests";
    }

    @PostMapping("")
    public String edit(
            ModelMap modelMap,
            @RequestParam Long selectedTopicId,
            @RequestParam String editData
    ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<TestEditDto> list = mapper.readValue(editData, new TypeReference<List<TestEditDto>>() {
        });

        topicsAndTestsService.edit(selectedTopicId, list);
        return main(modelMap);
    }

}
