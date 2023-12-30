
class Solution {
    private static final int[] X = {1, -1, 0, 0};
    private static final int[] Y = {0, 0, 1, -1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        if (grid == null || n == 0 || m == 0) return count;
        for(int i = 0; i < n; i ++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }

            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j){
        Queue<Integer> q = new ArrayDeque<>();
        int m = grid[0].length;
        q.offer(i * m + j);
        grid[i][j] = '0';
        while(!q.isEmpty()) {
            int index = q.poll();
            int x = index / m;
            int y = index % m;
            for(int e = 0; e < X.length; e++) {
                int x1 = x + X[e];
                int y1 = y + Y[e];
                if(x1 < 0 || y1 < 0 || x1 >= grid.length || y1 >= grid[0].length || grid[x1][y1] != '1') {
                    continue;
                }
                q.offer(x1 * m + y1);
                grid[x1][y1] = '0';
            }

        }
    }
}