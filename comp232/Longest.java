
public class Longest {
	int k;
	String s;
	int control;
	public Longest() {
		// TODO Auto-generated constructor stub
		k=0;
		s="";
		control=0;
	}
	public String match(String x,char y){
		int m=x.length();
		for(int i=0;i<m;i++,k++){
			if(x.charAt(i)==y){
				s=s+y;
				k=i;
				control=1;
				return s;
			}
		}
		control=0;
		return s;
	}
	public String find(String x,String y){
		int n=y.length();
		for(int j=0;j<n;j++){
			s=match(x,y.charAt(j));
			if(control==0){
				return find(x,y.substring(j+1));
				}
			else{
				return find(x.substring(this.k+1),y.substring(j+1));
			}
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest ornek=new Longest();
		System.out.println(ornek.find("oazyaktut", "aykut"));

	}

}
