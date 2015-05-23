


public class Karatsuba {
	
	public static String subtractof(String x,String y){
		int d=x.length()-y.length();
		if(d!=0){
			if(d<0){
				x=addToHead(x, -d);
			}
			else{
				y=addToHead(y, d);
			}
		}
		char[] cx=x.toCharArray();
		char[] cy=y.toCharArray();
		String r="";
		char b='0';
		for(int i=cx.length-1;i>=0;i--){
			String f=""+(cx[i]-b);
			String s=""+cy[i];
			int sub=0;
			if(Integer.parseInt(f)-Integer.parseInt(s)<0){
				b='1';
				sub=Integer.parseInt(f)+10;
				sub=sub-Integer.parseInt(s);
				r=sub+r;
			}
			else{
				b='0';
				sub=Integer.parseInt(f)-Integer.parseInt(s);
				r=sub+r;
			}
			
		}
		return r;
	}
	
	
	public static String sumof(String x,String y){
		int d=x.length()-y.length();
		if(d!=0){
			if(d<0){
				x=addToHead(x, -d);
			}
			else{
				y=addToHead(y, d);
			}
		}
		char[] cx=x.toCharArray();
		char[] cy=y.toCharArray();
		String r="";
		char c='0';
		for(int i=cx.length-1;i>=0;i--){
			String f=""+cx[i];
			String s=""+cy[i];
			String ca=""+c;
			int sum=Integer.parseInt(f)+Integer.parseInt(s)+Integer.parseInt(ca);
			if(sum>9){
				c='1';
				r=(sum-10)+r;
			}
			else{
				c='0';
				r=sum+r;
			}
		}
		if(c=='1'){
			r="1"+r;
		}
		
		return r;
		
	}
	
	public static String addToend(String x, int n){
		for(;n>0;n--){
			x=x+"0";
		}
		return x;
	}
	
	public static String addToHead(String x, int n){
		for(;n>0;n--){
			x="0"+x;
		}
		return x;
	}
	
	public static String getZeros(String y){
		 String res = y;
		    while (res.startsWith("0")){
		      res = res.substring(1);
		      }
		    return res;
	}
	
	public static String multiplication(String x, String y){
		//String f=Integer.toString(x);
		//String s=Integer.toString(y);
		int d=x.length()-y.length();
		int n;
		if(d!=0){
			if(d<0){
				x=addToHead(x, -d);
			}
			else{
				y=addToHead(y, d);
			}
		}
		
		if(x.length()<=2){
			return Integer.toString(Integer.parseInt(x)* Integer.parseInt(y));
		}
		else{
			if(x.length()%2==1){
				x=addToHead(x, 1);
				y=addToHead(y, 1);
			}
			n=x.length();
			String x1=x.substring(0,n/2);
			String x2=x.substring(n/2,n);
			String y1=y.substring(0,n/2);
			String y2=y.substring(n/2,n);
			
			// from Wikipedia
			// Let X = x1y1 
			String X=multiplication(x1,y1);
			// Let Y = x2y2
			String Y=multiplication(x2,y2);
			// Let Z = (x1 + x2)(y1 + y2) - X - Y
			//     Z = (x1y1 + x1y2 + x2y1 + x2y2) - x1y1 - x2y2= x1y2 + x2y1
			String Z=subtractof(multiplication(sumof(x1, x2),sumof(y1, y2)),(sumof(multiplication(x1,y1),multiplication(x2,y2))));
			
			
			return sumof(sumof(addToend(X,n),Y), addToend(Z, n/2));
		}
		
	}
	public static String karatsuba(int n,int m){
		String x=Integer.toString(n);
		String y=Integer.toString(m);
		return getZeros(multiplication(x, y));
	} 
	public static void main(String[] args) {
		System.out.println(addToend("231", 1));

		System.out.println("Java's result ==> "+(34214*32412)+"   "+" Karatsuba's result ==> "+karatsuba(34214, 32412));
		
		System.out.println("Java's result ==> "+(74212*214)+"   "+" Karatsuba's result ==> "+karatsuba(74212,214));
		
		System.out.println("Java's result ==> "+(2390*92152)+"   "+" Karatsuba's result ==> "+karatsuba(2390, 92152));

		System.out.println("Java's result ==> (3421412* 332412)"+" Java can't calculate"+"   "+" Karatsuba's result ==> "+karatsuba(3421412, 332412));


	}
}
