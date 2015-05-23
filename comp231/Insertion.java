
public class Insertion {
	Insertion(){
	}
	public int[] insertionSort(int[] n){
		for(int i=1;i<n.length;i++){
			int tmp=n[i];
			for(int j=i-1;j>=0;j--){
				if(tmp<n[j]){
					n[j+1]=n[j];
					n[j]=tmp;
				}
				else{
					j=-1;
				}
			}
		}return n;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{};
		int[] arr1=new int[]{100};
		int[] arr2=new int[]{-250,-350,123,0,5,3,1000,456,890};
		Insertion tmp=new Insertion();
		System.out.println("1. Array");
		for(int i=0;i<arr.length;i++){
			System.out.println(tmp.insertionSort(arr)[i]);
		}
		System.out.println("1. Array");
		System.out.println("2. Array");
		for(int i=0;i<arr1.length;i++){
			System.out.println(tmp.insertionSort(arr1)[i]);
		}
		System.out.println("2. Array");
		System.out.println("3. Array");
		for(int i=0;i<arr2.length;i++){
			System.out.println(tmp.insertionSort(arr2)[i]);
		}
		System.out.println("3. Array");

	}

}
