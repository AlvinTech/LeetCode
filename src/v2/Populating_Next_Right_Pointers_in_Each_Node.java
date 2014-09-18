/**  Populating Next Right Pointers in Each Node
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
public class Populating_Next_Right_Pointers_in_Each_Node {
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
            if(node != null && node.left != null){
                node.right.next = queue.element().left;
            }
            node = queue.remove();

            if(node.left != null){
                nextQ.add(node.left);
                nextQ.add(node.right);
                node.left.next = node.right;
            }
        }
        if(!nextQ.isEmpty())
            getNext(nextQ);
    }
}
