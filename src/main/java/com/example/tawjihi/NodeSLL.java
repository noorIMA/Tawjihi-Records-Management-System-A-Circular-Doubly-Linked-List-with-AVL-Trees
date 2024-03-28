package com.example.tawjihi;

public class NodeSLL {
    private String seat_number;
    private String average;
    NodeSLL next;

    public NodeSLL  (String seat_number, String average){

        this.seat_number = seat_number;
        this.average = this.average;
    }
    public String getSeat_number() {
        return seat_number;
    }

    public void setAverage(String average) {
        this.average = average;
    }
    public String getAverage() {

        return average;
    }

    public void setSeat_number(String seat_number2) {

        this.seat_number = seat_number2;
    }

    @Override
    public String toString() {
        return " [ seat_number=" + getSeat_number()  + "]";
    }



}
