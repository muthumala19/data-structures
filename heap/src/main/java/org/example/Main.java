package org.example;

import org.example.heap.Heap;
import org.example.heap.MaxHeap;
import org.example.heap.MinHeap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Heap minHeap = new MinHeap();
        Heap maxHeap = new MaxHeap();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int value1 = random.nextInt(1001);
            int value2 = random.nextInt(1001);

            minHeap.insert(value1);
            maxHeap.insert(value2);
        }

        for (int i = 0; i < 100; i++) {
            int value1 = random.nextInt(1001);
            int value2 = random.nextInt(1001);

            minHeap.delete(value1);
            maxHeap.delete(value2);
        }

        System.out.println(minHeap.getSize());
        System.out.println(maxHeap.getSize());
    }
}