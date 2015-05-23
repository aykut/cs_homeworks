
public class DelTree {
	int data;
	DelTree right;
	DelTree left;
	DelTree parent;
	DelTree(int data){
		this.data=data;
		right=null;
		left=null;
		parent=null;
	}
    public static String nToS(DelTree n)
    {
        if(n == null)
            {
                return "";
            }
        else
            {
                return n.toString();
            }
    }

    public String toString()
    {
        String s = "(";
        s+=nToS(left); 
        s+=data;        
        s+=nToS(right); 
        return s+")";
    }

}

