package com.example.yandex.demo.sorting.impl.effective;

import com.example.yandex.demo.sorting.Sorted;
import org.springframework.stereotype.Service;

/**
 * Быстрая сортировка
 *
 * @author Ivanov Roman
 */
@Service
public class QuickSortService implements Sorted {

    @Override
    public int[] sort(int[] list) {
        return sort(list, 0, list.length - 1);
    }

    private int[] sort(int[] list, int left, int right) {
        if (left < right) {
            // ищем опорный индекс для массива
            int bearing = getBearing(list, left, right);
            sort(list, left, bearing - 1);
            sort(list, bearing + 1, right);
        }
        return list;
    }

    private int getBearing(int[] list, int left, int right) {
        int val = list[right];
        int cursor = left;

        for (int i = left; i < right; i++) {
            if (list[i] <= val) {
                swap(list, cursor, i);
                ++cursor;
            }
        }
        swap(list, cursor, right);
        return cursor;
    }

    private void swap(int[] list, int indx1, int indx2) {
        final int swap = list[indx1];
        list[indx1] = list[indx2];
        list[indx2] = swap;
    }

}
