package com.example.tawjihi;

class DoubleLinkedList {
    Node header;

    public DoubleLinkedList() {
        header = null;
    }

    public void insert(Tawjihe data) {
        Node newNode = new Node(data);
        if (header == null) {
            header = newNode;
            header.next = header;
            header.prev = header;
        } else {
            Node last = header.prev;
            newNode.next = header;
            newNode.prev = last;
            last.next = newNode;
            header.prev = newNode;
        }
//		return newNode;
    }

    public void delete(Tawjihe data) {
        Node current = header;
        if (header != null) {
            do {
                if (current.data.equals(data)) {
                    if (current == header) {
                        header = header.next;
                        header.prev = current.prev;
                        current.prev.next = header;
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    return;
                }
                current = current.next;
            } while (current != header);
        }
    }

    public Node find(Tawjihe data) {
        Node current = header;
        if (header != null) {
            do {
                if (current.data.equals(data)) {
                    return current;
                }
                current = current.next;
            } while (current != header);
        }
        return null;
    }

    public String toString() {

        Node current = header;
        String s = "Header -->";
        if (header != null) {
            do {
                s += current.toString();
                current = current.next;
            } while (current != header);
        }
        return s ;
    }

}


