import java.util.ArrayList;
import java.util.Vector;

import edu.bilgics.GraphADT.*;


public class SCC {
	IGraph g;
	boolean root;
	int index;
	int c;
	Vector<IVertex> S=new Vector<IVertex>();
	ArrayList<IVertex> a=new ArrayList<IVertex>();
	public SCC() {
		// TODO Auto-generated constructor stub
	}
	// from GraphDemo
	public static ArrayList<IVertex> getAllAdjacentVertices(IGraph g, IVertex v) {
		// Create an empty result list
		ArrayList<IVertex> res = new ArrayList<IVertex>();
		/*
		 * Get the first edge and start iterating iterating through all edges
		 * check if other side is adjacent
		 */
		IEdge edge = null;
		try {
			try {
				edge = g.getFirstEdge();
			} catch (EmptyVerticeSetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (edge != null) {
				// if the edge originates from v
				if (edge.getOriginatingVertex().equals(v)) {
					// add the other side to the result list
					res.add(edge.getDestinationVertex());
				}
				// continue iteration
				try {
					edge = g.getNextEdge();
				} catch (EmptyVerticeSetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (EmptyGraphException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	public void visit(IVertex v){
		root=true;
		v.setVisited(true);
		v.setRindex(index);
		index++;
		v.inCompenent(false);
		for(IVertex w:getAllAdjacentVertices(g, v)){
			if(!w.isVisited()){
				visit(w);
			}
			if(!w.getCompenent()&&(w.getRindex()<v.getRindex())){
				v.setRindex(w.getRindex());
				root=false;
			}
		}
		if(root){
			v.inCompenent(true);
			while(!S.isEmpty()&&(v.getRindex()<=S.firstElement().getRindex())){
				IVertex w;
				w=S.firstElement();
				S.remove(S.firstElement());
				w.setRindex(c);
				w.inCompenent(true);
				
			}
			v.setRindex(c);
			c++;
		}
		else{
			S.add(v);
		}	
		a.add(v);
		
	}
	
	public void scc(){
		IVertex v;
		try {
			v=g.getFirstVertex();
			while(v!=null){
				v.setVisited(false);
			v=g.getNextVertex();	
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		index=0;
		c=0;
		try {
			v=g.getFirstVertex();
			while(v!=null){
				if(!v.isVisited()){
					visit(v);
				}
				v=g.getNextVertex();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		IGraph graph1 = new Graph(); 
		IVertex A = new Vertex("A");
		IVertex B = new Vertex("B");
		IVertex C = new Vertex("C");
		IVertex D = new Vertex("D");
		IVertex E = new Vertex("E");
		IVertex F = new Vertex("F");
		IVertex G = new Vertex("G");
		try {
			graph1.addVertex(A);
			graph1.addVertex(B);
			graph1.addVertex(C);
			graph1.addVertex(D);
			graph1.addVertex(E);
			graph1.addVertex(F);
			graph1.addVertex(G);
			//graph1.addVertex(H);			
		} catch (DuplicateGraphElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IEdge AB = new Edge(A, B);
		IEdge BC = new Edge(B, C);
		IEdge CA = new Edge(C, A);
		IEdge CD = new Edge(C, D);
		IEdge DE = new Edge(D, E);
		IEdge ED = new Edge(E, D);
		IEdge EF = new Edge(E, F);
		IEdge FG = new Edge(F, G);
		IEdge GF = new Edge(G, F);
		try {
			graph1.addEdge(AB);
			graph1.addEdge(BC);
			graph1.addEdge(CA);
			graph1.addEdge(CD);
			graph1.addEdge(DE);
			graph1.addEdge(ED);
			graph1.addEdge(EF);
			graph1.addEdge(FG);
			graph1.addEdge(GF);
		} catch (DuplicateGraphElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoAssociatedVerticeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(graph1);
		
		SCC s=new SCC();
		s.g=graph1;
		String s1="";
		String s2="";
		String s3="";
		s.scc();
		try {	
			for(int i=s.a.size()-1;i>=0;i--){
				if(s.a.get(i).getRindex()==0){
					s1=s1+" "+s.a.get(i);
				}
				if(s.a.get(i).getRindex()==3){
					s2=s2+" "+s.a.get(i);
				}
				if(s.a.get(i).getRindex()==5){
					s3=s3+" "+s.a.get(i);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(s1+"==>"+s2+"==>"+s3);

		
	}

}
