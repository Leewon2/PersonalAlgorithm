import java.util.*;
class Solution {
    int[][] answer;
    int idx;
    public int[][] solution(int[][] nodeinfo) {
        Node[] arr = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            arr[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1,null,null);
        }
        Arrays.sort(arr, (o1,o2)->{
            if(o1.c==o2.c) return o1.r-o2.r;
            return o2.c-o1.c;
        });
        
        Node root = arr[0];
        for(int i=1; i<arr.length; i++){
            makeTree(root, arr[i]);
        }
        answer = new int[2][nodeinfo.length];
        idx=0;
        preorder(root);
        idx=0;
        postorder(root);
        
        
        return answer;
    }
    
    private void preorder(Node node){
        if(node!=null){
            answer[0][idx++] = node.value;
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    private void postorder(Node node){
        if(node!=null){
            postorder(node.left);
            postorder(node.right);
            answer[1][idx++] = node.value;
        }
    }
    
    private void makeTree(Node parent, Node child){
        if(parent.r > child.r){
            if(parent.left == null) parent.left = child;
            else makeTree(parent.left, child);
        }else{
            if(parent.right == null) parent.right = child;
            else makeTree(parent.right, child);
        }
    }
    
    
    private class Node{
        int r;
        int c;
        int value;
        Node left;
        Node right;
        public Node(int r, int c, int value, Node left, Node right){
            this.r=r;
            this.c=c;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
}