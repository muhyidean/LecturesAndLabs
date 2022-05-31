package inclassdemos.lesson2;


public class Main {

	public static void main(String[] args) {
		
//		Student std1 = new Student(111,"Dean",3.7,new Address());
//
//		System.out.println(std1.getAddress().city);

		int [][] nums = {{1,2,3}, {4,5,6}};

//		int [][] ans = transpose(nums);

		for(int i = 0 ; i< nums.length;i++){
			for (int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[j][i]);
			}
			System.out.println("");
		}
	}


		public static  int[][] transpose(int[][] matrix) {
			int [][] trans = new int[matrix.length][];
			for(int i = 0 ; i< matrix.length ; i++){
				for(int j = 0 ; j< matrix[i].length ; j++){
					trans[j][i] = matrix[i][j];
				}
			}

			return trans;
		}


}
