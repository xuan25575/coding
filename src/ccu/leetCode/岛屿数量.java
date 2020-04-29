package ccu.leetCode;

import java.util.LinkedList;

/**
 * @Author huang_2
 * @Date 2020/4/20 9:20 上午
 * @Description TODO
 */
public class 岛屿数量 {
    private int[] dr = {0, 0, -1, 1};
    private int[] dc = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {

        int nr = grid.length;
        int nc = grid[0].length;
        boolean[][] marked = new boolean[nr][nc];
        int count = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    count++;
                    marked[i][j] = true;
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.addLast(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] arr = queue.removeFirst();
                        for (int k = 0; k < 4; k++) {
                            int newX = arr[0] + dr[k];
                            int newY = arr[1] + dc[k];
                            if (newX >= 0 && newX < nr && newY >= 0
                                    && newY < nc && !marked[newX][newY] && grid[newX][newY] == '1') {
                                queue.addLast(new int[]{newX, newY});
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        岛屿数量 solution2 = new 岛屿数量();
//        char[][] grid1 = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
//        int numIslands1 = solution2.numIslands(grid1);
//        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution2.numIslands(grid2);
        System.out.println(numIslands2);
    }

}
