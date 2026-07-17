class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;

        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Returning nums[left] ensures you always get the absolute minimum value at the exact point of convergence
        // i.e. left = right, so nums[right] works fine as well.
        return nums[left];
        // return nums[right];
    }
}
