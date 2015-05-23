

public class InsertTree {
	DelTree root;
	InsertTree(){}
	
	public DelTree Tree_min(DelTree x){
		while(x.left!=null){
			x=x.left;
		}return x;
	}
	public DelTree Tree_Suc(DelTree x){
		DelTree y;
		if(x.right!=null){
			return Tree_min(x.right);
		}
		y=x.parent;
		while(y!=null&&x==y.right){
			x=y;
			y=y.parent;
		}
		return y;
	}
	public void Tree_insert(InsertTree T,DelTree z){
		DelTree y=null;
		DelTree x=T.root;
		while(x!=null){
			y=x;
			if(z.data<x.data){
				x=x.left;
			}
			else{
				x=x.right;
			}
		}
		z.parent=y;
		if(y==null){
			T.root=z;
		}
		else if(z.data<y.data){
			y.left=z;
		}
		else{
			y.right=z;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteTree ornek=new DeleteTree();
		DelTree z=new DelTree(20);
		DelTree z1=new DelTree(40);
		DelTree z2=new DelTree(30);
		DelTree z3=new DelTree(10);
		DelTree z4=new DelTree(5);
		ornek.Tree_insert(ornek,z);
		System.out.println(ornek.root.toString());
		ornek.Tree_insert(ornek,z1);
		System.out.println(ornek.root.toString());
		ornek.Tree_insert(ornek,z2);
		System.out.println(ornek.root.toString());
		ornek.Tree_insert(ornek,z3);
		System.out.println(ornek.root.toString());
		ornek.Tree_insert(ornek,z4);
		System.out.println(ornek.root.toString());

	}

}
