class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = {0, 1, 0, -1}; // right, down, left, up
        int[] dy = {1, 0, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        boolean [][] visited = new boolean [m][n];
        int x = 0, y = 0 , dir = 0;
        for (int i = 0; i < m * n; i++ ){
            result.add(matrix[x][y]);
            visited[x][y] = true;
            int myx = x + dx[dir];
            int myy = y+ dy[dir];
            // check if change directions
            if( myx >= 0 && myx < m && myy >= 0 && myy < n && !visited[myx][myy]){
                x = myx;
                y = myy;
            } else {
                dir = (dir + 1) % 4;
                x += dx[dir];
                y += dy[dir];
            }
        }
        return result;
    }
}
