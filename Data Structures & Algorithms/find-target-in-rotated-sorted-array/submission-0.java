class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(nums[left] == target)
            return 0;
        else if(nums[right] == target) 
            return nums.length - 1;    

        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                if(target > nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
