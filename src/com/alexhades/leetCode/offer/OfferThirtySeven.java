package com.alexhades.leetCode.offer;

import com.alexhades.leetCode.base.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class OfferThirtySeven {


    @Test
    public void fn() {
        OfferThirtySeven codec = new OfferThirtySeven();
        TreeNode treeNode = codec.deserialize("[1,2,3,null,null,4,5,null,null,null,null]");
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "[]";
        }
        StringBuilder res=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current!=null){
                res.append(current.val).append(",");
                queue.offer(current.left);
                queue.offer(current.right);
            }else {
                res.append("null,");
            }
        }
        return res.deleteCharAt(res.length()-1).append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] arr = data.substring(1, data.length() - 1).split(",");
        TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int ind = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!arr[ind].equals( "null")) {
                poll.left  = new TreeNode(Integer.parseInt(arr[ind]));
                queue.offer(poll.left );
            }
            ind++;
            if (!arr[ind].equals( "null")) {
                poll.right= new TreeNode(Integer.parseInt(arr[ind]));
                queue.offer(poll.right);
            }
            ind++;
        }
        return head;
    }
}
