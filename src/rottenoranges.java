class Solution {
    private static final int[] X = { 1, -1, 0, 0 };
    private static final int[] Y = { 0, 0, 1, -1 };
    // grid = [[1],[2]], grid[1][0] = 2
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int n = grid.length; // 竖
        int m = grid[0].length; // 横

        Queue<Integer> q = new ArrayDeque<>();
        // find rotten orange
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(i * 10 + j);
                }
            }
        }
        int minute = 0;
        while (!q.isEmpty() && fresh != 0) {
            int size = q.size();
            // pull the first element, find neighbors then put back in queue
            for (int i = 0; i < size; i++) {
                int index = q.poll();
                int x = index / 10;
                int y = index % 10;
                for (int j = 0; j < X.length; j++) {
                    int nextX = x + X[j];
                    int nextY = y + Y[j];
                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || grid[nextX][nextY] != 1) {
                        continue;
                    }
                    grid[nextX][nextY] = 2;
                    fresh--;
                    q.offer(nextX * 10 + nextY);


                }

            }
            minute++;
        }
        return fresh == 0 ? minute :-1;
    }

    // private boolean isnotVaild(int[][] grid, int x, int y) {
    // return (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||
    // grid[x][y] != 1) ;
    // }
}
