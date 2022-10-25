// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
 

// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        for(int var : map.values())
            pq.add(var);
        
        while(k-->0){
            int x = pq.poll();
                    for(int var : map.keySet()){    // this is easy way to get key but time complexity is bad
                        if(map.get(var)==x)
                            res[k]=var;
                    }
                    map.remove(res[k]);
            // res[k]=getkey(map, x);               // time complexity is better
            // map.remove(getkey(map, x));
        }
        return res;
    }
    
                        // Function to get KEY value from VALUE of the HashMap 
    public static Integer getkey(Map<Integer, Integer> map, Integer value){     
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(value.equals(entry.getValue()))
                return entry.getKey();
        }
        return null;
    }
}
