import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC: O(row-1 * col) as a the traversing is done from n-1 row to 0 and all columns
// SC: O(1) as no extra data structure is used

// Runs successfully on leetcode
// I went bottom up but top down approach is also okay. 
// Adding the minimum from one of the two childs in current and moving above.
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int current = triangle.get(i).get(j);
                triangle.get(i).set(j, current + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
