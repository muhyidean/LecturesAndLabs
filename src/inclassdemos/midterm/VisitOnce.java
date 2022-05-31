package inclassdemos.midterm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VisitOnce {

    static class Node{
        int id;
        List<Node> children;

        public Node(int id, List<Node> children) {
            this.id = id;
            this.children = children;
        }

    }
    public static void main(String[] args) {

        Node n5 = new Node(5,null);
        Node n3 = new Node(3,null);
        Node n4 = new Node(4,null);
        List<Node> n2Children = new ArrayList<>();
        n2Children.add(n3);
        n2Children.add(n5);
        Node n2 = new Node(2, n2Children);
        List<Node> n1Children = new ArrayList<>();
        n1Children.add(n2);
        n1Children.add(n4);
        Node n1 = new Node(1,n1Children);

        visitOnceBFS(n1);

    }

    public static void visitOnceDFS(Node node){
        System.out.print(node.id); // 1
        if(node.children == null)
            return;


        for(int i = 0 ; i<node.children.size() ; i++){
            visitOnceDFS(node.children.get(i));
        }
    }

    public static void visitOnceBFS(Node node){
        System.out.print(node.id); // 1

        if(node.children == null)
            return;

        for(int i = 0 ; i<node.children.size() ; i++){
            visitOnceBFS(node.children.get(i));
        }



    }
}
