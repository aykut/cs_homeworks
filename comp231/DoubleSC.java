import java.util.Date;


public class DoubleSC {
	DNode head;
	DNode tail;
	public DoubleSC(){
		head=null;
		tail=null;
	}
    public String toString(){
    	DNode tmp=head;
    	String s = " ";
    	while(tmp.next!=head){
        s=s+tmp.data+" ";         
        tmp=tmp.next;
    	}s=s+tail.data;
    	return s;
    }
	public void normal_cons(int gelen){
		DNode tmp=new DNode(gelen);
		if(head==null){
			head=tmp;
			tail=tmp;
			tail.prev=head;
			tail.next=head;
			head.next=tail;
			head.prev=tail;
		}
		else{
			tail.next=tmp;
			tmp.prev=tail;
			tmp.next=head;
			head.prev=tmp;
			head=tmp;
		}
	}
	public Object  nil(){
		return null;
	}
	public void cons(int gelen){
		DNode tmp=new DNode(gelen);
		DNode tmp1=head;
		if(head==null){
			head=tmp;
			tail=tmp;
			tail.prev=head;
			tail.next=head;
			head.next=tail;
			head.prev=tail;
		}
		else{
			if(head.data>=gelen){
				tail.next=tmp;
				tmp.prev=tail;
				tmp.next=head;
				head.prev=tmp;
				head=tmp;
		}
			else{
			if(head.data<gelen&tmp1.next==head){
				tail.next=tmp;
				tmp.prev=tail;
				tmp.next=head;
				head.prev=tmp;
				tail=tmp;
			}
			else{
			while(tmp1.next!=head){
				if(tmp1.next.data>=gelen){
					tmp.prev=tmp1;
					tmp.next=tmp1.next;
					tmp1.next.prev=tmp;
					tmp1.next=tmp;
					break;
				}
				else{
					tmp1=tmp1.next;
				}
			}if(tail.data<gelen){
				tail.next=tmp;
			tmp.next=head;
			tmp.prev=tail;
			head.prev=tmp;
			tail=tmp;
			}
			else{}
			}
		}
	}
	}

	public int length(){
		DNode tmp=head;
		int say=0;
		while(tmp.next!=head){
			say=say+1;
			tmp=tmp.next;
		}return say+1;
	}
	public void delFirst(int x){
		DNode tmp=head;
		if(tmp.data==x){
			head=head.next;
			head.prev=tail;
		}
		else{
		while(tmp.next!=head){
			if(tmp.next.data==x){
			tmp.next=tmp.next.next;
			if(tmp.next!=null){tmp.next.prev=tmp;}
			else{}
			break;
			}
			else {
				tmp=tmp.next;
			}
		}
	}
		}

	public DoubleSC reverse(){
		DNode tmp=head;
		DoubleSC tmp1=new DoubleSC();
		while(tmp.next!=head){
			tmp1.normal_cons(tmp.data);
			tmp=tmp.next;
		}
		tmp1.normal_cons(tail.data);
		return tmp1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("DOUBLE SORTED NOT CIRCULAR");
		long tmp;
		Date firstTime ;
		Date secondTime ;
		DoubleSC ornek=new DoubleSC();
		DoubleSC ornek_10=new DoubleSC();
		DoubleSC ornek_50=new DoubleSC();
		DoubleSC ornek_100=new DoubleSC();
		DoubleSC ornek_500=new DoubleSC();
		DoubleSC ornek_1000=new DoubleSC();
		DoubleSC ornek_5000=new DoubleSC();
		DoubleSC ornek_10000=new DoubleSC();
		DoubleSC ornek_50000=new DoubleSC();
		DoubleSC ornek_100000=new DoubleSC();
		firstTime= new Date(); 
		for(int i=0;i<10;i++){
			ornek_10.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 10 input, the time is " +tmp);
		
		
		firstTime= new Date(); 
		for(int i=0;i<50;i++){
			ornek_50.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 50 input, the time is " +tmp);
		
		
		firstTime= new Date(); 
		for(int i=0;i<100;i++){
			ornek_100.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 100 input, the time is " +tmp);
		
		firstTime= new Date(); 
		for(int i=0;i<500;i++){
			ornek_500.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 500 input, the time is " +tmp);
		
		
		firstTime= new Date(); 
		for(int i=0;i<1000;i++){
			ornek_1000.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 1000 input, the time is " +tmp);

		firstTime= new Date(); 
		for(int i=0;i<5000;i++){
			ornek_5000.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 5000 input, the time is " +tmp);
		
		firstTime= new Date(); 
		for(int i=0;i<10000;i++){
			ornek_10000.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 10000 input, the time is " +tmp);
		
		firstTime= new Date(); 
		for(int i=0;i<50000;i++){
			ornek_50000.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 50000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		for(int i=0;i<100000;i++){
			ornek_100000.cons((int)(Math.random()*100));
		}
		secondTime = new Date();  
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("CONS for 100000 input, the time is " +tmp);
		
		
		System.out.println("//// LENGTH");
		firstTime = new Date(); 
		ornek_10.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 10 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_50.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 50 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_100.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 100 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_500.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 500 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_1000.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 1000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_5000.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 5000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_10000.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 10000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_50000.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 50000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_100000.length();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("LENGTH for 100000 input, the time is " +tmp);
		
		
		System.out.println("//// DELFIRST");
		firstTime = new Date(); 
		ornek_10.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 10 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_50.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 50 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_100.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 100 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_500.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 500 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_1000.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 1000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_5000.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 5000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_10000.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 10000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_50000.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 50000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_100000.delFirst(30);
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("DELFIRST for 100000 input, the time is " +tmp);
		
		System.out.println("//// REVERSE");
		firstTime = new Date(); 
		ornek_10.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 10 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_50.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 50 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_100.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 100 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_500.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 500 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_1000.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 1000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_5000.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 5000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_10000.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 10000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_50000.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 50000 input, the time is " +tmp);
		
		firstTime = new Date(); 
		ornek_100000.reverse();
		secondTime = new Date(); 
		tmp=secondTime.getTime()-firstTime.getTime();
		System.out.println("REVERSE for 100000 input, the time is " +tmp);
		
		System.out.println("NORMAL ÖRNEK");
		System.out.println("///cons baslangic");
		ornek.cons(2);
		ornek.cons(2);
		ornek.cons(3);
		ornek.cons(3);
		ornek.cons(4);
		System.out.println(ornek.toString());
		System.out.println(" cons bitis///");
		System.out.println("///length baslangýc");
		System.out.println(ornek.length());
		System.out.println("length bitis///");
		System.out.println("///delFirst baslangýc");
		ornek.delFirst(2);
		System.out.println(ornek.toString());
		System.out.println("delFirst bitis///");
		System.out.println("///reverse baslangýc");
		System.out.println(ornek.toString());
		System.out.println(ornek.reverse().toString());
		System.out.println("reverse bitis///");

	}

}
