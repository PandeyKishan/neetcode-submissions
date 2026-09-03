class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i: nums) {
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;     
    }
}