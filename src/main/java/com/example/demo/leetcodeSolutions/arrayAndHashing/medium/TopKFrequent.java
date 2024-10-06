package com.example.demo.leetcodeSolutions.arrayAndHashing.medium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Slf4j
public class TopKFrequent {

    // nums = [1,2,2,3,3,3], k =
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int[] finalArray;

        for (int i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] bucketArray = new List[nums.length + 1];

        for (int i = 0; i < bucketArray.length; i++) {
            bucketArray[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            bucketArray[entry.getValue()].add(entry.getKey());
        }

        List<Integer> resultList = new ArrayList<>();

        for (int i = bucketArray.length - 1; i > 0; i--) {
            resultList.addAll(bucketArray[i]);
        }

        return resultList.subList(0, k).stream().mapToInt(i -> i).toArray();
    }

    public int[] topKFrequentBucketSort(int nums[], int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // bucket sort
        List<Integer>[] bucketArary = new List[nums.length + 1];

        for (int i = 0; i < bucketArary.length; i++) {
            bucketArary[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            bucketArary[entry.getValue()].add(entry.getKey());
        }

        List<Integer> resutlList = new ArrayList<>();
        for (int i = bucketArary.length - 1; i >= 0 && resutlList.size() < k; i--) {
            if (!bucketArary[i].isEmpty()) {
                resutlList.addAll(bucketArary[i]);
            }
        }

        if (resutlList.size() > k) {
            resutlList = resutlList.subList(0, k);
        }

        return resutlList.stream().mapToInt(i -> i).toArray();
    }

    public int[] topKFrequentBucket(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket Sort
        // Initialize buckets array
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Fill the buckets
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        // Step 3: Collect top k frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (!buckets[i].isEmpty()) {
                result.addAll(buckets[i]);
            }
        }

        if (result.size() > k) {
            //            result.remove(result.lastIndexOf(result));
            result = result.subList(0, k - 1);
        }

        // Convert result list to array
        return result.stream().mapToInt(i -> i).toArray();
    }

    // time -> o(n), space -> o(n)
    public int[] topKFrequentMinHeap(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // a - b is min heap, b - a is max heap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] intArray = new int[k];
        log.info("Min Heap Size: " + minHeap.size());
        log.info("K Size: " + k);
        for (int i = 0; i < k; i++) {
            intArray[i] = minHeap.poll().getKey();
        }

        return intArray;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
