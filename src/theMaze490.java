class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        List<Integer> X = Arrays.asList(0, 0, 1, -1);
        List<Integer> Y = Arrays.asList(1, -1, 0, 0);
        int n = maze.length;
        int m = maze[0].length;
        int end_x = destination[0];
        int end_y = destination[1];
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start[0] * m + start[1]);

        while (!q.isEmpty()) {
            int index = q.poll();
            int x = index / m;
            int y = index % m;

            if (x == end_x && y == end_y) return true;

            for (int j = 0; j < X.size(); j++) {
                int new_x = x + X.get(j);
                int new_y = y + Y.get(j);

                while (!isWall(new_x, new_y, maze)) {
                    new_x += X.get(j);
                    new_y += Y.get(j);
                }

                // Step back to the last valid position
                new_x -= X.get(j);
                new_y -= Y.get(j);

                if (!visited[new_x][new_y]) {
                    visited[new_x][new_y] = true;
                    q.offer(new_x * m + new_y);
                }
            }
        }
        return false;
    }

    private boolean isWall(int x, int y, int[][] maze) {
        return (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == 1);
    }
}
