class Solution {
    public ArrayList<Integer> solve(int n, int k, int[] query, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Set<Integer> redSet = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            int curr = query[i];

            if (redSet.size() == 0) {
                redSet.add(curr);
                res.add(-1);
            } else {
                // BFS from current node to find distance to any red node
                Queue<int[]> queue = new LinkedList<>();
                boolean[] visited = new boolean[n + 1];
                queue.add(new int[]{curr, 0});
                visited[curr] = true;

                int foundDist = Integer.MAX_VALUE;

                while (!queue.isEmpty()) {
                    int[] front = queue.poll();
                    int node = front[0], dist = front[1];

                    if (redSet.contains(node) && node != curr) {
                        foundDist = dist;
                        break;
                    }

                    for (int nei : graph.get(node)) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            queue.add(new int[]{nei, dist + 1});
                        }
                    }
                }

                minDist = Math.min(minDist, foundDist);
                redSet.add(curr);

                if (redSet.size() >= 2) res.add(minDist);
                else res.add(-1);
            }
        }
        return res;
    }
}
