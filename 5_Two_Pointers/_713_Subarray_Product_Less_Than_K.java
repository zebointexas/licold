class Solution {
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if (k == 0 || k == 1) return 0;
        
        int count = 0;
        int pro = 1;
        
        // 两个指针
        for (int i = 0, j = 0; j < nums.length; j++) {
            
            pro *= nums[j];
            
            while (i <= j && pro >= k) {
                
                pro /= nums[i++];
                
            }
            
            count += j - i + 1;
        }
        
        return count;   
        
    }
}