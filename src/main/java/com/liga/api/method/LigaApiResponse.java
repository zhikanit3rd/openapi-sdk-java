package com.liga.api.method;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
public class LigaApiResponse<T> {

    public static final String SUCCESS_CODE = "0";

    protected String code;
    protected String msg;
    protected T data;

   public LigaApiResponse() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean successFlag(){
       return SUCCESS_CODE.equals(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LigaApiResponse)) {
            return false;
        }

        LigaApiResponse<?> that = (LigaApiResponse<?>) o;

        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) {
            return false;
        }
        if (getMsg() != null ? !getMsg().equals(that.getMsg()) : that.getMsg() != null) {
            return false;
        }
        return getData() != null ? getData().equals(that.getData()) : that.getData() == null;
    }

    @Override
    public int hashCode() {
        int result = getCode() != null ? getCode().hashCode() : 0;
        result = 31 * result + (getMsg() != null ? getMsg().hashCode() : 0);
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LigaApiResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
