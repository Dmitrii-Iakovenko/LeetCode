package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution2181 {

    public static void main(String[] args) {
//        int[] arr = {0, 3, 1, 0, 4, 5, 2, 0};
        int[] arr = {0,1,0,3,0,2,2,0};
        ListNode head = arrayToListNode(arr);
        print(head);
        head = mergeNodes(head);
        print(head);
    }

    public static ListNode arrayToListNode(int[] arr) {
        ListNode head = new ListNode(arr[arr.length-1]);
        for (int i = arr.length-2; i >= 0; i--) {
            head = new ListNode(arr[i], head);
        }
        return head;
    }

    public static void print(ListNode head) {
        System.out.print("[");;
        while (true) {
            System.out.print(head.val);
            if (head.next == null)
                break;
            head = head.next;
            System.out.print(", ");
        }
        System.out.println("]");;
    }

    // solution
    public static ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode current = result;
        int sum = 0;
        head = head.next;
        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            }
            else {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            }
            head = head.next;
        }
        return result.next;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

