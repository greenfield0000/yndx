package com.example.yandex.demo.sorting.impl;

import com.example.yandex.demo.sorting.Sorted;
import org.springframework.stereotype.Service;

/**
 * Шейкерная сортировка (сортировка перемешиванием)
 * <p>
 * Сложность алгоритма O(n^2) Является разновидностью пузырьковой сортировки
 * <p>
 * Описание алгоритма: Бежит слева направо, толкает самое большое в конец,
 * как перенесло его в конец, берет предпоследнее значение и идет в обратную сторону.
 *
 * @author Ivanov Roman
 */
@Service
public class ShakerSortService implements Sorted {

    @Override
    public int[] sort(int[] list) {
        int left = 0;
        int right = list.length - 1;
        do {
            for (int i = 0; i < right; i++) {
                if (list[i] > list[i + 1]) {
                    final int swap = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = swap;
                }
            }
            right--;
            for (int k = right; k > left; k--) {
                if (list[k - 1] > list[k]) {
                    final int swap = list[k];
                    list[k] = list[k - 1];
                    list[k - 1] = swap;
                }
            }
            left++;
        } while (left < right);
        return list;
    }

}
