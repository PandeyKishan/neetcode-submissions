class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double distanceA = Math.pow(a[0], 2) + Math.pow(a[1], 2);
            double distanceB = Math.pow(b[0], 2) + Math.pow(b[1], 2);
            return Double.compare(distanceB, distanceA);
        });

        for(int i = 0; i < points.length; i++) {
            pq.add(points[i]);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
