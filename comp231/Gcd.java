
public class Gcd {
	Gcd(){}
	public int gcd(int a,int b)throws Exception{
		if(a<=0||b<=0){
			throw new Exception();
	}
	else{
		while(a!=b){
			if(a<b){
				b=b-a;
			}
			else{
				a=a-b;
			}
		}return a;
	}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gcd ornek=new Gcd();
		try{
			System.out.println(ornek.gcd(15, 120));
			System.out.println(ornek.gcd(100, 12));
			System.out.println(ornek.gcd(37, 65));
			System.out.println(ornek.gcd(1,1));
			System.out.println(ornek.gcd(-15, 0));
			}catch(Exception e){
				e.printStackTrace();
		System.out.println("0 veya 0'dan kucuk sayý girdiniz");
			}

	}

}
