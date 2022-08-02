package com.example.yandex.demo.simple;

import com.example.yandex.demo.sorting.impl.effective.QuickSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;

@SpringBootTest
class QuickSortServiceTest {

    private final QuickSortService quickSortService;

    @Autowired
    public QuickSortServiceTest(QuickSortService quickSortService) {
        this.quickSortService = quickSortService;
    }

    @Test
    void selectionEmptyList() {
        final int[] list = new int[0];
        final int[] sort = quickSortService.sort(list);
        Assert.isTrue(sort.length == 0, "");
    }

    @Test
    void selectionSortedValues() {
        final int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8};
        final int[] sort = quickSortService.sort(list);
        Assert.isTrue(Arrays.equals(list, sort), "");
    }

    @Test
    void selectionRevertValues() {
        final int[] list = new int[]{8, 8, 7, 6, 5, 4, 3, 2, 1};
        final int[] sort = quickSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}), "");
    }

    @Test
    void selectionSingleValue() {
        final int[] list = new int[]{8};
        final int[] sort = quickSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{8}), "");
    }

    @Test
    void selectionTwoValue() {
        final int[] list = new int[]{8, 1};
        final int[] list2 = new int[]{1, 8};
        final int[] sort = quickSortService.sort(list);
        final int[] sort2 = quickSortService.sort(list2);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 8}), "");
        Assert.isTrue(Arrays.equals(sort2, new int[]{1, 8}), "");
    }

}