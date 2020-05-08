package problems.hard.p0149;

public class Solution {

	public static void main(String[] args) {
		// 149. Max Points on a Line

	}
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n < 3) return n;
        
        int max = 2;
        
        for(int i = 1; i < n; i++){
            for(int t = 1; t <= i; t++){
                int count = 0;
                long x1 = points[i - t][0];
                long y1 = points[i - t][1];
                long x2 = points[i][0];
                long y2 = points[i][1];

                if(x1 == x2 && y1 == y2){
                    for(int j = 0; j < n; j++){
                        if(x2 == points[j][0] && y2 == points[j][1])
                            count++;
                    }
                }
                else{
                    for(int j = 0; j < n; j++){
                        if((points[j][1] - y2) * (x2 - x1) == (y2 - y1) * (points[j][0] - x2))
                            count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
