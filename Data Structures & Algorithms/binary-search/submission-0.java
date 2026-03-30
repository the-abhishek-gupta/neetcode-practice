class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            System.out.println("start "+start+" end "+end+" mid "+mid);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid]< target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}
