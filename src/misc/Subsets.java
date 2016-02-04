package misc;

import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        // Sort first, as required.
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        // Add an empty set first.
        lists.add(new ArrayList<>());
        // For each possible length of subsets, we do DFS and Backtracking.
        for (int len = 1; len <= nums.length; len++) {
            dfs(new ArrayList<>(), 0, len, nums, lists);
        }
        return lists;
    }

    private static void dfs(List<Integer> cur, int start, int len, int[] nums, List<List<Integer>> lists) {
        if (cur.size() == len) {
            // If we've already got enough elements, we stop.
            lists.add(new ArrayList<>(cur));
            return;
        }
        // Do backtracking from current start point.
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(cur, i + 1, len, nums, lists);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String [] args){

        int [] nums = {1,2,3};

        for(List<Integer> set : subsets(nums)){
            System.out.println("Set: " );
            for(Integer i : set){
                System.out.print(i + ",");
            }

            System.out.println("");

        }
    }
}
