class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int[] a1= new int[n];
        for (int i = 0; i < n; i++){
            a1[i] = Math.abs(x-arr[i]);
            System.out.print(a1[i]+" ");
        }
        int start = 0, end = n-1;
        while (k < end - start+1){
            if (a1[start]>a1[end])
                start++;
            else
                end--;
        }
        System.out.println();
        System.out.println(start+" "+end);
        List<Integer> ans = new ArrayList<>();
        for (; start <= end; start++)
            ans.add(arr[start]);
        return ans;
    }
}