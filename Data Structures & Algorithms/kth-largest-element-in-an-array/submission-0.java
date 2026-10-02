class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int count = 0;
        int result = 0;
        while(count < k) {
            result = pq.poll();
            count++;
        }
        return result;
    }
}
