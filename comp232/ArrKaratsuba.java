import java.util.ArrayList;


public class ArrKaratsuba {
	
	public static ArrayList<Integer> sub(ArrayList<Integer> x, ArrayList<Integer> y){
		int d=x.size()-y.size();
		if(d!=0){
			if(d<0){
				x=Head(x, -d);
			}
			else{
				y=Head(y, d);
			}
		}

		ArrayList<Integer> a=new ArrayList<Integer>();
		int b= 0;
		for(int i=x.size()-1;i>=0;i--){

			int f=x.get(i)-b;
			int s=y.get(i);
			int sub=0;
			if(f-s<0){
				b=1;
				sub=f+10;
				sub=sub-s;
			    a=addFirst(a, sub);
			}
			else{
				b=0;
				sub=f-s;
				a=addFirst(a, sub);
			}
			
		}
		return a;
	}
	
	public static ArrayList<Integer> sum(ArrayList<Integer> x, ArrayList<Integer> y){
		int d=x.size()-y.size();
		if(d!=0){
			if(d<0){
				x=Head(x, -d);
			}
			else{
				y=Head(y, d);
			}
		}

		ArrayList<Integer> a=new ArrayList<Integer>();
		int c=0;
		for(int i=x.size()-1;i>=0;i--){
			int f=x.get(i);
			int s=y.get(i);
			int sum=f+s+c;
			if(sum>9){
				c=1;
				a=addFirst(a, sum-10);
			}
			else{
				c=0;
				a=addFirst(a, sum);
			}
		}
		if(c==1){
			a=addFirst(a, 1);
		}
		
		return a;
		
	}
	
	public static ArrayList<Integer> addFirst(ArrayList<Integer> x, int n){
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0,j=-1;i<=x.size();i++,j++){
			if(i==0){
				a.add(n);
			}
			else{
				a.add(x.get(j));
			}
		}
		return a;
	}
	public static ArrayList<Integer> end(ArrayList<Integer> x, int n){
		for(;n>0;n--){
			x.add(0);
		}
		return x;
	}
	
	public static ArrayList<Integer> Head(ArrayList<Integer> x, int n){
		for(;n>0;n--){
			x=addFirst(x, 0);
		}
		return x;
	}
	
	public static ArrayList<Integer> intToarr(int x){
		ArrayList<Integer> a=new ArrayList<Integer>();
		String s=Integer.toString(x);
		for(int i=0;i<s.length();i++){
			char n=s.charAt(i);
			String b=""+n;
			a.add(Integer.parseInt(b));
		}
		return a;
	}
	
	public static ArrayList<Integer> subArray(ArrayList<Integer> n, int x, int y){
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(;x<y;x++){
			a.add(n.get(x));
		}
		return a;
	}
	
	public static ArrayList<Integer> multiply(ArrayList<Integer> x, ArrayList<Integer> y){
		ArrayList<Integer> a=new ArrayList<Integer>();
		int d=x.size()-y.size();
		int n;
		if(d!=0){
			if(d<0){
				x=Head(x, -d);
			}
			else{
				y=Head(y, d);
			}
		}
		
		if(x.size()<=1){
			a=intToarr((x.get(0)*y.get(0)));
			return a;
		}
		else{
			if(x.size()%2==1){
				x=Head(x, 1);
				y=Head(y, 1);
			}
			n=x.size();
			ArrayList<Integer> x1=subArray(x, 0, n/2);
			ArrayList<Integer> x2=subArray(x, n/2, n);
			ArrayList<Integer> y1=subArray(y, 0, n/2);
			ArrayList<Integer> y2=subArray(y, n/2, n);
			

			
			ArrayList<Integer> X=multiply(x1,y1);
			
			ArrayList<Integer> Y=multiply(x2,y2);
			
			ArrayList<Integer> Z=sub(multiply(sum(x1, x2),sum(y1, y2)),(sum(multiply(x1,y1),multiply(x2,y2))));
			
			
			return sum(sum(end(X,n),Y), end(Z, n/2));
		}
		
	}
	
	public static String arrToStr(ArrayList<Integer> x){
		String s="";
		for(int i=0;i<x.size();i++){
			s=s+x.get(i);
		}
		return s;
	}
	
	public static String trim(ArrayList<Integer> x){
		ArrayList<Integer> y=x;
		    while (y.get(0)==0){
		      y.remove(0);
		      }
		    return arrToStr(y);
	}
	
	public static String karatsuba(int n,int m){
		ArrayList<Integer> x=intToarr(n);
		ArrayList<Integer> y=intToarr(m);
		return trim(multiply(x, y));
	} 
	public static void main(String[] args) {
		System.out.println(342352*2342);
		System.out.println(karatsuba(342352, 2342));

	}
}
