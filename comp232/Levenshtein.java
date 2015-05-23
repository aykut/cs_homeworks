import java.util.logging.Level;


public class Levenshtein {
	int n;
	int m;
	int mat[][];
	int cost;
	public int LevenDis(String fst,String scnd){
		n=fst.length();
		m=scnd.length();
		mat=new int[n+1][m+1];
		char fstof;
		char scndof;
		if(n==0){
			return m;
		}
		if(m==0){
			return n;
		}
		for(int i=0;i<=n;i++){
			mat[i][0]=i;
		}
		for(int j=0;j<=m;j++){
			mat[0][j]=j;
		}
		for (int i=1;i<=n;i++) {
			fstof=fst.charAt(i-1);
			for(int j=1;j<=m;j++){
				scndof=scnd.charAt(j-1);
		        if(fstof==scndof){
		            cost=0;
		          }
		          else{
		            cost=1;
		          }
		        mat[i][j] =minu(mat[i-1][j]+1,mat[i][j-1]+1,mat[i-1][j-1]+cost);
				}
		}
		return mat[n][m];
	}
	public int minu(int x,int y,int z){
		int k=Math.min(x,y);
		int min=Math.min(k,z);
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Levenshtein ornek=new Levenshtein();
		System.out.println(ornek.LevenDis("ankara","kara"));
		System.out.println(ornek.LevenDis("ali","veli"));
		System.out.println(ornek.LevenDis("konya","anya"));
		System.out.println(ornek.LevenDis("kale",""));
		System.out.println(ornek.LevenDis("market","dükkan"));
		System.out.println(ornek.LevenDis("onur","onar"));
		System.out.println(ornek.LevenDis("yüz","yüz"));

	}

}
