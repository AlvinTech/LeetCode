/**   Convert Sorted List to Binary Search Tree
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
package com.alvin.java;
import java.util.Vector;

public class Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head ==null)
            return null;
        //convet to a array;
        Vector<Integer> v = new Vector<Integer>();
        while(head != null){
            v.add(head.val);
            head = head.next;
        }
        return buildTree(v ,0, v.size()-1);
    }
    public TreeNode buildTree(Vector<Integer> v ,int sta, int end){
        if(end - sta < 0 )
            return null;
        int mid = (sta + end)/2;
        TreeNode node = new TreeNode(v.get(mid));
        node.left = buildTree(v,sta,mid-1);
        node.right = buildTree(v,mid+1,end);
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode root = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        new Convert_Sorted_List_to_Binary_Search_Tree().sortedListToBST(root);

    }
}
