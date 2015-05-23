	/*
	FLOYD-WARSHALL(W)
	1 n <- rows[W]
	2 D(0) <-W
	3 for k <- 1 to n
	4 		do for i <-1 to n
	5 			do for j <- 1 to n
	6 				do d(k)ij <- min(d(k-1)ij,d(k-1)ik+d(k-1)kj )
	7 return D(n)
*/


public class Floyd {
	Double[][][] D=new Double[6][5][5];
	public Floyd() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Double[][] floydWarshall(Double[][] W){
		int n=W[0].length;
		D[0]=W;
		for(int k=1,l=0;k<=n;k++,l++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					D[k][i][j]=Math.min(D[k-1][i][j], D[k-1][i][l]+D[k-1][l][j]);
				}
			}
		}
		return D[n];
	}
	public static void main(String[] args) {
		Double infinite=Double.POSITIVE_INFINITY;
		// the example from the cormen
		Double[][] W=new Double[][]{{0.0,3.0,8.0,infinite,-4.0},{infinite,0.0,infinite,1.0,7.0},{infinite,4.0,0.0,infinite,infinite},{2.0,infinite,-5.0,0.0,infinite},{infinite,infinite,infinite,6.0,0.0}};
		Double[][] x;
		Floyd f=new Floyd();
		x=f.floydWarshall(W);
		for(int j=0;j<x.length;j++){
			String s=" ";
			for (int i = 0; i < x.length; i++) {
			s=s+" "+x[j][i].intValue();
		}
		System.out.println(s);
	}
		}

}
