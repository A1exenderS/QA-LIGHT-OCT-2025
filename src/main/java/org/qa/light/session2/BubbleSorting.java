package org.qa.light.session2;

import java.util.Arrays;
import java.util.Random;

public class BubbleSorting {
    public static void main(String[] args) {

        int[] arr = new int[20];
        Random random = new Random();

        for(int k = 0; k < arr.length; k++){
            arr[k] = random.nextInt(500);
        }
        System.out.println("Initial array" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for(int x = 0; x < arr.length - 1 - i; x++){
                if (arr[x] > arr[x + 1]) {
                    int prevValue = arr[x + 1];
                    arr[x + 1] = arr[x];
                    arr[x] = prevValue;
                }
            }
            System.out.println("Current try " + i + " " + Arrays.toString(arr));
        }
    }
}
