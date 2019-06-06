package fre.shown.gungun.controller;

import fre.shown.gungun.domain.ResultVO;
import fre.shown.gungun.domain.Skill;
import fre.shown.gungun.service.JobResultService;
import fre.shown.gungun.service.SkillWeightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Radon Freedom
 * created at 2019.05.25 20:35
 */


@RestController
public class Controller {

    private final JobResultService jobResultService;
    private final SkillWeightService skillWeightService;

    public Controller(JobResultService jobResultService, SkillWeightService skillWeightService) {
        this.jobResultService = jobResultService;
        this.skillWeightService = skillWeightService;
    }

    @PostMapping("/result")
    public ResultVO<String> result(Skill skill) {
        return jobResultService.getResult(skill);
    }

    @PostMapping("/setting")
    public ResultVO<String> setting(String setting) {
        return skillWeightService.setWeights(setting);
    }
}
