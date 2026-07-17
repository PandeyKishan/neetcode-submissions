class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Arrays.sort(piles); // 1 2 3 4
        // 4 10 23 25
        // int start;
        // int max = piles[piles.length - 1]; 
        // int minSpeed = 0;
        // while(start <= max) {
        //     int mid = start + (max - start) / 2;
        //     int totalTime = 0;
        //     for(int i = 0; i < piles.length; i++) {
        //         int add = Math.ceil((double) piles[i] / mid);
        //         totalTime = totalTime + add; 
        //     }
        //     if(totalTime > h) {
        //         start = mid + 1;
        //     } else {
        //         max = mid - 1;
        //         minSpeed = mid;
        //     }
        // }

        // return minSpeed;

    int start = 1;
    int max = 0;
    for (int pile : piles) {
        max = Math.max(max, pile);
    }
    
    int minSpeed = max; 
    
    while(start <= max) {
        int mid = start + (max - start) / 2;
        int totalTime = 0;
        
        for(int i = 0; i < piles.length; i++) {
            // Equivalent to Math.ceil but uses fast integer division
            totalTime += (piles[i] + mid - 1) / mid;
        }
        
        if(totalTime > h) {
            start = mid + 1; // Speed is too slow
        } else {
            max = mid - 1;   // Speed works, try for a slower one
            // minSpeed = mid;
            minSpeed = Math.min(minSpeed, mid);
        }
    }
        return minSpeed;
    }
}
