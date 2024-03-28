package com.example.tawjihi;



public class NodeAVL {

    private Tawjihe data;

    NodeAVL left;
    NodeAVL right;
    int height;


    public NodeAVL ( Tawjihe data){ // get maximum number
        this.data=data;
        height=0;
    }



    public Tawjihe getData() {
        return data;
    }

    public void setData(Tawjihe data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return " [ Data =" + getData() +  "]";
    }

}
