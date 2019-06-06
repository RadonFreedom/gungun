package fre.shown.gungun.service;

import fre.shown.gungun.domain.ResultVO;
import fre.shown.gungun.domain.Skill;
import fre.shown.gungun.domain.SkillWeight;
import org.springframework.stereotype.Service;

/**
 * @author Radon Freedom
 * created at 2019.05.25 22:05
 */

@Service
public class JobResultService {

    private final SkillWeightService skillWeightService;

    public JobResultService(SkillWeightService skillWeightService) {
        this.skillWeightService = skillWeightService;
    }

    public ResultVO<String> getResult(Skill skill) {

        ResultVO<String> result = new ResultVO<>();

        SkillWeight[] weights = skillWeightService.getWeights();

        if (weights == null) {
            result.setErrorMsg("尚未设定职位及技能权重！");
            return result;
        }

        int maxScoreJobIndex = 0;
        double maxScore = Double.MIN_VALUE;

        for (int i = 0; i < weights.length; i++) {
            double currentScore = getScore(skill, weights[i]);
            if (currentScore > maxScore) {
                maxScore = currentScore;
                maxScoreJobIndex = i;
            }
        }

        result.setSuccecssData(weights[maxScoreJobIndex].getJobName() + "，该职位得分为：" + maxScore);
        return result;
    }

    private double getScore(Skill skill, SkillWeight weight) {

        double score = 0;

        if (skill.getA1()) {
            score += weight.getA1();
        }
        if (skill.getA2()) {
            score += weight.getA2();
        }
        if (skill.getA3()) {
            score += weight.getA3();
        }

        if (skill.getB1()) {
            score += weight.getB1();
        }
        if (skill.getB2()) {
            score += weight.getB2();
        }
        if (skill.getB3()) {
            score += weight.getB3();
        }

        if (skill.getC1()) {
            score += weight.getC1();
        }
        if (skill.getC2()) {
            score += weight.getC2();
        }
        if (skill.getC3()) {
            score += weight.getC3();
        }
        if (skill.getC4()) {
            score += weight.getC4();
        }
        if (skill.getC5()) {
            score += weight.getC5();
        }
        
        double[] d1Weight = weight.getD1();
        score += d1Weight[0] * d1Weight[skill.getD1()];
        double[] d2Weight = weight.getD2();
        score += d2Weight[0] * d2Weight[skill.getD2()];
        if (skill.getD3()) score += weight.getD3();
        if (skill.getD4()) score += weight.getD4();

        if (skill.getE1()) score += weight.getE1();
        if (skill.getE2()) score += weight.getE2();
        if (skill.getE3()) score += weight.getE3();
        if (skill.getE4()) score += weight.getE4();
        if (skill.getE5()) score += weight.getE5();
        if (skill.getE6()) score += weight.getE6();
        if (skill.getE7()) score += weight.getE7();
        if (skill.getE8()) score += weight.getE8();
        if (skill.getE9()) score += weight.getE9();
        if (skill.getE10()) score += weight.getE10();
        if (skill.getE11()) score += weight.getE11();
        if (skill.getE12()) score += weight.getE12();
        if (skill.getE13()) score += weight.getE13();

        score *= weight.getLocation()[skill.getLocation() - 1];

        return score;
    }
}
