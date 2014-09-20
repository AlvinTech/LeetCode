/* Sort List
* Sort a linked list in O(n log n) time using constant space complexity.
* */

//Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Sort_List {

    public ListNode sortList(ListNode head) {

        return ArrayToList(Merge(ListToArray(head)));

    }

    public int[] ListToArray(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        int[] list = new int[size];
        int i = 0;
        while (temp != null) {
            list[i] = temp.val;
            i++;
            temp = temp.next;
        }
        return list;
    }

    public ListNode ArrayToList(int[] list) {
        ListNode head = null;
        ListNode temp = new ListNode(0);
        head = temp;
        for (int i = 0; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
            temp.next = node;
            temp = node;
        }
        return head.next;
    }

    public int[] Merge(int[] list) {
        int length = list.length;
        if (length < 2)
            return list;

        int mid = length / 2;
        int[] listL = new int[mid];
        int[] listR = new int[length - mid];

        int l = 0;
        int r = 0;
        int index = 0;
        for (index = 0; index < length; index++) {
            if (index < mid) {
                listL[l] = list[index];
                l++;
            } else {
                listR[r] = list[index];
                r++;
            }
        }

        listL = Merge(listL);
        listR = Merge(listR);
        // printList();
        return MergeToList(listL, listR);

    }

    public int[] MergeToList(int[] listL, int[] listR) {
        int[] listNew = new int[listR.length + listL.length];
        int index = 0;
        int i = 0, j = 0;

        for (; i < listL.length && j < listL.length;)
            for (; j < listR.length && i < listL.length;) {
                if (listL[i] < listR[j]) {
                    listNew[index] = listL[i];
                    i++;
                    index++;
                } else {
                    listNew[index] = listR[j];
                    j++;
                    index++;

                }
            }
        if (i == listL.length) {
            for (; j < listR.length; j++) {
                listNew[index] = listR[j];
                index++;
            }
        } else if (j == listR.length) {
            for (; i < listL.length; i++) {
                listNew[index] = listL[i];
                index++;
            }
        }
        // printList(listNew);
        return listNew;

    }

    public static void printList(int[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();

    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        Sort_List s = new Sort_List();
        // int[] list= {5,4,3,2,1};
        // s.Merge(list);

        ListNode head = null;
        ListNode temp = new ListNode(0);
        head = temp;
        for (int i = 5; i > 0; i--) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = node;
        }
        s.sortList(head.next);
        // printList(s.sortList(head.next));
    }
}
