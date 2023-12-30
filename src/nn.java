class Solution {
    private static final int[] X = {1, -1, 0, 0};
    private static final int[] Y = {0, 0, 1, -1};
    public int orangesRotting(int[][] grid) {
        if (grid == null) return -1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> q = new ArrayDeque<>();
        // find rotten orange
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) fresh ++;
                if(grid[i][j] == 2) {
                    q.offer(i * n + j);
                }
            }
        }
        int minute = 0;
        while (!q.isEmpty() && fresh != 0) {
            int size = q.size();
            // pull the first element, find neighbors then put back in queue
            for (int i = 0; i < size; i++) {
                int index = q.poll();
                int x = index / n;
                int y = index % n;
                for (int j = 0; j < X.length; j++) {
                    int grid_x = x + X[j];
                    int grid_y = y + Y[j];
                    if (grid_x < 0 || grid_y < 0 || grid_x >= grid.length || grid_y >= grid[0].length || grid[grid_x][grid_y] != 1) {
                        continue;
                    } else {
                        q.offer(grid_x * n + y);
                        grid[grid_x][grid_y] = 2;
                        fresh--;
                    }
                }

            }
            minute++;

        if (fresh == 0) return minute;
        if (fresh > 0 ) return -1;
    }


    // private boolean isnotVaild(int[][] grid, int x, int y) {
    //     return (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) ;
    // }
}