package com.example.yandex.demo.sorting.impl.simple;

import com.example.yandex.demo.sorting.Sorted;
import org.springframework.stereotype.Service;

/**
 * Простая сортировка. Сортировка выбором
 *
 * @author Ivanov Roman
 */
@Service
public class SelectionSortService implements Sorted {

    @Override
    public int[] sort(int[] list) {
        for (int i = 0; i <= list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k <= list.length - 1; k++) {
                if (list[k] < list[i]) {
                    minIndex = k;
                }
            }
            final int swap = list[i];
            list[i] = list[minIndex];
            list[minIndex] = swap;
        }
        return list;
    }

}
