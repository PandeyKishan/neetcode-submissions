class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] list = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(!map.containsKey(complement)) {
                map.put(nums[i], i);
            } else {
                list[0] = map.get(complement);
                list[1] = i;
            }
        }

        return list;
    }
}
