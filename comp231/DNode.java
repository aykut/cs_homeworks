
public class DNode {
	int data;
	DNode next;
	DNode prev;
	DNode(int data){
		this.data=data;
		next=null;
		prev=null;
	}
    public static String nToS(DNode n)
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
        String s = " ";
        s+=data;        
        s+=nToS(next); 
        return s+" ";
    }
}
