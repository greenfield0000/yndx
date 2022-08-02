package com.example.yandex.demo.bubble;

import com.example.yandex.demo.sorting.impl.bubble.ShakerSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 *
 * @author Ivanov Roman
 */
@SpringBootTest
class ShakerSortTest {

    private final ShakerSortService shakerSortService;

    @Autowired
    public ShakerSortTest(ShakerSortService shakerSortService) {
        this.shakerSortService = shakerSortService;
    }

    @Test
    void shakerEmptyList() {
        final int[] list = new int[0];
        final int[] sort = shakerSortService.sort(list);
        Assert.isTrue(sort.length == 0, "");
    }

    @Test
    void shakerSortedValues() {
        final int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8};
        final int[] sort = shakerSortService.sort(list);
        Assert.isTrue(Arrays.equals(list, sort), "");
    }

    @Test
    void shakerRevertValues() {
        final int[] list = new int[]{8, 8, 7, 6, 5, 4, 3, 2, 1};
        final int[] sort = shakerSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}), "");
    }

    @Test
    void shakerSingleValue() {
        final int[] list = new int[]{8};
        final int[] sort = shakerSortService.sort(list);
        Assert.isTrue(Arrays.equals(sort, new int[]{8}), "");
    }

    @Test
    void shakerTwoValue() {
        final int[] list = new int[]{8, 1};
        final int[] list2 = new int[]{1, 8};
        final int[] sort = shakerSortService.sort(list);
        final int[] sort2 = shakerSortService.sort(list2);
        Assert.isTrue(Arrays.equals(sort, new int[]{1, 8}), "");
        Assert.isTrue(Arrays.equals(sort2, new int[]{1, 8}), "");
    }

}
