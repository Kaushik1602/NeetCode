package binarySearch;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l =0;
        int r =matrix.length-1;
        int count = 0;
        while(l<=r){
            count++;
            int m = l+(r-l)/2;
            if(matrix[m][0]>target){
                r=m-1;
            }else if(matrix[m][0]<target){
                l=m+1;
            }else {
                System.out.println(count);
                return true;
            }
        }
        if(r==-1){
            return false;
        }
        int first = 0;
        int last = matrix[r].length-1;
        while(first<=last){
            count++;
            int m = first+(last-first)/2;
            if(matrix[r][m]>target){
                last=m-1;
            }else if(matrix[r][m]<target){
                first=m+1;
            }else {
                System.out.println(count);
                return true;
            }
        }
        System.out.println(count);
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int count = 0;
        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            count++;
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            count++;
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                System.out.println(count);
                return true;
            }
        }
        System.out.println(count);
        return false;
    }

    public boolean searchMatrixStaircase(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        int count = 0;
        while (r < m && c >= 0) {
            count++;
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                System.out.println(count);
                return true;
            }
        }
        System.out.println(count);
        return false;
    }
}
