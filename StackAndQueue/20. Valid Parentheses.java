// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            switch(c){
                case '(' : 
                    stack.push(c);
                    break;
                case '{' : 
                    stack.push(c);
                    break;
                case '[' : 
                    stack.push(c);
                    break;
                    
                            // checking the brackets from the stack now
                case ')' : 
                    if(stack.isEmpty() || stack.peek()!='(')
                        return false;
                    else
                        stack.pop();
                    break;
                case '}' : 
                    if(stack.empty() || stack.peek()!='{')
                        return false;
                    else
                        stack.pop();
                    break;
                case ']' : 
                    if(stack.empty() || stack.peek()!='[')
                        return false;
                    else
                        stack.pop();
                    break;
            }
            
        }
        return stack.empty();
    }
}