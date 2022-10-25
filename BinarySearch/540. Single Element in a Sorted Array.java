// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

 

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
            // Base conditions
        if(hi==lo)        // for empty Array
            return nums[0];
        else if(nums[lo]!=nums[lo+1])   // if first 2 element not equals we'll get the ans right away
            return nums[lo];
        else if(nums[hi]!=nums[hi-1])   // if last 2 element not equals we'll get the ans right away
            return nums[hi];
        
        
            // Using Binary-search Approach
        while(lo<=hi){
            int mid = (lo + hi) / 2;
            
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            
            if(( mid%2== 0 && nums[mid]==nums[mid+1] ) || ( mid%2 == 1 && nums[mid]==nums[mid-1] ))
                lo = mid+1;
            else
                hi = mid-1;
        }
        return -1;  // if not found ans return -1        
    }
}
