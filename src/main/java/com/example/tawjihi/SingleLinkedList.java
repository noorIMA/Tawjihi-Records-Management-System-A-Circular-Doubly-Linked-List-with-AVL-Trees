package com.example.tawjihi;

public class SingleLinkedList {
    static NodeSLL header;


    public void insertSorted( String seat_number,String average) {
        NodeSLL newnode = new NodeSLL(seat_number, average);
        if (header == null) {
            header = newnode;
        } else {
            NodeSLL current = header;
            NodeSLL prev = null;
            while (current != null && current.getAverage().compareTo(average) > 0) {
                prev = current;
                current = current.next;
            }
            if (prev == null) {
                newnode.next = header;
                header = newnode;
            } else {
                newnode.next = current;
                prev.next = newnode;
            }
        }

    }

    public void Traversal() {
        NodeSLL ptr = header;
        if (ptr == null) {
            System.out.println("list is empty");
            System.exit(0);
        }
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.next;
        }
    }
    public static boolean delete(String seat_number , String average ) {

        if(header==null) {
            System.out.println("Error: the List is Empty !!!");
            return false;
        }

        NodeSLL current=header;
        NodeSLL prev=null;
        while((current!=null) && current.getSeat_number().compareTo(seat_number)<0) {
            prev = current;
            current = current.next;
        }
        if(current.getSeat_number().equals(seat_number)) {
            if(current==header) {
                header=header.next;
            }
            else {
                prev.next=current.next;
                //System.out.println("The delete operation failed");
            }
        }
        else {
            System.out.println(current);
            System.out.println("The delete operation failed");
        }
        return false;


    }



}
