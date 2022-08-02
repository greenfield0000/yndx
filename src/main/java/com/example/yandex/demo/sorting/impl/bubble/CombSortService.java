package com.example.yandex.demo.sorting.impl.bubble;

import com.example.yandex.demo.sorting.Sorted;
import org.springframework.stereotype.Service;

/**
 * @author Ivanov Roman
 */
@Service
public class CombSortService implements Sorted {

    @Override
    public int[] sort(int[] list) {
        int range = list.length - 1;
        int left = 0;
        int right = left + range;

        while (left <= right) {
            while (right <= list.length - 1) {
                // Меняем, если левое число, больше чем правое
                if (list[left] > list[right]) {
                    int swap = list[left];
                    list[left] = list[right];
                    list[right] = swap;
                }
                left++;
                right++;
            }
            left = 0;
            range -= 1;
            right = range;
        }

        return list;
    }

}
