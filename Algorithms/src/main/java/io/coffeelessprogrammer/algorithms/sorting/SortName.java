package io.coffeelessprogrammer.algorithms.sorting;

public enum SortName {
    INSERTION_SORT("Insertion Sort"),
    MERGE_SORT("Merge Sort"),
    QUICKSORT("Quicksort");


    private final String sortName;

    SortName(String sortName) { this.sortName = sortName; }

    public final String toString() { return this.sortName; }
}
