package problems.medium.p0380;

public class Solution {

	public static void main(String[] args) {
		// 380. Insert Delete GetRandom O(1)
		
		RandomizedSet obj = new RandomizedSet();
		System.out.println(obj.insert(5));
		System.out.println(obj.insert(10));
		System.out.println(obj.insert(12));
		System.out.println(obj.insert(10));
		System.out.println(obj.insert(1));
		System.out.println(obj.insert(-10));

		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		

	}

}
