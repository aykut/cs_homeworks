
public class Shell {
	int[] a;
	int tem;
	Shell(int[] b){
		a=b;
		tem=(int)(a.length/2);
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
	public void shellSort(){
		if(tem<=1){
			this.insertionSort(this.a);
		}
		else{
		if(tem!=1){
		for(int i=0;i<a.length-tem;i++){
			for(int j=i+tem;j>=0;j=j-tem){
				if(a[i]>a[j]){
					int x=a[j];
					a[j]=a[i];
					a[i]=x;
				}
				else{
					j=-1;
				}
			}
		}tem=(int)(tem/2);
		this.shellSort();
	}
		else{
			this.insertionSort(this.a);
		}
	}
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{};
		int[] arr1=new int[]{100};
		int[] arr2=new int[]{-250,-350,123,0,5,3,1000,456,890};
		Shell tmp=new Shell(arr);
		Shell tmp1=new Shell(arr1);
		Shell tmp2=new Shell(arr2);
		tmp.shellSort();
		tmp1.shellSort();
		tmp2.shellSort();
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


