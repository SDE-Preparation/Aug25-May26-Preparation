package TCS; // Package name changed

import java.util.*;

/*
 * Purpose: Solve the 7-segment mirror reflection puzzle and find the smallest number.
 */
public class MirrorPuzzle_Karan { // Class name changed

    // Segment bitmasks: Indices 0-6 correspond to segments (top, tr, br, bottom, bl, tl, middle)
    private static final int[] MASK_VALUES = { // Variable name changed
            0b0111111, // 0
            0b0000110, // 1
            0b1011011, // 2
            0b1001111, // 3
            0b1100110, // 4
            0b1101101, // 5
            0b1111101, // 6
            0b0000111, // 7
            0b1111111, // 8
            0b1101111  // 9
    };

    // Horizontal reflection map (L/R)

    private static final int[] HORIZONTAL_MAP = {0, 5, 4, 3, 2, 1, 6};
    private static final int[] VERTICAL_MAP = {3, 4, 5, 0, 1, 2, 6}; // corrected
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Variable name changed
        String inputNumber = scanner.nextLine(); // Variable name changed
        String reflectionTypes = scanner.nextLine(); // Variable name changed
        scanner.close();

        List<Integer> validTransformedDigits = new ArrayList<>(); // Variable name changed

        for (int i = 0; i < inputNumber.length(); i++) {
            int originalDigit = inputNumber.charAt(i) - '0'; // Variable name changed
            char reflection = reflectionTypes.charAt(i); // Variable name changed

            int transformedDigit = getReflectedDigit(originalDigit, reflection); // Method name changed

            if (transformedDigit != -1) {
                validTransformedDigits.add(transformedDigit);
            }
        }

        // Create the minimum number
        sortAndSwapLeadingZero(validTransformedDigits); // Method name changed

        // Print result
        for (int d : validTransformedDigits) {
            System.out.print(d);
        }
        System.out.println();
    }

    /**
     * Sorts digits and ensures the smallest number is formed by handling the leading zero.
     */
    static void sortAndSwapLeadingZero(List<Integer> digits) { // Method name changed
        if (digits.isEmpty()) return;

        Collections.sort(digits);

        if (digits.get(0) == 0 && digits.size() > 1) {
            for (int j = 1; j < digits.size(); j++) {
                if (digits.get(j) != 0) {
                    int smallestNonZero = digits.get(j);
                    digits.set(j, 0);
                    digits.set(0, smallestNonZero);
                    break;
                }
            }
        }
    }

    /**
     * Calculates the reflected digit.
     */
    static int getReflectedDigit(int originalDigit, char reflectionType) { // Method name changed

        if (reflectionType == 'S') return originalDigit;

        int originalMask = MASK_VALUES[originalDigit]; // Variable name changed
        int[] mappingArray = getSegmentMapping(reflectionType); // Method name changed
        if (mappingArray == null) return -1;

        int finalMask = applyReflectionToMask(originalMask, mappingArray); // Method name changed

        return findDigitFromMask(finalMask); // Method name changed
    }

    // Helper to get the correct segment map
    static int[] getSegmentMapping(char reflectedType) { // Method name changed
        switch (reflectedType) {
            case 'L':
            case 'R':
                return HORIZONTAL_MAP;
            case 'U':
            case 'D':
                return VERTICAL_MAP;
            default:
                return null;
        }
    }

    // Helper to perform the bitwise reflection
    static int applyReflectionToMask(int originalMask, int[] map) { // Method name changed
        int reflectedMask = 0;
        for (int seg = 0; seg < 7; seg++) {
            // Check if segment 'seg' is ON
            if ((originalMask & (1 << seg)) != 0) {
                // Turn ON the segment at its new position map[seg]
                reflectedMask |= (1 << map[seg]);
            }
        }
        return reflectedMask;
    }

    // Helper to look up the digit corresponding to the final mask
    static int findDigitFromMask(int mask) { // Method name changed
        for (int d = 0; d <= 9; d++) {
            if (MASK_VALUES[d] == mask) return d;
        }
        return -1;
    }
}