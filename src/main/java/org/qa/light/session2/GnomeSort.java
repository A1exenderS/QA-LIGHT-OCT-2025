package org.qa.light.session2;

import java.util.Random;

//TODO: Write bubble sort

public class GnomeSort {

    public static void main(String[] args) {
        /*
            1. Сортування завершено коли гном на останньому елементі масиву
            2. Якщо гном на першому (індекс 0) елементі масиву - робимо крок вперед
            3. Якщо попередній та поточний елемент не в правильному порядку
            - поміняти їх місцями та крок назад
         */

        int[] sortable = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < sortable.length; i++) {
            sortable[i] = rand.nextInt(1000);
        }

        for (int i = 0; i < sortable.length; ) {
            if (i == 0) {
                i++;
            }
            if (i != 0) {
                int previous = i - 1;
                int current = i;
                if (sortable[current] < sortable[previous]) {
                    int prevVal = sortable[previous];
                    sortable[previous] = sortable[current];
                    sortable[current] = prevVal;
                    i--;
                } else {
                    i++;
                }
            }
        }

        for (int i : sortable) {
            System.out.println(i);
        }
        System.out.println("END");
    }
}
