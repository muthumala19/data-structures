package org.example.heap;

import java.util.ArrayList;

public class MaxHeap implements Heap {
    private final ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void maxHeapifyDown(int index) {
        if (index < 0 || index >= heap.size()) {
            return;
        }

        int largest = index;

        int left = 2 * index + 1; // Left child index
        int right = 2 * index + 2; // Right child index

        // Compare with left child (ensure index is within bounds)
        if (left < heap.size() && heap.get(index) < heap.get(left)) {
            largest = left;
        }

        // Compare with right child (ensure index is within bounds)
        if (right < heap.size() && heap.get(largest) < heap.get(right)) {
            largest = right;
        }

        // If the largest is not the root, swap and heapify the affected subtree
        if (largest != index) {
            int temp = heap.get(largest);
            heap.set(largest, heap.get(index));
            heap.set(index, temp);

            // Recursively heapify the affected subtree
            maxHeapifyDown(largest);
        }
    }

    private void maxHeapifyUp(int index) {
        if (index <= 0) {
            return; // The root has no parent to compare with
        }

        int parent = (index - 1) / 2;

        if (heap.get(parent) < heap.get(index)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, temp);
            maxHeapifyUp(parent);
        }
    }

    @Override
    public void insert(int value) {
        heap.add(value); // Add value to the end of the heap
        maxHeapifyUp(heap.size() - 1); // Heapify from the last index (new element)
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
            maxHeapifyDown(index);
            maxHeapifyUp(index); // Handles edge cases where upward adjustment is needed
        }
    }

    @Override
    public int getSize() {
        return heap.size();
    }
}
