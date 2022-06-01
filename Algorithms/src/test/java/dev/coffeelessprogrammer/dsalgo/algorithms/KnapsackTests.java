package dev.coffeelessprogrammer.dsalgo.algorithms;

import dev.coffeelessprogrammer.dsalgo.algorithms.dynamicprogramming.Knapsack;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnapsackTests {

    @Test
    @Disabled
    final void Knapsack_Capacity10() {
        assertEquals(16, Knapsack.fillKnapsack(10));
    }

    @Test
    final void Knapsack_ShowSteps() {
        assertEquals(16, Knapsack.showSteps(10));
    }
}
