package com.example.yandex.demo.sorting.impl.simple;

import com.example.yandex.demo.sorting.Sorted;
import org.springframework.stereotype.Service;

/**
 * Простая сортировка. Сортировка вставками
 *
 * @author Ivanov Roman
 */
@Service
public class InsertSortService implements Sorted {
    @Override
    public int[] sort(int[] list) {
        for (int i = 1; i < list.length; ++i) {
            final int val = list[i];
            int cursor = i;
            while (cursor > 0 && list[cursor - 1] > val) {
                list[cursor] = list[cursor - 1];
                cursor--;
            }
            list[cursor] = val;
        }
        return list;
    }
}
