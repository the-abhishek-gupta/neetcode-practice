class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return nums;
        int mid = n/2;
        int[] left = sortArray(getArr(nums,0, mid-1));
        int[] right = sortArray(getArr(nums,mid, n-1));
        return merge(left, right);
    }
    int[] getArr(int[] arr, int start, int end){
        int n = end - start + 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = arr[start++];
        return res;
    }
    int[] merge(int[] a, int[] b){
        int m = a.length ;
        int n = b.length;
        int[] res = new int[m+n];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n){
            if (a[i] < b[j])
                res[index++] = a[i++];
            else
                res[index++] = b[j++];
        }while (i < m ){
            res[index++] = a[i++];
        } 
        while (j < n){
            res[index++] = b[j++];
        }  
        return res;
    }
}