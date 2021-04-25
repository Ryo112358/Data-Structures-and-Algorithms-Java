# Algorithms

## Core
- [ ] Recursion
- [ ] Dynamic Programming
- [ ] Comparison Sorting
  - [X] Merge Sort
  - [ ] Quicksort
  - [X] Insertion Sort
- [ ] Searching
  - [ ] Linear Search
  - [ ] Binary Search
  - [ ] Breadth First Search (BFS)
  - [ ] Depth First Search (DFS)

## Useful Java APIs

### System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
- Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.
```java
for(int i=1; i < elements.length; ++i) {
    currentElement = elements[i];

    for(int j=0; j < i; ++j) {
        if(currentElement < elements[j]) {

            // for(int k=i; k > j; --k)
            //     elements[k] = elements[k-1];
            System.arraycopy(elements, j, elements, j + 1, i - j);   // Equivalent of two lines above

            elements[j] = currentElement;
            break;
        }
    }
}
```