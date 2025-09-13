package TCS;



import java.util.*;

public class FaultySegment {

    // All the legit patterns for numbers and symbols
    static HashMap<String, String[]> legitPatterns = new HashMap<>();

    static {
        // Setting up what each char should look like
        legitPatterns.put("0", new String[]{" _ ", "| |", "|_|"});
        legitPatterns.put("1", new String[]{"   ", "  |", "  |"});
        legitPatterns.put("2", new String[]{" _ ", " _|", "|_ "});
        legitPatterns.put("3", new String[]{" _ ", " _|", " _|"});
        legitPatterns.put("4", new String[]{"   ", "|_|", "  |"});
        legitPatterns.put("5", new String[]{" _ ", "|_ ", " _|"});
        legitPatterns.put("6", new String[]{" _ ", "|_ ", "|_|"});
        legitPatterns.put("7", new String[]{" _ ", "  |", "  |"});
        legitPatterns.put("8", new String[]{" _ ", "|_|", "|_|"});
        legitPatterns.put("9", new String[]{" _ ", "|_|", " _|"});
        legitPatterns.put("+", new String[]{"   ", " + ", "   "});
        legitPatterns.put("-", new String[]{"   ", " - ", "   "});
        legitPatterns.put("*", new String[]{"   ", " * ", "   "});
        legitPatterns.put("/", new String[]{"   ", " / ", "   "});
        legitPatterns.put("=", new String[]{"   ", " = ", "   "});
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numChars = Integer.parseInt(sc.nextLine());

        // Grab the three lines of display
        String[] lines = new String[3];
        for (int i = 0; i < 3; i++) {
            lines[i] = sc.nextLine();
        }

        // Figure out how wide each char is
        int totalWidth = lines[0].length();
        int charWidth = totalWidth / numChars;

        // Chop up the display into individual chars
        ArrayList<String[]> displayChars = new ArrayList<>();
        for (int i = 0; i < numChars; i++) {
            int start = i * charWidth;
            String[] singleChar = new String[3];
            for (int j = 0; j < 3; j++) {
                // Handle cases where substring might go out of bounds
                if (start + charWidth <= lines[j].length()) {
                    singleChar[j] = lines[j].substring(start, start + charWidth);
                } else {
                    singleChar[j] = lines[j].substring(start);
                    // Pad with spaces if needed
                    while (singleChar[j].length() < charWidth) {
                        singleChar[j] += " ";
                    }
                }
            }
            displayChars.add(singleChar);
        }

        // First, try to recognize the original equation
        String originalEquation = recognizeEquation(displayChars);
        if (originalEquation != null && isEquationValid(originalEquation)) {
            // If the original equation is already correct, no fault found
            System.out.println("1"); // According to problem, there's always one fault
            return;
        }

        // Check each char to see if flipping one segment fixes things
        for (int pos = 0; pos < numChars; pos++) {
            String[] original = displayChars.get(pos);

            // Try flipping every possible segment in this char
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < charWidth; col++) {
                    // Skip if we're out of bounds
                    if (col >= original[row].length()) continue;

                    // Make a copy and flip one segment properly
                    String[] modified = new String[3];
                    for (int i = 0; i < 3; i++) {
                        modified[i] = original[i];
                    }

                    char[] rowChars = modified[row].toCharArray();
                    // Proper segment toggling: space to segment or segment to space
                    if (rowChars[col] == ' ') {
                        // Replace space with appropriate segment character
                        if (row == 0) rowChars[col] = '_';
                        else if (row == 1 || row == 2) rowChars[col] = '|';
                    } else {
                        // Replace segment with space
                        rowChars[col] = ' ';
                    }
                    modified[row] = new String(rowChars);

                    // Create a modified display
                    ArrayList<String[]> modifiedDisplay = new ArrayList<>(displayChars);
                    modifiedDisplay.set(pos, modified);

                    // Try to read the whole equation with this change
                    String equation = recognizeEquation(modifiedDisplay);
                    if (equation != null && isEquationValid(equation)) {
                        System.out.println(pos + 1);
                        return;
                    }
                }
            }
        }

        // Fallback: if no single segment flip works, output first position
        System.out.println("1");
    }

    // Recognize the entire equation
    static String recognizeEquation(ArrayList<String[]> displayChars) {
        StringBuilder equation = new StringBuilder();
        for (String[] character : displayChars) {
            String recognized = whatIsThis(character);
            if (recognized == null) {
                return null; // Cannot recognize all characters
            }
            equation.append(recognized);
        }
        return equation.toString();
    }

    // Figure out what character this pattern represents
    static String whatIsThis(String[] pattern) {
        for (Map.Entry<String, String[]> entry : legitPatterns.entrySet()) {
            if (Arrays.equals(pattern, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null; // No idea what this is
    }

    // Check if the equation is valid
    static boolean isEquationValid(String equation) {
        // Split into left and right of equals
        String[] parts = equation.split("=");
        if (parts.length != 2) return false;

        String leftSide = parts[0];
        String rightSide = parts[1];

        // Right side should be a number
        if (!rightSide.matches("\\d+")) return false;

        try {
            int computed = evaluateExpression(leftSide);
            int expected = Integer.parseInt(rightSide);
            return computed == expected;
        } catch (Exception e) {
            return false;
        }
    }

    // Evaluate the expression sequentially
    static int evaluateExpression(String expression) {
        // Use regex to split while keeping operators
        String[] tokens = expression.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length - 1; i += 2) {
            char operator = tokens[i].charAt(0);
            int operand = Integer.parseInt(tokens[i + 1]);

            switch (operator) {
                case '+': result += operand; break;
                case '-': result -= operand; break;
                case '*': result *= operand; break;
                case '/': result /= operand; break;
            }
        }
        return result;
    }
}