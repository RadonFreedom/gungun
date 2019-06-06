package fre.shown.gungun.service;

import fre.shown.gungun.domain.ResultVO;
import fre.shown.gungun.domain.SkillWeight;
import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 * @author Radon Freedom
 * created at 2019.05.26 18:10
 */


@Getter
@Service
public class SkillWeightService {

    private volatile SkillWeight[] weights;
    private static final int EXPECTED_ROW_NUM = 46;

    public ResultVO<String> setWeights(String s) {

        ResultVO<String> result = new ResultVO<>();

        String[] temp =  s.split("\n");

        if (temp.length != EXPECTED_ROW_NUM) {
            result.setErrorMsg("输入有误！");
            return result;
        }

        String[][] settings = new String[temp.length - 1][];
        settings[0] = temp[0].split("\t");
        int expectedColNum = settings[0].length;

        for (int i = 2; i < temp.length; i++) {
            settings[i - 1] = temp[i].split("\t");
            if (expectedColNum != settings[i - 1].length) {
                result.setErrorMsg("输入有误！");
                return result;
            }
        }

        SkillWeight[] tempWeights = new SkillWeight[expectedColNum];
        for (int i = 0; i < expectedColNum; i++) {
            SkillWeight weight = new SkillWeight();

            weight.setJobName(settings[0][i]);

            weight.setA1(Double.parseDouble(settings[1][i]));
            weight.setA2(Double.parseDouble(settings[2][i]));
            weight.setA3(Double.parseDouble(settings[3][i]));

            weight.setB1(Double.parseDouble(settings[4][i]));
            weight.setB2(Double.parseDouble(settings[5][i]));
            weight.setB3(Double.parseDouble(settings[6][i]));

            weight.setC1(Double.parseDouble(settings[7][i]));
            weight.setC2(Double.parseDouble(settings[8][i]));
            weight.setC3(Double.parseDouble(settings[9][i]));
            weight.setC4(Double.parseDouble(settings[10][i]));
            weight.setC5(Double.parseDouble(settings[11][i]));

            weight.setD1(new double[]{
                    Double.parseDouble(settings[12][i]),
                    Double.parseDouble(settings[13][i]),
                    Double.parseDouble(settings[14][i]),
                    Double.parseDouble(settings[15][i]),
            });
            weight.setD2(new double[]{
                    Double.parseDouble(settings[16][i]),
                    Double.parseDouble(settings[17][i]),
                    Double.parseDouble(settings[18][i]),
                    Double.parseDouble(settings[19][i]),
            });
            weight.setD3(Double.parseDouble(settings[20][i]));
            weight.setD4(Double.parseDouble(settings[21][i]));

            weight.setE1(Double.parseDouble(settings[22][i]));
            weight.setE2(Double.parseDouble(settings[23][i]));
            weight.setE3(Double.parseDouble(settings[24][i]));
            weight.setE4(Double.parseDouble(settings[25][i]));
            weight.setE5(Double.parseDouble(settings[26][i]));
            weight.setE6(Double.parseDouble(settings[27][i]));
            weight.setE7(Double.parseDouble(settings[28][i]));
            weight.setE8(Double.parseDouble(settings[29][i]));
            weight.setE9(Double.parseDouble(settings[30][i]));
            weight.setE10(Double.parseDouble(settings[31][i]));
            weight.setE11(Double.parseDouble(settings[32][i]));
            weight.setE12(Double.parseDouble(settings[33][i]));
            weight.setE13(Double.parseDouble(settings[34][i]));

            weight.setLocation(new double[]{
                    Double.parseDouble(settings[35][i]),
                    Double.parseDouble(settings[36][i]),
                    Double.parseDouble(settings[37][i]),
                    Double.parseDouble(settings[38][i]),
                    Double.parseDouble(settings[39][i]),
                    Double.parseDouble(settings[40][i]),
                    Double.parseDouble(settings[41][i]),
                    Double.parseDouble(settings[42][i]),
                    Double.parseDouble(settings[43][i]),
                    Double.parseDouble(settings[44][i]),
            });

            tempWeights[i] = weight;
        }

        weights = tempWeights;

        result.setSuccess(true);
        return result;
    }
}
