class Solution {
    public int trap(int[] height) {
        int maxTrap = 0, currTrap = 0;
        int left;

        for(left = 0; left < height.length; left++) {
            if(height[left] != 0)
                break;
        }

        int right = left + 1;

        while(right < height.length) {
            while(right < height.length && height[right] < height[left]) {
                currTrap += height[left] - height[right];
                right++;
            }
            if(right > height.length - 1) {
                currTrap = 0;
                return maxTrap;
            }
            maxTrap = maxTrap + currTrap;
            currTrap = 0;
            left = right;
            right = left + 1;        
        }

        return maxTrap;
    }
}
