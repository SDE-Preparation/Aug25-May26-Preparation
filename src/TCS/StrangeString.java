package TCS;

import java.util.*;
import java.io.*;

/*
 * Coder : Karunagaran V
 * Purpose: Strange String program tcs codevita
 */
public class StrangeString {

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        String goalWord = inputReader.readLine().trim();
        int numPieces = Integer.parseInt(inputReader.readLine().trim());

        String[] piecesArr = inputReader.readLine().trim().split(" ");
        int[] pieceCosts = new int[numPieces];
        String[] costTokens = inputReader.readLine().trim().split(" ");
        for (int idx = 0; idx < numPieces; idx++) {
            pieceCosts[idx] = Integer.parseInt(costTokens[idx]);
        }

        int costFreeArrange = lowCostReader(goalWord, piecesArr, pieceCosts);

        if (costFreeArrange == -1) {
            // Impossible to form target
            System.out.println(-1);
            return;
        }

        int costOrdered = minCostOrdered(goalWord, piecesArr, pieceCosts);
        System.out.println(costOrdered - costFreeArrange);
    }

    static int lowCostReader(String target, String[] pieces, int[] costs) {
        int[] wantedCount = new int[26];
        for (char ch : target.toCharArray()) wantedCount[ch - 'a']++;

        int counting = 0;

        for (int i = 0; i < 26; i++) {
            if (wantedCount[i] == 0) continue;

            char thisChar = (char) ('a' + i);
            List<Integer> availableCosts = new ArrayList<>();
            int totalOccurrences = 0;

            for (int j = 0; j < pieces.length; j++) {
                int count = notingCountForString(pieces[j], thisChar);
                totalOccurrences += count;
                for (int k = 0; k < count; k++) availableCosts.add(costs[j]);
            }

            if (totalOccurrences < wantedCount[i]) {
                return -1; // Cannot form target
            }

            Collections.sort(availableCosts);
            for (int k = 0; k < wantedCount[i]; k++) counting += availableCosts.get(k);
        }

        return counting;
    }


    // calculate cost if we must use letters in the original order
    static int minCostOrdered(String targetValue, String[] pieces, int[] costing) {
        int len = targetValue.length();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 0; i <= len; i++) {
            if (dp[i] >= Integer.MAX_VALUE / 2) continue;

            for (int j = 0; j < pieces.length; j++) {
                String piece = pieces[j];
                int price = costing[j];
                int pos = i;

                for (char ch : piece.toCharArray()) {
                    if (pos < len && targetValue.charAt(pos) == ch) pos++;
                }

                if (pos > i) dp[pos] = Math.min(dp[pos], dp[i] + price);
            }
        }

        return dp[len];
    }

    // counting character in a string
    static int notingCountForString(String strr, char ch) {
        int cntt = 0;
        for (char c : strr.toCharArray()) if (c == ch) cntt++;
        return cntt;
    }
}
