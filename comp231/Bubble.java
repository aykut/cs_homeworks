
public class Bubble {
	int[] data;
	Bubble(int[] data){
		this.data=data;
	}
	public int[] bubbleSort(int[] n){
		for(int i=n.length;i>1;i--){
			for(int j=0;j<i-1;j++){
				if(n[j]>=n[j+1]){
					int tmp=n[j+1];
					n[j+1]=n[j];
					n[j]=tmp;
				}
				else{
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
		Bubble ornek=new Bubble(arr);
		Bubble ornek1=new Bubble(arr1);
		Bubble ornek2=new Bubble(arr2);
		System.out.println("1. Array");
		for(int i=0;i<arr.length;i++){
			System.out.println(ornek.bubbleSort(arr)[i]);
		}
		System.out.println("1. Array");
		System.out.println("2. Array");
		for(int i=0;i<arr1.length;i++){
			System.out.println(ornek1.bubbleSort(arr1)[i]);
		}
		System.out.println("2. Array");
		System.out.println("3. Array");
		for(int i=0;i<arr2.length;i++){
			System.out.println(ornek2.bubbleSort(arr2)[i]);
		}
		System.out.println("3. Array");
	}

}
