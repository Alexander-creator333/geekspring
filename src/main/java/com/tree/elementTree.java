package com.tree;

import java.util.ArrayList;

public class elementTree {
    elementTree parent;
    ArrayList<elementTree> heirs = new ArrayList<>();
    int eNum;

    public elementTree(int eNum){
        parent = null;
        this.eNum  = eNum;
    }

    public elementTree addNew(int eNum)
    {
        tmp = new elementTree();
        tmp.eNum = eNum;
        tmp.parent = this;
        heirs.add(tmp);
        return tmp;
    }

    public void deleteThis()
    {
        for (int i = 0; i < heirs.size(); i++) {
            heirs.get(i).parent = null;
        }
    }
}
