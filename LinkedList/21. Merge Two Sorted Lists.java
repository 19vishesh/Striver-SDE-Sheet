// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.

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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                ListNode node = new ListNode(list1.val);
                curr.next = node;
                list1 = list1.next;
            }else{
                ListNode node = new ListNode(list2.val);
                curr.next = node;
                list2 = list2.next;
            }
            curr = curr.next;            
        }
        while(list1!=null){
            ListNode node = new ListNode(list1.val);
            curr.next = node;
            list1 = list1.next;
            curr = curr.next;
        }
        while(list2!=null){
            ListNode node = new ListNode(list2.val);
            curr.next = node;
            list2 = list2.next;
            curr = curr.next;
        }
        return res.next;
    }
}
