class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            // Prevents integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;    
        }

        return -1;
    }
}
