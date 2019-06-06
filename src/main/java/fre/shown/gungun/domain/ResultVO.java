package fre.shown.gungun.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Radon Freedom
 * created at 2019.04.27 下午5:45
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResultVO<T> {

    private Boolean success;
    private T data;
    private String msg;

    public void setErrorMsg(String msg) {
        this.setSuccess(false);
        this.setMsg(msg);
    }

    public void setSuccecssData(T data) {
        this.setSuccess(true);
        this.setData(data);
    }

    public void setSuccessDataAndMsg(T data, String msg) {
        this.setSuccess(true);
        this.setData(data);
        this.setMsg(msg);
    }
}
