/**   Convert Sorted List to Binary Search Tree
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
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

        int mid = v.size() /2;
        TreeNode root = new TreeNode(v.get(mid));
        vectorToTree(root,v,0,mid-1,true);
        vectorToTree(root,v,mid+1,v.size()-1,false);

        return root;

    }

    public void vectorToTree(TreeNode parent,Vector<Integer> v,int sta, int end,boolean falg){
        if(sta > end){
            return ;
        }
        else{
            int mid = (sta + end)/2;
            TreeNode node = new TreeNode(v.get(mid));
            if(falg)
                parent.left = node;
            else
                parent.right = node;
            vectorToTree(node,v,sta,mid-1,true);
            vectorToTree(node,v,mid+1,end,false);

        }
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
