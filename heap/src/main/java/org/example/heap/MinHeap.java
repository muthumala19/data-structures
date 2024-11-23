package org.example.heap;

import java.util.ArrayList;

public class MinHeap implements Heap {
    private final ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private void minHeapifyDown(int index) {
        if (index < 0 || index >= heap.size()) {
            return;
        }

        int smallest = index;

        int left = 2 * index + 1; // Left child index
        int right = 2 * index + 2; // Right child index

        // Compare with left child (ensure index is within bounds)
        if (left < heap.size() && heap.get(index) > heap.get(left)) {
            smallest = left;
        }

        // Compare with right child (ensure index is within bounds)
        if (right < heap.size() && heap.get(smallest) > heap.get(right)) {
            smallest = right;
        }

        // If the largest is not the root, swap and heapify the affected subtree
        if (smallest != index) {
            int temp = heap.get(smallest);
            heap.set(smallest, heap.get(index));
            heap.set(index, temp);

            // Recursively heapify the affected subtree
            minHeapifyDown(smallest);
        }
    }

    private void minHeapifyUp(int index) {
        if (index <= 0) {
            return;
        }

        int parent = (index - 1) / 2;

        if (heap.get(parent) > heap.get(index)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, temp);
            minHeapifyUp(parent);
        }
    }

    @Override
    public void insert(int value) {
        heap.add(value);
        minHeapifyUp(heap.size() - 1);
    }

    @Override
    public void delete(int value) {
        int index = heap.indexOf(value);
        if (index == -1) {
            return; // Value not found
        }

        // Replace the value to be deleted with the last element
        int lastIndex = heap.size() - 1;
        if (index != lastIndex) {
            heap.set(index, heap.get(lastIndex));
        }
        heap.remove(lastIndex); // Remove the last element

        // Restore the max heap property
        if (index < heap.size()) {
            minHeapifyDown(index);
            minHeapifyUp(index); // Handles edge cases where upward adjustment is needed
        }
    }

    @Override
    public int getSize() {
        return heap.size();
    }
}
