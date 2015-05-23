import java.util.ArrayList;
import java.util.Vector;

import edu.bilgics.GraphADT.*;


public class TopBfs {
	Vector<IVertex> q=new Vector<IVertex>();
	ArrayList<IVertex> l=new ArrayList<IVertex>();
	public TopBfs() {
		// TODO Auto-generated constructor stub
	}
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
	
	public void bfs(IGraph g,IVertex s){
		Double infinite=Double.POSITIVE_INFINITY;
		IVertex u;
		try {
			u=g.getFirstVertex();
			while(u!=null){
				u.setColour("White");
				u.setDouble(infinite);
				u.setPi(null);
				u=g.getNextVertex();
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		s.setColour("Gray");
		s.setDouble(0);
		s.setPi(null);
		try {
				q.add(s);
				while(!q.isEmpty()){
					u=q.firstElement();
					l.add(u);
				q.removeElement(q.firstElement());
				for (IVertex v : getAllAdjacentVertices(g, u)) {
					if(v.getColour()=="White"){
					v.setColour("Gray");
					v.setDouble(v.getDouble()+1);
					v.setPi(u);
					q.add(v);
					}
				}
				u.setColour("Black");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
	}
	public void topBfs(IGraph g){
		try {
			bfs(g, g.getFirstVertex());
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
		try {
			graph1.addVertex(A);
			graph1.addVertex(B);
			graph1.addVertex(C);
			graph1.addVertex(D);
			graph1.addVertex(E);
			graph1.addVertex(F);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge AB = new Edge(A, B);
		IEdge AC = new Edge(A, C);
		IEdge BE = new Edge(B, E);
		IEdge BD = new Edge(B, D);
		IEdge ED = new Edge(E, D);
		IEdge CE = new Edge(C, E);
		IEdge DF = new Edge(D, F);
		IEdge CF = new Edge(C, F);
		
		try {
			graph1.addEdge(AB);
			graph1.addEdge(AC);
			graph1.addEdge(CE);
			graph1.addEdge(BD);
			graph1.addEdge(BE);
			graph1.addEdge(ED);
			graph1.addEdge(DF);
			graph1.addEdge(CF);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(graph1);
		
		TopBfs t=new TopBfs();
		t.topBfs(graph1);
		System.out.println(t.l.size());
		for(int i=0;i<t.l.size();i++){
			System.out.println(t.l.get(i));	
		}
		
	}

}
