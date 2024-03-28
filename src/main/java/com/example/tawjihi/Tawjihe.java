package com.example.tawjihi;

public class Tawjihe implements Comparable <Tawjihe> {
    int seatNumber ;
    String branch ;
    String  average ;

    public  Tawjihe() {

    }

    public  Tawjihe  (int seatNumber , String branch, String   average  ) {
        super();
        this.seatNumber=seatNumber;
        this.branch=branch;
        this.average=average;

    }

    public Tawjihe(String s) {
    }


    public int getSeatNumber() {
        return seatNumber;
    }


    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }


    public String getBranch() {
        return branch;
    }


    public void setBranch(String branch) {
        this.branch = branch;
    }


    public String   getAverage() {
        return average;
    }




    @Override
    public int compareTo (Tawjihe data) {
        if (this.seatNumber > data.seatNumber) {
            return 1;
        } else if (this.seatNumber == data.seatNumber) {
            return 0;
        } else {
            return -1;
        }
    }



    @Override
    public String toString() {
        return "Tawjihe [seatNumber=" + seatNumber + ", branch=" + branch + ", average=" + average + "]";
    }











}
