package org.example;

import java.util.Scanner;

public class RemoveDuplicatesSum {

    public static int sumWithoutDuplicates(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                sum += arr[i];
            } else {
                arr[i] = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = sumWithoutDuplicates(arr);
        System.out.println(result);
    }
}