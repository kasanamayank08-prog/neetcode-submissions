class Solution {
    public boolean hasDuplicate(int[] nums) {
          HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }

            seen.add(num);
        }

        return false;
    }
}