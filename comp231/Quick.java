
public class Quick {
	Quick(){}
	public int partition(int[] a,int p,int r){
		int x=a[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			if(a[j]<=x){
				i=i+1;
				int tmp=a[i];
				a[i]=a[j];
				a[j]=tmp;
			}
		}
		int tmk=a[i+1];
		a[i+1]=a[r];
		a[r]=tmk;
		return i+1;
	}
	public void QuickSort(int[] a,int p,int r){
		int q;
		if(p<r){
			q=partition(a,p,r);
			QuickSort(a,p,q-1);
			QuickSort(a,q+1,r);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quick ornek=new Quick();
		int[] arr=new int[]{};
		int[] arr1=new int[]{100};
		int[] arr2=new int[]{-250,-350,123,0,5,3,1000,456,890};
		ornek.QuickSort(arr,0, arr.length-1);
		ornek.QuickSort(arr1,0, arr1.length-1);
		ornek.QuickSort(arr2,0, arr2.length-1);
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

