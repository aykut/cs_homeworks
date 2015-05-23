import java.util.ArrayList;


public class MatrixList {
	ArrayList arr;
	public MatrixList() {
		arr=new ArrayList();
	}
	public void find(int[][] k){
		for(int i=0;i<k.length;i++){
			ArrayList arr1=new ArrayList();
			arr1.add(i+1);
			for(int j=0;j<k[i].length;j++){
				if(k[i][j]==1){
					arr1.add(j+1);
				}
				else{
				}
			}
			arr.add(arr1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixList ornek=new MatrixList();
		int[][] theMatrix={{0,1,0,0,1},{1,0,1,1,1},{0,1,0,1,0},{0,1,1,0,1},{1,1,0,1,0}};
		ornek.find(theMatrix);
		for(int i=0;i<ornek.arr.size();i++){
			ArrayList tmp=(ArrayList)ornek.arr.get(i);
			String s="";
			for(int j=0;j<tmp.size();j++){
				s=s+" "+tmp.get(j);
		}				System.out.println(s);

	}
		System.out.println("/////////");
		System.out.println("/////////");
		
		MatrixList ornek2=new MatrixList();
		int[][] theMatrix2={{0,1,0,1,0,0},{0,0,0,0,1,0},{0,0,0,0,1,1},{0,1,0,0,0,0},{0,0,0,1,0,0},{0,0,0,0,0,1}};
		ornek2.find(theMatrix2);
		for(int i=0;i<ornek2.arr.size();i++){
			ArrayList tmp=(ArrayList)ornek2.arr.get(i);
			String s="";
			for(int j=0;j<tmp.size();j++){
				s=s+" "+tmp.get(j);
		}				System.out.println(s);

	}
		System.out.println("/////////");
		System.out.println("/////////");
		
		MatrixList ornek3=new MatrixList();
		int[][] theMatrix3={{0,1,0},{0,1,1},{0,1,0}};
		ornek3.find(theMatrix3);
		for(int i=0;i<ornek3.arr.size();i++){
			ArrayList tmp=(ArrayList)ornek3.arr.get(i);
			String s="";
			for(int j=0;j<tmp.size();j++){
				s=s+" "+tmp.get(j);
		}				System.out.println(s);

	}
	}
}
