package com.jovine.nafa.entity;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StandardResponse {

    private boolean status;
    private String statuscode;
    private String message;
    private Object data;

    public StandardResponse(){
        super();
    }

    public StandardResponse(boolean isStatus , String message, Object data, String statuscode){

        this.status = isStatus;
        this.message = message;
        this.data = data;
        this.statuscode = statuscode;
    }

    public StandardResponse(boolean isStatus , String message, Object data){

        this.status = isStatus;
        this.message = message;
        this.data = data;
    }

    public StandardResponse(boolean isStatus , String message){

        this.status = isStatus;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getStatuscode() {
        return statuscode;
    }
    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public StandardResponse sendResponse(boolean status, String message, Object data, String statuscode){
        return new StandardResponse(status, message, data, statuscode);
    }

    public static ResponseEntity<StandardResponse> sendHttpResponse(boolean status, String message, Object data, String statuscode){
        StandardResponse sr =  new StandardResponse(status, message, data, statuscode);

        return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
    }

    public static ResponseEntity<StandardResponse> sendHttpResponse(boolean status, String message, Object data){
        StandardResponse sr =  new StandardResponse(status, message, data);

        return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
    }

    public static ResponseEntity<StandardResponse> sendHttpResponse(boolean status, String message){
        StandardResponse sr =  new StandardResponse(status, message);

        return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
    }
}
