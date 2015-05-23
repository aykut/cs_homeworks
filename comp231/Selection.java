
public class Selection {
	Selection(){}

	/**
	 * @param args
	 */
	public int[] selection(int[] y){
		
		for(int j=0;j<y.length;j++){
			int x=y[j];
			int control=j;
			for(int i=j;i<y.length;i++){
			if(y[i]<x){
				control=i;
				x=y[i];
			}
		}y[control]=y[j];
		y[j]=x;
		}return y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{};
		int[] arr1=new int[]{100};
		int[] arr2=new int[]{-250,-350,123,0,5,3,1000,456,890};
		Selection tmp=new Selection();
		System.out.println("1. Array");
		for(int i=0;i<arr.length;i++){
			System.out.println(tmp.selection(arr)[i]);
		}
		System.out.println("1. Array");
		System.out.println("2. Array");
		for(int i=0;i<arr1.length;i++){
			System.out.println(tmp.selection(arr1)[i]);
		}
		System.out.println("2. Array");
		System.out.println("3. Array");
		for(int i=0;i<arr2.length;i++){
			System.out.println(tmp.selection(arr2)[i]);
		}
		System.out.println("3. Array");

	}

}
