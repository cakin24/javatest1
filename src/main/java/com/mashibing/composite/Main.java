package com.mashibing.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * @author: Yuanzt
 * @Date: 2021/3/16
 */

abstract class Node{
    abstract void p();
}

class LeafNode extends Node{
    String content;

    public LeafNode(String content){ this.content = content ;}
    @Override
    void p() {System.out.println(content);}
}

class BranchNode extends Node{
    List<Node> nodes = new ArrayList<>();
    String name;

    public BranchNode(String name){this.name = name;}
    @Override
    void p() {System.out.println(name);}

    public void add(Node n){
        nodes.add(n);
    }
}

public class Main {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node cl1 = new LeafNode("cl1");
        Node cl2 = new LeafNode("cl2");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(cl1);
        chapter1.add(cl2);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root,0);
    }

    static void tree(Node b,int depth){
        for (int i=0;i<depth;i++) System.out.print("--");
        b.p();
        if (b instanceof  BranchNode){
            for (Node n:((BranchNode) b).nodes) tree(n,depth+1);
        }
    }
}
