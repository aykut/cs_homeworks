

public class Node {
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		next=null;
	}
    public static String nToS(Node n)
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

