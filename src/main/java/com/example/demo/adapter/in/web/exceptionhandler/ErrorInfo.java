package com.example.demo.adapter.in.web.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {
    @JsonProperty("date")
    private String dateTimeFormatter;
    @JsonProperty("message")
    private String message;
    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("uri")
    private String uriRequested;


    public ErrorInfo(String dateTimeFormatter, int statusCode, String message, String uriRequested) {
        this.dateTimeFormatter=dateTimeFormatter;
        this.message = message;
        this.statusCode = statusCode;
        this.uriRequested = uriRequested;
    }

    public String getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getUriRequested() {
        return uriRequested;
    }
}
