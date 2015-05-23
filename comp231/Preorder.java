
public class Preorder {
	TraNode root;
	Preorder(TraNode root){
		this.root=root;
	}
	public void insert(TraNode gelen){
		TraNode tmp=root;
		if(gelen!=null){
		if(root==null){
			root=gelen;
			
		}
		else{
		while(tmp!=null){
		if(gelen.data<=tmp.data){
			if(tmp.left==null){
				tmp.left=gelen;
				break;
			}
			else{
				tmp=tmp.left;
			}
		}
		else if(tmp.right==null){
			tmp.right=gelen;
			break;
		}
		else{
			tmp=tmp.right;
		}
		}
		}
	}
		}
	public String preorderT(TraNode t){
		String s="";
		if(t==null){
			return s;
		}
		else{
			return s=s+t.data+" "+preorderT(t.left)+preorderT(t.right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Preorder tes1=new Preorder(null);		
		tes1.insert(new TraNode(100,null,null));
		tes1.insert(new TraNode(60,null,null));
		tes1.insert(new TraNode(122,null,null));
		tes1.insert(new TraNode(54,null,null));
		tes1.insert(new TraNode(86,null,null));
		tes1.insert(new TraNode(314,null,null));
		tes1.insert(new TraNode(57,null,null));
		tes1.insert(new TraNode(27,null,null));
		System.out.println(tes1.preorderT(tes1.root));
		Preorder tes2=new Preorder(null);		
		tes2.insert(new TraNode(0,null,null));
		tes2.insert(new TraNode(14,null,null));
		tes2.insert(new TraNode(12,null,null));
		tes2.insert(new TraNode(1,null,null));
		tes2.insert(new TraNode(3,null,null));
		tes2.insert(new TraNode(34,null,null));
		tes2.insert(new TraNode(7,null,null));
		tes2.insert(new TraNode(2,null,null));
		System.out.println(tes2.preorderT(tes2.root));
		Preorder tes3=new Preorder(null);		
		tes3.insert(new TraNode(789,null,null));
		tes3.insert(new TraNode(-14,null,null));
		tes3.insert(new TraNode(-13,null,null));
		tes3.insert(new TraNode(19,null,null));
		tes3.insert(new TraNode(23,null,null));
		tes3.insert(new TraNode(4,null,null));
		tes3.insert(new TraNode(70,null,null));
		tes3.insert(new TraNode(62,null,null));
		System.out.println(tes3.preorderT(tes3.root));

	}

}
