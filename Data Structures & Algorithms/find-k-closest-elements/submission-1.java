class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int start = 0, end = n-1;
        while (k < end - start+1){
            if (Math.abs(x-arr[start])>Math.abs(x-arr[end]))
                start++;
            else
                end--;
        }
        System.out.println(start+" "+end);
        List<Integer> ans = new ArrayList<>();
        for (; start <= end; start++)
            ans.add(arr[start]);
        return ans;
    }
}