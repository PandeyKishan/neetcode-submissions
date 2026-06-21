class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        product[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }

        // 1 1 2 8

        int suffixProduct = 1;

        for(int i = n - 1; i >= 0; i--) {
            product[i] = product[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }

        return product;
    }
}  
