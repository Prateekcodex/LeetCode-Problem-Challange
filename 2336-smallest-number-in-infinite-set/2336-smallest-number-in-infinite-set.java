import java.util.*;

class SmallestInfiniteSet {

    private int next = 1;
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    private HashSet<Integer> set = new HashSet<>();

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {

        if (!heap.isEmpty()) {
            int smallest = heap.poll();
            set.remove(smallest);
            return smallest;
        }

        return next++;
    }

    public void addBack(int num) {

        if (num < next && !set.contains(num)) {
            heap.offer(num);
            set.add(num);
        }
    }
}