package com.example.tawjihi;

public class TawjiheDS {
    DoubleLinkedList list =new DoubleLinkedList();
    AVL treeSortbyNumber=new AVL();
    AVLAverage treeSortByAverage=new AVLAverage();


    public void insert(Tawjihe data ,NodeAVL root ){
        list.insert(data);
        treeSortbyNumber.insert(root,data);

    }

    public void print (){
        list.toString();
       // treeSortbyNumber.levelOrder();
    }
}
