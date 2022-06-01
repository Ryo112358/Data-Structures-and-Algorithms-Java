package dev.coffeelessprogrammer.dsalgo.playground;

import dev.coffeelessprogrammer.dsalgo.utility.ColorArray;
import dev.coffeelessprogrammer.dsalgo.utility.ConsoleColor;

import java.util.Arrays;

public class HelloPlayground {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Playground!\n");

//        testHighlightArrayElements();
//        testTerminalAnimation();
//        testConsoleColors();
//        testHighlightArrayRanges();
    }

    private static void testHighlightArrayElements() {
        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6};

        final int[] indices1 = {3};
        final int[] indices2 = {1, 6};
        final int[] indices4 = {0, 2, 5, 7};

        final ConsoleColor[] colors1 = {ConsoleColor.BLUE};
        final ConsoleColor[] colors2 = {ConsoleColor.YELLOW, ConsoleColor.GREEN};
        final ConsoleColor[] colors4 = {ConsoleColor.MAGENTA, ConsoleColor.YELLOW, ConsoleColor.GREEN, ConsoleColor.MAGENTA};

        System.out.println("Numbers: " + ColorArray.highlightElements(arr1, ConsoleColor.BLUE, indices2));
        System.out.println("Numbers: " + ColorArray.highlightElements(arr1, colors1, indices1));
        System.out.println("Numbers: " + ColorArray.highlightElements(arr1, colors2, indices2));
        System.out.println("Numbers: " + ColorArray.highlightElements(arr1, colors4, indices4));
    }

    private static void testHighlightArrayRanges() {
        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6};

        final int[][] ranges1 = {{5,7}};
        final int[][] ranges2 = {{1,1}, {5,6}};
        final int[][] ranges3 = {{1,2}, {4,6}, {7,7}};

        final ConsoleColor[] colors1 = {ConsoleColor.BLUE};
        final ConsoleColor[] colors2 = {ConsoleColor.YELLOW, ConsoleColor.GREEN};
        final ConsoleColor[] colors3 = {ConsoleColor.YELLOW, ConsoleColor.GREEN, ConsoleColor.MAGENTA};

        System.out.println("Numbers: " + ColorArray.highlightRanges(arr1, ranges1, colors1));
        System.out.println("Numbers: " + ColorArray.highlightRanges(arr1, ranges2, colors2));
        System.out.println("Numbers: " + ColorArray.highlightRanges(arr1, ranges3, colors3));
    }

    private static void testTerminalAnimation() throws InterruptedException {
        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6};

        for (int i=0; i < 3; ++i) {
            System.out.print("\rArray " + (i+1) + ": " + Arrays.toString(arr1));
            Thread.sleep(1000);
//            System.out.print("\b\b\b");
            System.out.print("\b");
            Thread.sleep(1200);
            System.out.print("\b");
            Thread.sleep(1200);
            System.out.print("\b");
        }

        System.out.println();
    }

    private static void testConsoleColors() {
        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6};

        System.out.println("Numbers: " + ColorArray.highlightArray(arr1));

        System.out.println("Numbers: " + ColorArray.highlightArray(arr1, ConsoleColor.GRAY));
        System.out.println("Numbers: " + ColorArray.highlightArray(arr1, ConsoleColor.GREEN_BOLD));
        System.out.println("Numbers: " + ColorArray.highlightArray(arr1, ConsoleColor.YELLOW_UNDERLINED));
        System.out.println("Numbers: " + ColorArray.highlightArray(arr1, ConsoleColor.BLUE_BACKGROUND));
        System.out.println("Numbers: " + ColorArray.highlightArray(arr1, ConsoleColor.MAGENTA_BRIGHT));
        System.out.println("Numbers: " + ColorArray.highlightArray(arr1, ConsoleColor.CYAN_BOLD_BRIGHT));
        System.out.println("Numbers: " + ColorArray.highlightArray(arr1, ConsoleColor.RED_BACKGROUND_BRIGHT));
    }
}
