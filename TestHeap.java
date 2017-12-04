package test.havb.datastruct.tree;

import com.havb.datastruct.tree.Heap;
import com.havb.datastruct.tree.HeapNode;
import java.util.Comparator;

public class TestHeap {
    private Heap heap;

    public TestHeap(Heap heap) {
       this.heap = heap;
    }
    
    
    private void show(String string) {
        System.out.println("**" + string + "**");
        showx("root: ", heap.getRoot(), 0);
    }

    private void show(String string, HeapNode root, int x) {
        x++;
        if (root != null) {
            show("left", root.getLeft(), x);
            System.out.println(x + " : " + string + ":" + root.getInfo());
            show("right:", root.getRight(), x);
        } else {
            return;
        }
    }

    private void showx(String string, HeapNode root, int x) {
        x++;
        if (root != null) {
            showlevel(root);
            showx("l>", root.getLeft(), x);
            showx("r>", root.getRight(), x);
        } else {
            return;
        }
    }

    private void showlevel(HeapNode<Integer> root) {
        System.out.println((root.getLeft() != null ? root.getLeft().getInfo() : "null") + " - ["
                + (root != null ? root.getInfo() : "null")+ "] - "  
                + (root.getRight() != null ? root.getRight().getInfo() : "null"));
    }

    public static void main(String[] args) {
        
        Heap<Integer> heap = new Heap(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] values = {13, 2, 12, 0, 123, 32, 77, 134, 99, 8, 1, 3, 37, 17, 21, 11, 49, 68, 69, 221, 111, 22};

        for (int i = 10; i < values.length; i++) {
            for (int j = 0; j < i; j++) {
                heap.put(values[j]);
            }
            int count = 0;
            while (!heap.isEmpty()) {
                System.out.println("count : " + count + "<" + heap.get() + ">");
                count++;
            }
            System.out.println(i + ":" + count + " > " + (count == i ? "OK" : "ERROR"));
        }
    }
}
