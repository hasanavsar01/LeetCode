package problems.medium.p0253;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// Meeting Rooms II

		int n = findMinNoOfMeetingRooms(new int[][] {{10,20},{20,30},{30,40},{50,60},{60,70},{70,80},
													 {25,35},{35,45},{45,90},{15,100},{15,100},{1,11}
													});
		System.out.println(n);

		n = findMinNoOfMeetingRooms2(new int[][] {{10,20},{20,30},{30,40},{50,60},{60,70},{70,80},
												  {25,35},{35,45},{45,90},{15,100},{15,100},{1,11}
												  });
		System.out.println(n);
	}
	
	public static int findMinNoOfMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		boolean[] used = new boolean[intervals.length];
		int rooms = 0;
		
		for(int i = 0; i < intervals.length; i++) {
			if(used[i]) continue;
			
			used[i] = true;
			
			for(int j = i + 1; j < intervals.length; j++) {
				if(used[j]) continue;

				if(intervals[i][1] <= intervals[j][0]) {
					used[j] = true;
					i = j;
				}
			}
			rooms++;
		}
		return rooms;
	}
	
	public static int findMinNoOfMeetingRooms2(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		List<Integer> rooms = new ArrayList();
		
		for(int i = 0; i < intervals.length; i++) {
			boolean isAdded = false;
			for(int j = 0; j < rooms.size(); j++) {
				if(rooms.get(j) <= intervals[i][0]) {
					rooms.set(j, intervals[i][1]);
					isAdded = true;
					break;
				}
			}
			if(!isAdded)
				rooms.add(intervals[i][1]);
		}

		return rooms.size();
	}
}
