class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        rotate(nums, 0, n - k-1);
        rotate(nums, n - k, n-1);
        rotate(nums, 0, n-1);
    }
    void rotate(int[] arr, int start, int end){
        while (start < end){
            System.out.println(start+" "+end);
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int each : arr)
            System.out.print(each+" ");

        System.out.println();

    }
}