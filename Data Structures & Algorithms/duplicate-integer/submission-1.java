class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) {
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;     
    }
}