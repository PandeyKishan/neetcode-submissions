class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // HashSet<Integer> set = new HashSet<>();
        // int[] result = new int[];
        // int windowMax = 0;

        // int left = 0, right;

        // for(right = 0; right < k; right++) {
        //     windowMax = Math.max(windowMax, nums[right]);
        // }

        // int i = 0;

        // result[i++] = windowMax;
        // left++; 

        // int windowSize = 0;

        // while(right < nums.length) {
        //     while(windowSize < k) {
        //         windowMax = Math.max(windowMax, nums[right]);
        //         right++;
        //         windowSize++;
        //     }
        //     if(windowSize > k) {
        //         left++;
        //         if(left =)
        //     }
        // }

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove all smaller (or equal) elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Record the maximum once the first window is complete
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}
