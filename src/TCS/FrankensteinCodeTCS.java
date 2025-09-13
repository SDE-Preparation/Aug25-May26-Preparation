
import java.util.*;

import java.util.stream.Collectors;


public class FrankensteinCodeTCS {

    // Master list of all brewing recipes I've collected
    static Map<String, List<List<String>>> allRecipes = new HashMap<>();

    // Cache because I keep forgetting costs I already calculated
    static Map<String, Integer> costMemory = new HashMap<>();

    // Old attempt that didn't work - keeping for reference
    // static Map<String, Integer> failedCache = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First get how many recipes we're dealing with
        int numRecipes = 0;
        try {
            numRecipes = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("0"); // If they can't even give a proper number...
            return;
        }

        // Read all those recipes - this part always gives me a headache
        for (int i = 0; i < numRecipes; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue; // Skip empty lines because why not

            // Split by equals sign - hope there's always one!
            String[] parts = line.split("=", 2);
            if (parts.length < 2) {
                // System.out.println("Skipping invalid line: " + line);
                continue;
            }

            String resultPotion = parts[0].trim();
            String[] ingredients = parts[1].split("\\+");

            // Clean up the ingredients - remove any empty stuff
            List<String> cleanIngredients = Arrays.stream(ingredients)
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            if (cleanIngredients.isEmpty()) {
                // Empty recipe? Weird but okay
                continue;
            }

            // Add to our recipe book
            allRecipes.computeIfAbsent(resultPotion, k -> new ArrayList<>())
                    .add(cleanIngredients);
        }

        // Finally, what potion do we actually want to make?
        String targetPotion = sc.nextLine().trim();

        // Let's do this!
        int cost = findBrewingCost(targetPotion);
        System.out.println(cost);

        sc.close();
    }

    /**
     * Figure out how much it costs to brew a potion
     * Returns MAX_VALUE if it's impossible (which happens more than I'd like)
     */
    private static int findBrewingCost(String potionName) {
        // Check if we already did this calculation - no need to think twice!
        if (costMemory.containsKey(potionName)) {
            return costMemory.get(potionName);
        }

        // If it's not in our recipe book, it's a basic ingredient (free!)
        if (!allRecipes.containsKey(potionName)) {
            costMemory.put(potionName, 0);
            return 0;
        }

        int bestCost = Integer.MAX_VALUE; // Start with worst-case scenario

        // Try every recipe we have for this potion
        for (List<String> recipe : allRecipes.get(potionName)) {
            // Base cost: mixing n ingredients costs (n-1) orbs
            int recipeCost = recipe.size() - 1;
            boolean canBrew = true;

            // Check each ingredient in this recipe
            for (String ingredient : recipe) {
                int ingredientCost = findBrewingCost(ingredient);

                // If any ingredient is impossible, this recipe fails
                if (ingredientCost == Integer.MAX_VALUE) {
                    canBrew = false;
                    break; // No point checking the rest
                }

                recipeCost += ingredientCost;

                // Early exit if we're already over the best cost
                if (recipeCost > bestCost) {
                    canBrew = false;
                    break;
                }
            }

            // If this recipe works and is better than what we found before
            if (canBrew && recipeCost < bestCost) {
                bestCost = recipeCost;

                // If we found a cost of 0, we can stop early (but is this always true?)
                if (bestCost == 0) {
                    break;
                }
            }
        }

        // Remember this cost so we don't have to calculate it again
        costMemory.put(potionName, bestCost);
        return bestCost;
    }

    // I was trying a different approach but it didn't work well
    /*
    private static int alternativeCostCalculation(String potion) {
        // This was supposed to be optimized but made things worse
        return Integer.MAX_VALUE;
    }
    */
}


