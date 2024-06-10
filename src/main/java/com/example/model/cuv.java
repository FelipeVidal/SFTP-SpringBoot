package com.example.model;

public class cuv {
    private int processId;
    private String invoice;
    private String date;
    private String hour;
    private String processState;
    private String cuv;

    public cuv(int processId,  String invoice, String date, String hour, String processState, String cuv ){
        this.processId = processId;
        this.invoice = invoice;
        this.date = date;
        this.hour = hour;
        this.processState = processState;
        this.cuv = cuv;
    }
    public cuv(){}
    public int getProcessId() {
        return processId;
    }

    public String getInvoice() {
        return invoice;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getProcessState() {
        return processState;
    }

    public String getCuv() {
        return cuv;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public void setCuv(String cuv) {
        this.cuv = cuv;
    }

    


}
