class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        rot(nums, 0, n-k-1);
        rot(nums, 0, n-1);
        rot(nums, 0, k-1);
    }
    private void rot(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}