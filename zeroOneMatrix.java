/*
TC --> O(n*m)
SC --> O(n*m)
 */
class Solution {

    public int[][] updateMatrix(int[][] mat) {

        //we can perform bfs and dfs both
        bfs(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 1;
                }
            }
        }

        return mat;

    }

    public void bfs(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }//if
            }//for
        }//for

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int level = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {

                int[] curr = q.poll();
                if (level == 1) {
                    mat[curr[0]][curr[1]] = level * -1;
                } else {
                    mat[curr[0]][curr[1]] = level;
                }

                for (int[] dir : directions) {
                    int new_r = dir[0] + curr[0];
                    int new_c = dir[1] + curr[1];

                    if (isValid(mat, new_r, new_c, m, n)) {
                        mat[new_r][new_c] = -1;
                        q.add(new int[]{new_r, new_c});
                        //System.out.println("added "+new_r+" "+new_c+" at level "+level);
                    }//if

                }//for

            }//for

            level++;
        }//while

    }//method

    public boolean isValid(int[][] mat, int r, int c, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] != 1 || mat[r][c] == 0) {
            return false;
        }
        return true;
    }
}
