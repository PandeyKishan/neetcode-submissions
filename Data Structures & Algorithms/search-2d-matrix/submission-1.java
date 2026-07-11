class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int index = 0;

        int[] list = new int[m * n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                list[index++] = matrix[i][j];
            }
        }
        
        int left = 0, right = list.length - 1;

        while(left <= right) {
            // Prevents integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;
            if(target == list[mid])
                return true;
            else if(target > list[mid])
                left = mid + 1;
            else
                right = mid - 1;    
        }

        return false;
    }
}
