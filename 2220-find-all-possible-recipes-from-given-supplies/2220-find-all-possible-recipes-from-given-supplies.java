class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size());
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>(available);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String ingredient = queue.poll();
            if (graph.containsKey(ingredient)) {
                for (String recipe : graph.get(ingredient)) {
                    inDegree.put(recipe, inDegree.get(recipe) - 1);
                    if (inDegree.get(recipe) == 0) {
                        queue.offer(recipe);
                        result.add(recipe);
                    }
                }
            }
        }

        return result;
    }
}
