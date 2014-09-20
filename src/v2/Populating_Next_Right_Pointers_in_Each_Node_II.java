/**   Populating Next Right Pointers in Each Node II
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Populating_Next_Right_Pointers_in_Each_Node_II {
    public void connect(TreeLinkNode root) {
        if(root ==  null)
            return ;
        root.next = null;
        Queue<TreeLinkNode> queue = new LinkedBlockingQueue<TreeLinkNode>();
        queue.add(root);
        getNext(queue);
    }
    public void getNext(Queue<TreeLinkNode> queue){
        TreeLinkNode node = null;
        Queue<TreeLinkNode> nextQ = new LinkedBlockingQueue<TreeLinkNode>();
        while(!queue.isEmpty()){
            if(node == null){
                node = queue.remove();
            }else{
                node.next = queue.remove();
                node = node.next;
            }
            if(node.left != null){
                nextQ.add(node.left);
            }
            if(node.right != null){
                nextQ.add(node.right);
            }
        }
        if(!nextQ.isEmpty())
            getNext(nextQ);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //TreeLinkNode root = new TreeLinkNode(0);
        TreeLinkNode p1 = new TreeLinkNode(1);
        TreeLinkNode p2 = new TreeLinkNode(2);
        TreeLinkNode p3 = new TreeLinkNode(3);
        TreeLinkNode p4 = new TreeLinkNode(4);
        TreeLinkNode p5 = new TreeLinkNode(5);
        TreeLinkNode p6 = new TreeLinkNode(6);
        TreeLinkNode p7 = new TreeLinkNode(7);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;
        new Populating_Next_Right_Pointers_in_Each_Node_II().connect(p1);
    }

}

