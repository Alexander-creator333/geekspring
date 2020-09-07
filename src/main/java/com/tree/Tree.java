package com.tree;

public class Tree {
    public static void main(String[] args) {
        elementTree A,B,C;
        A = new elementTree(3);
        B = new elementTree(5);
        C = new elementTree(7);
        A.addNew(2).addNew(1);
        A.addNew(4).addNew(9);
        B.addNew(6);
        elementTree tmp = B.addNew(8);
        tmp.addNew(13);
        tmp.addNew(15);
        C.addNew(10);
        tmp = C.addNew(12);
        tmp.addNew(17);
        tmp.addNew(19);
        tmp.addNew(21);
    }
}


/*
* 3 - 2 - 1, 4 - 9
* 5 - 6,8 - 13,15
* 7 - 10,12 - 17,19,21
*
 */