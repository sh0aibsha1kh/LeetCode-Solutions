import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] pair : prerequisites) {
            if (adjacencyList.containsKey(pair[0])) {
                adjacencyList.get(pair[0]).add(pair[1]);
            } else {
                List<Integer> neighbours = new ArrayList<>();
                neighbours.add(pair[1]);
                adjacencyList.put(pair[0], neighbours);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}