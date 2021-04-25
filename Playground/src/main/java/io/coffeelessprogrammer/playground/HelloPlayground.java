package io.coffeelessprogrammer.playground;

import io.coffeelessprogrammer.playground.utils.ColorArray;
import io.coffeelessprogrammer.playground.utils.ConsoleColor;

public class HelloPlayground {

    public static void main(String[] args) {
        System.out.println("Hello Playground!");

        testConsoleColors();
    }

    private static void testConsoleColors() {
        final int[] arr1 = {32, 8, 17, 94, 52, 43, 28, 6};

        System.out.println("Numbers: " + ColorArray.highlightRange(arr1, ConsoleColor.GRAY));
        System.out.println("Numbers: " + ColorArray.highlightRange(arr1, ConsoleColor.GREEN_BOLD));
        System.out.println("Numbers: " + ColorArray.highlightRange(arr1, ConsoleColor.YELLOW_UNDERLINED));
        System.out.println("Numbers: " + ColorArray.highlightRange(arr1, ConsoleColor.BLUE_BACKGROUND));
        System.out.println("Numbers: " + ColorArray.highlightRange(arr1, ConsoleColor.MAGENTA_BRIGHT));
        System.out.println("Numbers: " + ColorArray.highlightRange(arr1, ConsoleColor.CYAN_BOLD_BRIGHT));
        System.out.println("Numbers: " + ColorArray.highlightRange(arr1, ConsoleColor.RED_BACKGROUND_BRIGHT));
    }
}
