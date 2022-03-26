package solution;

import java.util.Arrays;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution1748 {

    public static void main(String[] args) {
//		int[] nums = {1, 2, 3, 2};
//		int[] nums = {1,1,1,1,1};
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(sumOfUnique(nums));

    }

    public static int sumOfUnique(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(groupingBy(identity(), counting())).entrySet().stream()
            .filter(entrySet -> entrySet.getValue() == 1)
            .mapToInt(Map.Entry::getKey)
            .sum();
    }

}
