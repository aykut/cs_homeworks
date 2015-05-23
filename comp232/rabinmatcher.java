import java.util.ArrayList;

/*
 RABIN-KARP-MATCHER(T, P, d, q)
1 n = length[T ]
2 m = length[P]
3 h = dm-1 mod q
4 p = 0
5 t0 = 0
6 for i = 1 to m 
7 	do p = (dp + P[i ]) mod q
8 		t0 = (dt0 + T [i ]) mod q
9 for s = 0 to n - m 
10 	do if p = ts
11 		then if P[1 . .m] = T [s + 1 . . s + m]
12 			then print "Pattern occurs with shift" s
13 	   if s < n - m
14 		then ts+1 = (d(ts - T [s + 1]h) + T [s + m + 1]) mod q
 */
public class rabinmatcher {
	public void matcher(String T,String P,int d,int q){
		int n=T.length();
		int m=P.length();
		int h=(int)Math.pow(d,(m))%q;
		int p=0;
		int[] t= new int[n-m+1];
		t[0]=0;
		int control=0;
		for(int i=0;i<m;i++){
			p=((d*p)+P.charAt(i))%q;
			t[0]=((d*t[0])+T.charAt(i))%q;
			
		}
		for(int s=0;s<=n-m;s++){
			if(p==t[s]){
				int l=0;
				for(;l<m;l++){
					if(P.charAt(l)==T.charAt(l+s)){
						
					}
					else{l=m+1;}
				}
				if(l==m){
					control=1;
					System.out.println(P + " occurs with shift " + s + " in "+ T);
				}
			}
			if(s<n-m){
				t[s+1]=(d*(t[s]-T.charAt(s)*h)+T.charAt(s+m))%q;
			}
		}
		if(control==0){
			System.out.println("There is no match");
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rabinmatcher ornek=new rabinmatcher();
		ornek.matcher("aykutozat", "sdgth", 26, 13);
		ornek.matcher("aykutozat", "oz", 26, 13);
		ornek.matcher("aykutozat", "ykut", 26, 13);
		ornek.matcher("aaaabbcddss", "aabb", 26, 13);
		ornek.matcher("abbrsgcccýr", "gcc", 26, 13);

	}

}
