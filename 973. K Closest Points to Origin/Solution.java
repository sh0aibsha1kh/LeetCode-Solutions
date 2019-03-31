import java.util.PriorityQueue;

class Solution {
    /**
     * Returns the K closest coordinates to the origin. Put all the coordinates into
     * a max heap of size K. Then, create a new array and load all of the elements
     * remaining in the heap into the array. Time Complexity: O(n log k)
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((int[] a, int[] b) -> {
            if (getDistance(a) < getDistance(b)) {
                return 1;
            } else if (getDistance(a) > getDistance(b)) {
                return -1;
            }
            return 0;
        });

        for (int[] point : points) {
            if (maxHeap.size() < K) {
                maxHeap.add(point);
            } else {
                if (getDistance(point) < getDistance(maxHeap.peek())) {
                    maxHeap.poll();
                    maxHeap.add(point);
                }
            }
        }

        int[][] closestPoints = new int[K][2];

        int i = 0;
        while (!maxHeap.isEmpty()) {
            closestPoints[i] = maxHeap.remove();
            i += 1;
        }

        return closestPoints;
    }

    private double getDistance(int[] coordinates) {
        return Math.sqrt(Math.pow(coordinates[0], 2) + Math.pow(coordinates[1], 2));
    }

    private String printAnswer(int[][] coordinates) {
        StringBuilder s = new StringBuilder();
        for (int[] c : coordinates) {
            s.append("[").append(c[0]).append(", ").append(c[1]).append("]\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] test1 = new int[][] { { 1, 3 }, { -2, 2 } };
        int[][] test2 = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        System.out.println(s.printAnswer(s.kClosest(test1, 1))); // [[-2, 2]]
        System.out.println(s.printAnswer(s.kClosest(test2, 2))); // [[-2, 4], [3, 3]]
    }
}