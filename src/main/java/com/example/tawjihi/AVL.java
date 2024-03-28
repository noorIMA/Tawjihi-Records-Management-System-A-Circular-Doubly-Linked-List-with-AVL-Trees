package com.example.tawjihi;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
NodeAVL root;
    public int height(NodeAVL root){
        if(root == null)
            return 0;
        return root.height;
    }

    public int max (int a,int b){

        return (a>b)?a:b;
    }
    public NodeAVL rightRotate(NodeAVL root){
        NodeAVL newroot = root.left;
        NodeAVL sub = newroot.right;

        newroot.right=root;
        root.left=sub;

        root.height = max(height(root.left),height(root.right))+1;
        newroot.height = max(height(newroot.left),height(newroot.right))+1;

        return newroot;
    }
    public NodeAVL liftRotate(NodeAVL root){
        NodeAVL newroot = root.right;
        NodeAVL sub = newroot.left;

        newroot.left=root;
        root.right=sub;

        root.height = max(height(root.left),height(root.right))+1;
        newroot.height = max(height(newroot.left),height(newroot.right))+1;

        return newroot;
    }

    private NodeAVL rotateRightLeft(NodeAVL root) {
        root.right = liftRotate(root.right);
        return rightRotate(root);
    }

    private NodeAVL rotateLeftRight(NodeAVL root) {
        root.left = liftRotate(root.left);
        return rightRotate(root);
    }
    public int getHeightDifference(NodeAVL node) {
        if (node != null) {
            return Math.abs(height(node.left) - height(node.right));
        }
        return 0;
    }
    public NodeAVL rebalance(NodeAVL root){
        int diff = getHeightDifference(root);
        if (diff > 1) { // addition was in node's left subtree
            if (getHeightDifference(root.left) > 0)
                root = rightRotate(root);
            else
                root = rotateLeftRight(root);
        } else if (diff < -1) { // addition was in node's right subtree
            if (getHeightDifference(root.right) < 0)
                root = liftRotate(root);
            else
                root = rotateRightLeft(root);
        }
        return root;
    }

    public NodeAVL insert(NodeAVL root, Tawjihe seat_number) {
        if (root == null) {
            return new NodeAVL(seat_number);
        }

        if (seat_number.compareTo(root.getData()) < 0) {
            root.left = insert(root.left, seat_number);
        } else if (seat_number.compareTo(root.getData()) > 0) {
            root.right = insert(root.right, seat_number);
        } else {
            // seat_number is already in the tree
            return root;
        }

        // Update the height of the node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Check if the tree is unbalanced
        int balance = getHeightDifference(root);

        // If the tree is unbalanced, perform rotations
        if (balance > 1 && seat_number.compareTo(root.left.getData()) < 0) {
            return rightRotate(root);
        }

        if (balance < -1 && seat_number.compareTo(root.right.getData()) > 0) {
            return liftRotate(root);
        }

        if (balance > 1 && seat_number.compareTo(root.left.getData()) > 0) {
            root.left = liftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && seat_number.compareTo(root.right.getData()) < 0) {
            root.right = rightRotate(root.right);
            return liftRotate(root);
        }

        return root;
    }




    public NodeAVL find(Tawjihe data) {
        return find(data, root);
    }


    public NodeAVL find(Tawjihe data, NodeAVL root) {
        if (root != null) {
            int num =root.getData().compareTo((Tawjihe) data) ;

            if (num == 0)
                return root;
            else if (num > 0 && root.left!=null)
                return find(data, root.left);
            else if (num < 0 && root.right!=null)
                return find(data, root.right);
        }
        return null;
    }

    NodeAVL minValueNode(NodeAVL node)
    {
        NodeAVL temp;
        for(temp=node;temp.left!=null;temp=temp.left);

        return temp;
    }
    public NodeAVL delete(NodeAVL root, Tawjihe seat_number) {
        if (root == null) {
            return root;
        }

        if (seat_number.compareTo(root.getData()) < 0) {
            root.left = delete(root.left, seat_number);
        } else if (seat_number.compareTo(root.getData()) > 0) {
            root.right = delete(root.right, seat_number);
        } else {
            if (root.left == null || root.right == null) {
                NodeAVL temp = root.left != null ? root.left : root.right;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                NodeAVL temp = minValueNode(root.right);

                root.getData().equals(temp.getData())  ;

                root.right = delete(root.right, temp.getData());
            }
        }

        if (root == null) {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getHeightDifference(root);

        if (balance > 1 && getHeightDifference(root.left) >= 0) {
            return rightRotate(root);
        }

        if (balance > 1 && getHeightDifference(root.left) < 0) {
            root.left = liftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getHeightDifference(root.right) <= 0) {
            return liftRotate(root);
        }

        if (balance < -1 && getHeightDifference(root.right) > 0) {
            root.right = rightRotate(root.right);
            return liftRotate(root);
        }

        return root;
    }
    void levelOrder() {
        Queue<NodeAVL> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeAVL current = queue.poll();
            System.out.print(current.getData() + " ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }
}
