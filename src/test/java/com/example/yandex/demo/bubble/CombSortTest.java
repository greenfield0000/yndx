package com.example.yandex.demo.bubble;

import com.example.yandex.demo.sorting.impl.bubble.CombSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author Ivanov Roman
 */
@SpringBootTest
class CombSortTest {

    private final CombSortService combSortService;

    @Autowired
    public CombSortTest(CombSortService combSortService) {
        this.combSortService = combSortService;
    }

    @Test
    void combEmptyList() {
        final int[] list = new int[0];
        final int[] sort = combSortService.sort(list);
        Assert.isTrue(sort.length == 0, "");
    }

    @Test
    void combSortedValues() {
        final int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8};
        final int[] sort = combSortService.sort(list);
        Assert.isTrue(Arrays.equals(list, sort), "");
    }

    @Test
    void combRevertValues() {
        final int[] list = new int[]{8, 8, 7, 6, 5, 4, 3, 2, 1};
        final int[] sort = combSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}), "");
    }

    @Test
    void combSingleValue() {
        final int[] list = new int[]{8};
        final int[] sort = combSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{8}), "");
    }

    @Test
    void combTwoValue() {
        final int[] list = new int[]{8, 1};
        final int[] list2 = new int[]{1, 8};
        final int[] sort = combSortService.sort(list);
        final int[] sort2 = combSortService.sort(list2);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 8}), "");
        Assert.isTrue(Arrays.equals(sort2, new int[]{1, 8}), "");
    }

}
