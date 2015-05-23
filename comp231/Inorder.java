
public class Inorder {
	TraNode root;
	Inorder(TraNode root){
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
	public String inorderT(TraNode t){
		String s="";
		if(t==null){
			return s;
		}
		else{
			return s=s+inorderT(t.left)+" "+t.data+" "+inorderT(t.right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inorder tes1=new Inorder(null);		
		tes1.insert(new TraNode(100,null,null));
		tes1.insert(new TraNode(60,null,null));
		tes1.insert(new TraNode(122,null,null));
		tes1.insert(new TraNode(54,null,null));
		tes1.insert(new TraNode(86,null,null));
		tes1.insert(new TraNode(314,null,null));
		tes1.insert(new TraNode(57,null,null));
		tes1.insert(new TraNode(27,null,null));
		System.out.println(tes1.inorderT(tes1.root));
		Inorder tes2=new Inorder(null);		
		tes2.insert(new TraNode(0,null,null));
		tes2.insert(new TraNode(14,null,null));
		tes2.insert(new TraNode(12,null,null));
		tes2.insert(new TraNode(1,null,null));
		tes2.insert(new TraNode(3,null,null));
		tes2.insert(new TraNode(34,null,null));
		tes2.insert(new TraNode(7,null,null));
		tes2.insert(new TraNode(2,null,null));
		System.out.println(tes2.inorderT(tes2.root));
		Inorder tes3=new Inorder(null);		
		tes3.insert(new TraNode(789,null,null));
		tes3.insert(new TraNode(-14,null,null));
		tes3.insert(new TraNode(-13,null,null));
		tes3.insert(new TraNode(19,null,null));
		tes3.insert(new TraNode(23,null,null));
		tes3.insert(new TraNode(4,null,null));
		tes3.insert(new TraNode(70,null,null));
		tes3.insert(new TraNode(62,null,null));
		System.out.println(tes3.inorderT(tes3.root));


	}

}
