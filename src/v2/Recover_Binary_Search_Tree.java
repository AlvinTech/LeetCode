/*  Recover Binary Search Tree
map[1] 第一个出现问题的值 map[2] 第二个出现问题的值 map[3] 当前节点的前序
相对于一个中序遍历来说 可能出现的交换有2种 相邻2个交换，不相邻交换；
所以出现 i >i=1 时 需要先提前记录 i 和i+1;的位置 ，因为你无法判断是上面两种情况中的哪一种。
如果再次出现 这可以判定map[2] 需要被替换。
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class Recover_Binary_Search_Tree{
    private Map<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
    boolean flag = false;
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        searchTree(list,root);


        int temp = map.get(1).val;
        map.get(1).val = map.get(2).val;
        map.get(2).val = temp;


    }
    public void searchTree(List<TreeNode>list, TreeNode node){
        if(node == null)
            return ;
        searchTree(list,node.left);
        if(!map.containsKey(3))
            map.put(3, node);

        if(node.val < map.get(3).val){
            if(!flag){
                flag = true;
                map.put(1, map.get(3));
                map.put(2, node);
            }else
                map.put(2, node);
        }
        searchTree(list,node.right);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        root.left= a;
        //a.left = b;
        new Recover_Binary_Search_Tree().recoverTree(root);
        System.out.println(root);
    }
}