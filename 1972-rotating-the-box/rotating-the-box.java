class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] grid = new char[boxGrid[0].length][boxGrid.length];
        for (int i = 0; i < grid.length; i++) Arrays.fill(grid[i], '.');

        int m = grid[0].length;

        for (int i = 0; i < boxGrid.length; i++) {
            int count = 0;

            for (int j = 0; j < boxGrid[i].length; j++) {
                if (boxGrid[i][j] == '#') {
                    count++;
                } else if (boxGrid[i][j] == '*') {
                    grid[j][m - i - 1] = '*';
                    fill(grid, j - 1, m - i - 1, count);
                    count = 0;
                }
            }

            if (count > 0) {
                fill(grid, boxGrid[0].length - 1, m - i - 1, count);
            }
        }

        return grid;
    }

    public void fill(char[][] grid, int r, int c, int count) {
        if (r < 0) return;

        System.out.println("r:"+r);
        System.out.println("c:"+c);
        while (count > 0) {
            grid[r][c] = '#';
            count--;
            r--;
        }
    }
}