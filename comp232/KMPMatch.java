import java.util.ArrayList;
/*
KMP MATCHER(T, P)
1 n = length[T ]
2 m = length[P]
3 pi = COMPUTE PREFIX MATCHER(P)
4 q = 0
5 for i = 1 to n
6 	do while q > 0 and P[q + 1] != T [i ]
7 		do q= pi[q]
8 	if P[q + 1] = T [i ]
9 		then q = q +1
10 	if q = m 
11 		then print "Pattern occurs with shift" i-m
12 			q = pi[q]
COMPUTE PREFIX FUNCTION(P)
1 m = length[P]
2 pi[1] = 0
3 k = 0
4 for q = 2 to m
5 do while k > 0 and P[k + 1] != P[q]
6 do k = pi[k]
7 if P[k + 1] = P[q]
8 then k = k + 1
9 pi[q] = k
10 return pi
*/

public class KMPMatch {
	ArrayList pi=new ArrayList();
	int m;
	int n;
	int q;
	int k;
	public void KMPMATCHER(String T,String P){
		for(int z=0;z<99;z++){
			pi.add(0);
		}
		n=T.length();
		m=P.length();
		pi=Compute(P);
		q=0;
		boolean d=false;
		for(int i=0;i<n;i++){
			while (q>0&P.charAt(q+1)!= T.charAt(i)){
				q=(Integer)pi.get(q);}
			if(P.charAt(q+1)==T.charAt(i)){
				q=q+1;
			}
			if(q==m-1){
				System.out.println("Pattern occurs with shift"+" "+(i-m+1));
				d=true;
				q=(Integer)pi.get(q);
			}
		}
		if(d==false){
			System.out.println("there is no match");
		}
	}
	
	public ArrayList Compute(String P){
		m=P.length();
		pi.set(1,0);
		k=0;
		for(q=2;q<m;q++){
			while(k>0&P.charAt(k + 1)!= P.charAt(q)){
				k=(Integer)pi.get(k);
			}
			if(P.charAt(k+1)==P.charAt(q)){
				k=k+1;
			}
			pi.set(q,k);
		}
		return pi;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMPMatch ornek=new KMPMatch();
		ornek.KMPMATCHER("abcdesfrt", "desfr");
		ornek.KMPMATCHER("oreytsnbg", "wrt");
		ornek.KMPMATCHER("ipoabctrsehyab", "ab");
		ornek.KMPMATCHER("aykutozat", "ali");
		ornek.KMPMATCHER("aykutozat", "kut");

	}

	
}
