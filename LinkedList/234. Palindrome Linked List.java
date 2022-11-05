// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

// Example 1:


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false
 

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9

class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean isPal = false;
        Stack<Integer> stack = new Stack<>();
        
        ListNode curr = head;
        while(curr!=null){
            stack.push(curr.val);
            curr = curr.next;
        }
        
        while(head!=null){
            if(head.val != stack.pop()){
                isPal = false;
                break;}
            else 
                isPal = true;
            
            head = head.next;
        }
        return isPal;
    }
}
