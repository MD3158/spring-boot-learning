package com.example.exception;

import java.util.Date;

public class ExceptionRespon {
    private Date timestamp;
//  private String status;
    private String message;
    private String details;

    public ExceptionRespon(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
//      this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

//  public String getStatus() {
//      return status;
//  }

}