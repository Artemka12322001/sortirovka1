package com.company;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


class art {

    public static StringBuffer sortByFrequency(int arr1[], int l1) {


        Map<Integer, Integer> countMap = getCountMap(arr1, l1);

        StringBuffer result = new StringBuffer();



        countMap.entrySet().stream()

                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())

                .forEach(e -> {

                    int key = e.getKey();

                    int val = e.getValue();

                    for (int i = 0; i < val; i++) {

                        result.append(key + " ");

                    }

                });

        return result;

    }


    private static Map<Integer, Integer> getCountMap(int[] arr, int l1) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < l1; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        return countMap;
    }


    public static void main(String[] args) throws IOException {

        int a[] = {4, 7, 1, 7, 2, 99, 4, 4, 1, 9};

        System.out.println(sortByFrequency(a, a.length));
    }

}
