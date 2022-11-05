// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
// Note: The flattened list will be printed using the bottom pointer instead of next pointer. For more clearity have a look at the printList() function in the driver code.

 

// Example 1:

// Input:
// 5 -> 10 -> 19 -> 28
// |     |     |     | 
// 7     20    22   35
// |           |     | 
// 8          50    40
// |                 | 
// 30               45
// Output:  5-> 7-> 8- > 10 -> 19-> 20->
// 22-> 28-> 30-> 35-> 40-> 45-> 50.
// Explanation:
// The resultant linked lists has every 
// node in a single level.
// (Note: | represents the bottom pointer.)
 

// Example 2:

// Input:
// 5 -> 10 -> 19 -> 28
// |          |                
// 7          22   
// |          |                 
// 8          50 
// |                           
// 30              
// Output: 5->7->8->10->19->22->28->30->50
// Explanation:
// The resultant linked lists has every
// node in a single level.

// (Note: | represents the bottom pointer.)
 

// Your Task:
// You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter and returns the head of flattened link list.


class GfG
{
    Node flatten(Node root)
    {
        if(root==null)
            return null;
	
	    ArrayList<Integer> list = new ArrayList<>();
	    Node curr = root;
	    while(curr != null){
	        list.add(curr.data);
	        if(curr.bottom!=null){
	            Node bt = curr;
    	        while(bt.bottom!=null){
    	            list.add(bt.bottom.data);
    	            bt = bt.bottom;
    	        }
	        }

	        curr = curr.next;
	    }
	    
	    Collections.sort(list);
	    Node dummy = new Node(0);
	    Node temp = dummy;
  
	    for(int i=0; i<list.size(); i++){
	        Node node = new Node(list.get(i));
	        temp.bottom = node;
	        temp = temp.bottom;
	    }
	
	    return dummy.bottom;
    }
}
