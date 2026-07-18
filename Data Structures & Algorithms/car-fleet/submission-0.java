class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // [7, 4, 1, 0] -> first to reach target is the max one since the rest need to overtake
        // [1, 2, 2, 1] -> speed
        // [3, 3, 4.5, 10] -> time to reach target

        // [10, 8, 5, 3, 0]
        // [2, 4, 1, 3, 1]
        // [1, 1, 7, 1, 12] ->
        // map
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Stack<Double> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            double timeTaken = (double) (target - cars[i][0]) / cars[i][1];
            if(st.isEmpty() || timeTaken > st.peek()) {
                st.push(timeTaken);
            }
            
        }
        return st.size();    
    }
}
