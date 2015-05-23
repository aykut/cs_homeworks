/*   			ì  	index of the last occurrence  	if c is in P
	last(c) =  	í 	of c in pattern P 	 
  				î 	-1 	otherwise
  				m <- P.length;
  				n <- T.length;
	 * 1.  Compute function last
	   2. i <- m-1
	   3. j <- m-1
	   4. Repeat
	   5.     if P[j] = T[i] then
	   6.         if j=0 then
	   7.             return i        // we have a match
	   8.         else
	   9.             i <- i -1
	  10.             j <- j -1
	  11.     else
	  12.         i <- i + m -min(j, 1 + last[T[i]])
	  13.         j <- m -1
	  14. until i > n -1
	  15. Return "no match"*/
public class BoyerMoore {
	public int last(char x,String P){
		for(int i=P.length()-1;i>=0;i--){
			if(P.charAt(i)==x){
				return i;
			}
		}
		return -1;
	}
	public int BoyerMatch(String T,String P){
		int n=T.length();
		int m=P.length();
		int i=m-1;
		int j=m-1;
		while(i<=n-1){
			if(P.charAt(j)==T.charAt(i)){
				if(j==0){
					System.out.println(i);
					return i;
				}
				else{
					i=i-1;
					j=j-1;
				}
			}
			else{
				i=i+m-Math.min(j,1+last(T.charAt(i),P));
				j=m-1;
			}
		}
		System.out.println("There is no match");
		return -1;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoyerMoore ornek=new BoyerMoore();
		ornek.BoyerMatch("aykutozat", "oz");
		ornek.BoyerMatch("ipoabctrsehyab", "ab");
		ornek.BoyerMatch("abcdekyt", "dek");
		ornek.BoyerMatch("aykutozat", "ali");

	}

}
