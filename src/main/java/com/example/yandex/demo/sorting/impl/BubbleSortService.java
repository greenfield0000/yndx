package com.example.yandex.demo.sorting.impl;

import com.example.yandex.demo.sorting.Sorted;
import org.springframework.stereotype.Service;

/**
 * Сортировка пузырьком
 * <p>
 * сложность алгоритма O(n^2)
 *
 *  Описание алгоритма: Бежит слева направо, сравнивает все числа с первым, меняет каждый раз, когда первое число больше,
 *  как дошло до конца, берет второе число, дальше берет третье, так до конца.
 *
 * @author Ivanov Roman
 */
@Service
public class BubbleSortService implements Sorted {

    @Override
    public int[] sort(int[] list) {
        final int length = list.length;
        for (int i = 0; i < length - 1; i++) {
            for (int k = 0; k < length - i - 1; k++) {
                if (list[k + 1] < list[k]) {
                    final int swap = list[k + 1];
                    list[k + 1] = list[k];
                    list[k] = swap;
                }
            }
        }
        return list;
    }

}
