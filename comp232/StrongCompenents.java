import java.util.ArrayList;

import edu.bilgics.GraphADT.*;


public class StrongCompenents {
	int time=0;
	IGraph g;
	ArrayList<IVertex> l=new ArrayList<IVertex>();
	public StrongCompenents() {
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
	
	
	public void dfsVisit(IVertex u){
		u.setColour("Gray");
		time=time+1;
		u.setDi(time);
		for(IVertex v : getAllAdjacentVertices(g, u)){
			if(v.getColour()=="White"){
				v.setPi(u);
				dfsVisit(v);
			}
		}
		u.setColour("Black");
		l.add(u);
		time=time+1;
		u.setF(time);
		
	}
	
	public void dfs(IGraph g){
		IVertex u;
		try {
			u=g.getFirstVertex();
			while(u!=null){
				u.setColour("White");
				u.setPi(null);
				u=g.getNextVertex();
			}
			time=0;
			u=g.getFirstVertex();
			while(u!=null){
				if(u.getColour()=="White"){
					dfsVisit(u);
				}
				u=g.getNextVertex();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void dfsT(IGraph g){
		IVertex u;
		try {
			u=g.getFirstVertex();
			while(u!=null){
				u.setColour("White");
				u.setPi(null);
				u=g.getNextVertex();
			}
			time=0;
			u=g.getFirstVertex();
			while(u!=null){
				if(u.getColour()=="White"){
					dfsVisit(u);
				}
				u=g.getNextVertex();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void computeGT(IGraph g){
		try {
			IVertex v=g.getFirstVertex();
			IEdge edge=g.getFirstEdge();
			while(edge!=null){
				v=edge.getDestinationVertex();
				edge.setDestinationVertex(edge.getOriginatingVertex());
				edge.setOriginatingVertex(v);
				edge=g.getNextEdge();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void stronglyComp(IGraph g){
		dfs(g);
		computeGT(g);
		dfsT(g);
	}
	public static void main(String[] args) {
		IGraph g=new Graph();
		
		IVertex A=new Vertex("A");
		IVertex B=new Vertex("B");
		IVertex C=new Vertex("C");
		IVertex D=new Vertex("D");
		
		try {
			g.addVertex(A);
			g.addVertex(B);
			g.addVertex(C);
			g.addVertex(D);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge AB=new Edge(A,B);
		IEdge AD=new Edge(A,D);
		IEdge BD=new Edge(B,D);
		IEdge CD=new Edge(C,D);
		IEdge CB=new Edge(C,B);
		
		try {
			g.addEdge(AB);
			g.addEdge(AD);
			g.addEdge(BD);
			g.addEdge(CD);
			g.addEdge(CB);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(g);
		
		StrongCompenents s=new StrongCompenents();
		s.g=g;
		
		s.computeGT(g);
		System.out.println(g);
		
	}

}
