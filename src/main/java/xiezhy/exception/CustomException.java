package xiezhy.exception;

/**
 * version:
 * --------------------
 * date:2016/4/25
 * author:binbin
 */
public class CustomException extends Exception{
    private String msg;
    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
