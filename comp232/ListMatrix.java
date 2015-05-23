import java.util.ArrayList;


public class ListMatrix {
	ArrayList arr;
	public ListMatrix() {
		arr=new ArrayList();
		// TODO Auto-generated constructor stub
	}
	public void find(ArrayList m){
		for(int i=0;i<m.size();i++){
			ArrayList arr1=new ArrayList();
			for(int k=0;k<m.size();k++){
				arr1.add(0);}
			ArrayList tmp=(ArrayList)m.get(i);
			for(int j=1;j<tmp.size();j++){
				arr1.set((Integer)tmp.get(j)-1,1);
			}
			arr.add(arr1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListMatrix ornek=new ListMatrix();
		ArrayList exarr=new ArrayList();
		exarr.add(1);
		exarr.add(2);
		exarr.add(5);
		ArrayList exarr1=new ArrayList();
		exarr1.add(2);
		exarr1.add(1);
		exarr1.add(3);
		exarr1.add(4);
		exarr1.add(5);
		ArrayList exarr2=new ArrayList();
		exarr2.add(3);
		exarr2.add(2);
		exarr2.add(4);
		ArrayList exarr3=new ArrayList();
		exarr3.add(4);
		exarr3.add(2);
		exarr3.add(3);
		exarr3.add(5);
		ArrayList exarr4=new ArrayList();
		exarr4.add(5);
		exarr4.add(1);
		exarr4.add(2);
		exarr4.add(4);
		ArrayList exarr5=new ArrayList();
		exarr5.add(exarr);
		exarr5.add(exarr1);
		exarr5.add(exarr2);
		exarr5.add(exarr3);
		exarr5.add(exarr4);
		ornek.find(exarr5);
		for(int i=0;i<ornek.arr.size();i++){
			ArrayList tmp=(ArrayList)ornek.arr.get(i);
			String s="";
			for(int j=0;j<tmp.size();j++){
				s=s+" "+tmp.get(j);
		}				System.out.println(s);

	}
		System.out.println("////////////////");
		System.out.println("////////////////");
		
		
		ListMatrix ornek1=new ListMatrix();
		ArrayList ex=new ArrayList();
		ex.add(1);
		ex.add(2);
		ex.add(4);
		ArrayList ex1=new ArrayList();
		ex1.add(2);
		ex1.add(5);
		ArrayList ex2=new ArrayList();
		ex2.add(3);
		ex2.add(6);
		ex2.add(5);
		ArrayList ex3=new ArrayList();
		ex3.add(4);
		ex3.add(2);
		ArrayList ex4=new ArrayList();
		ex4.add(5);
		ex4.add(4);
		ArrayList ex6=new ArrayList();
		ex6.add(6);
		ex6.add(6);
		ArrayList ex5=new ArrayList();
		ex5.add(ex);
		ex5.add(ex1);
		ex5.add(ex2);
		ex5.add(ex3);
		ex5.add(ex4);
		ex5.add(ex6);
		ornek1.find(ex5);
		for(int i=0;i<ornek1.arr.size();i++){
			ArrayList tmp=(ArrayList)ornek1.arr.get(i);
			String s="";
			for(int j=0;j<tmp.size();j++){
				s=s+" "+tmp.get(j);
		}				System.out.println(s);

	}
		System.out.println("////////////////");
		System.out.println("////////////////");
		
		
		ListMatrix ornek2=new ListMatrix();
		ArrayList e=new ArrayList();
		e.add(1);
		e.add(2);
		ArrayList e1=new ArrayList();
		e1.add(2);
		e1.add(2);
		e1.add(3);
		ArrayList e2=new ArrayList();
		e2.add(3);
		e2.add(2);
		ArrayList e3=new ArrayList();
		e3.add(e);
		e3.add(e1);
		e3.add(e2);
		ornek2.find(e3);
		for(int i=0;i<ornek2.arr.size();i++){
			ArrayList tmp=(ArrayList)ornek2.arr.get(i);
			String s="";
			for(int j=0;j<tmp.size();j++){
				s=s+" "+tmp.get(j);
		}				System.out.println(s);

	}
	}

}
