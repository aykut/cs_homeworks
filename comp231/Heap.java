
public class Heap {
	int size;
	Heap(){
		size=0;
	}
	public int parent(int i){
		return i/2;
	}
	public int left(int i){
		return 2*i;
	}
	public int right(int i){
		return (2*i)+1;
	}
	public void Max_Heapify(int[] A,int i){
		int l=left(i);
		int r=right(i);
		int largest;
		if(l<=size&&A[l]>A[i]){
				largest=l;
		}
		else{
			largest=i;
		}
		if (r <=size && A[r] > A[largest]){
			largest=r;
		}
		if(largest!=i){
			exchange(A,largest,i);
			Max_Heapify(A,largest);
		}
		}
	public void build_max(int[] A){
		size=A.length-1;
		for(int i=(A.length-1)/2;i>=0;i--){
			Max_Heapify(A,i);
		}
	}
	public int[] Heap_Sort(int[] A){
		build_max(A);
		for(int i=A.length-1;i>=1;i--){
			exchange(A,0,i);
			size=size-1;
			Max_Heapify(A,0);
		}return A;
	}
		public void exchange(int[] A,int a,int b){
			int tmp=A[a];
			A[a]=A[b];
			A[b]=tmp;
		}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap ornek=new Heap();
		int[] arr=new int[]{};
		int[] arr1=new int[]{100};
		int[] arr2=new int[]{-250,-350,123,0,5,3,1000,456,890};
		ornek.Heap_Sort(arr);
		System.out.println("1. Array");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("1. Array");
		System.out.println("2. Array");
		for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
		System.out.println("2. Array");
		System.out.println("3. Array");
		for(int i=0;i<arr2.length;i++){
			System.out.println(arr2[i]);
		}
		System.out.println("3. Array");
	}

}
