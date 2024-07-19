/*
Tc -> O(n*m)
Sc -> O(n*m) 
 */
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        bfs(image, sr, sc, color);
        return image;

    }

    public void bfs(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int prev_color = image[sr][sc];
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int[] curr = q.poll();

                for (int[] dir : directions) {
                    int new_r = dir[0] + curr[0];
                    int new_c = dir[1] + curr[1];

                    if (new_r >= 0 && new_r < image.length && new_c >= 0 && new_c < image[0].length && image[new_r][new_c] != color && image[new_r][new_c] == prev_color) {
                        image[new_r][new_c] = color;

                        q.add(new int[]{new_r, new_c});
                    }
                }
            }

        }//while
    }//method
}//class
