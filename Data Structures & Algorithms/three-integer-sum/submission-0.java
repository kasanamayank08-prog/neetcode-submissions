class Solution {
     public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Sort the array to use two-pointer technique and avoid duplicates
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println("Need at least 3 integers.");
            return;
        }

        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter integers only.");
                return;
            }
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> triplets = threeSum(nums);

        System.out.println("Unique triplets that sum to zero:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        sc.close();
    }
}