package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import javax.servlet.http.HttpServletResponse;

public class ResponseBean {
    private String message="";
    private String result="";
    private int code=HttpServletResponse.SC_OK;
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    


}
