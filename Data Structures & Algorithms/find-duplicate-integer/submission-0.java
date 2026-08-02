class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        // find intersection index, might be same or different index
        // fast moves twice, slow moves once
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];

        // find duplicate
        // both fast and slow move once
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
