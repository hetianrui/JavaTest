class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int count = 0;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target == nums[mid]) {
                i = mid;
                count++;
                break;
            }
        }
        int k = i - 1;
        while (k >= 0 && nums[k--] == target) {
            count++;
        }
        k = i + 1;
        while (k < nums.length && nums[k++] == target) {
            count++;
        }
        return count;
    }

}
