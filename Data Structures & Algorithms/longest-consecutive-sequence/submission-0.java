class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int currLength = 0, maxLength = 0;

        for(int num: set) {
            if(!set.contains(num - 1)) {
                int currentNum = num;
                currLength = 1;
                while(set.contains(currentNum + 1)) {
                    currLength++;
                    currentNum++;
                }
            }
            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
