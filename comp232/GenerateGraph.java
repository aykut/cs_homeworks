
public class GenerateGraph {
	
	public static void makeGraph(int[][] x){
		String st="{";
		for(int i=0;i<x.length;i++){
			String s=""+(i+1)+"="+"[";
			for(int j=0;j<x[i].length;j++){
				if(x[i][j]==1){
					if(j==x[i].length-1){
					s=s+(i+1)+"==>"+(j+1);
					}else{
						s=s+(i+1)+"==>"+(j+1)+", ";
					}
				}
				else{
					
				}
			}
			s=s+"]";
			if(i==x.length-1){
				st=st+s+" ";
			}else{
			st=st+s+", ";
			}
		}
		st=st+"}";
		System.out.println(st);
	}
	
	public static void generate(int x){
		int[][] n=new int[x][x];
		for(int i=0;i<n.length;i++){
			for(int j=0;j<n[i].length;j++){
				if(i==j){
					n[i][j]=0;
				}else{
					n[i][j]=1;
				}
			}
		}
		makeGraph(n);
	}

	public static void main(String[] args) {
		
		generate(1);
		
		System.out.println("  ");
		
		generate(5);
		
		System.out.println("   ");
		
		generate(10);
		

	}
	
}
