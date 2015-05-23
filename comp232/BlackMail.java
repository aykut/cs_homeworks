import java.util.ArrayList;

import edu.bilgics.GraphADT.*;


public class BlackMail {
	int time;
	IGraph g=null;
	ArrayList<IVertex> l=new ArrayList<IVertex>();
	public BlackMail() {
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
	
	
	public void dfsVisit(IVertex u){
		u.setColour("Gray");
		for(IVertex v : getAllAdjacentVertices(g, u)){
			if(v.getColour()=="White"){
				v.setPi(u);
				dfsVisit(v);
			}
		}
		if(u.getPi()!=null){
			if(!u.getPi().getAdds().contains(u)){
			for(int i=0;i<u.getAdds().size();i++){
				if(!u.getPi().getAdds().contains(u.getAdds().get(i))){
					u.getPi().setAdds(u.getAdds().get(i));
				}
				}
			u.getPi().setAdds(u);
			}
			}
		u.setColour("White");
	}
	
	public IVertex decide(){
		int x=0;
		IVertex u=null;
		try {
			IVertex v=g.getFirstVertex();
			u=v;
			while(v!=null){
				if(v.getAdds().size()>x){
					x=v.getAdds().size();
					u=v;
				}
				v=g.getNextVertex();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u;
	}
	
	public void dfs(){
		IVertex u;
		try {
			u=g.getFirstVertex();
			while(u!=null){
				u.setColour("White");
				u.setPi(null);
				u=g.getNextVertex();
			}
			u=g.getFirstVertex();
			while(u!=null){
					dfsVisit(u);
				u=g.getNextVertex();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("The man we wish to hire  ==> "+decide());

	}
	public static void main(String[] args) {
		IGraph g=new Graph();
		
		IVertex A=new Vertex("A");
		IVertex B=new Vertex("B");
		IVertex C=new Vertex("C");
		IVertex D=new Vertex("D");
		IVertex E=new Vertex("E");
		IVertex F=new Vertex("F");
		IVertex G=new Vertex("G");
		IVertex H=new Vertex("H");
		
		
		try {
			g.addVertex(A);
			g.addVertex(B);
			g.addVertex(C);
			g.addVertex(D);
			g.addVertex(E);
			g.addVertex(F);
			g.addVertex(G);
			g.addVertex(H);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		IEdge BA=new Edge(B,A);
		IEdge AE=new Edge(A,E);
		IEdge BC=new Edge(B,C);
		IEdge BE=new Edge(B,E);
		IEdge DB=new Edge(D,B);
		IEdge DC=new Edge(D,C);		
		IEdge DG=new Edge(D,G);
		IEdge DH=new Edge(D,H);
		IEdge DF=new Edge(D,F);		
		
		try {
			g.addEdge(BA);
			g.addEdge(AE);
			g.addEdge(BC);
			g.addEdge(DB);
			g.addEdge(BE);
			g.addEdge(DC);
			g.addEdge(DF);
			g.addEdge(DG);
			g.addEdge(DH);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(g);
		
		BlackMail b=new BlackMail();
		
		b.g=g;
		
		b.dfs();
		
		

		IGraph graph=new Graph();
		
		IVertex S=new Vertex("S");
		IVertex T=new Vertex("T");
		IVertex X=new Vertex("X");
		IVertex Y=new Vertex("Y");
		IVertex Z=new Vertex("Z");
		IVertex W=new Vertex("W");
		
		try {
			graph.addVertex(S);
			graph.addVertex(T);
			graph.addVertex(X);
			graph.addVertex(Y);
			graph.addVertex(Z);
			graph.addVertex(W);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		IEdge ST=new Edge(S,T);
		IEdge SY=new Edge(S,Y);
		IEdge TX=new Edge(T,X);
		IEdge TY=new Edge(T,Y);
		IEdge YX=new Edge(Y,X);
		IEdge YZ=new Edge(Y,Z);
		IEdge XZ=new Edge(X,Z);
		IEdge WS=new Edge(W,S);
		
		try {
			graph.addEdge(ST);
			graph.addEdge(SY);
			graph.addEdge(TX);
			graph.addEdge(TY);
			graph.addEdge(YX);
			graph.addEdge(YZ);
			graph.addEdge(XZ);
			graph.addEdge(WS);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(graph);
		
		b.g=graph;
		
		b.dfs();
		
		
		IGraph graph1=new Graph();
		
		IVertex A1=new Vertex("A");
		IVertex B1=new Vertex("B");
		IVertex C1=new Vertex("C");
		IVertex D1=new Vertex("D");
		IVertex E1=new Vertex("E");
		IVertex F1=new Vertex("F");
		IVertex G1=new Vertex("G");
		IVertex S1=new Vertex("S");
		IVertex T1=new Vertex("T");
		IVertex X1=new Vertex("X");
		IVertex Y1=new Vertex("Y");
		IVertex Z1=new Vertex("Z");
		IVertex W1=new Vertex("W");
		
		try {
			graph1.addVertex(A1);
			graph1.addVertex(B1);
			graph1.addVertex(C1);
			graph1.addVertex(D1);
			graph1.addVertex(E1);
			graph1.addVertex(F1);
			graph1.addVertex(G1);
			graph1.addVertex(S1);
			graph1.addVertex(T1);
			graph1.addVertex(X1);
			graph1.addVertex(Y1);
			graph1.addVertex(Z1);
			graph1.addVertex(W1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		IEdge AB1=new Edge(A1,B1);
		IEdge AC1=new Edge(A1,C1);
		IEdge CB1=new Edge(C1,B1);
		IEdge BD1=new Edge(B1,D1);
		IEdge DE1=new Edge(D1,E1);
		IEdge DF1=new Edge(D1,F1);
		IEdge GS1=new Edge(G1,S1);
		IEdge GT1=new Edge(G1,T1);
		IEdge GX1=new Edge(G1,X1);
		IEdge GY1=new Edge(G1,Y1);
		IEdge GZ1=new Edge(G1,Z1);
		IEdge GW1=new Edge(G1,W1);
		
		try {
			graph1.addEdge(AB1);
			graph1.addEdge(AC1);
			graph1.addEdge(CB1);
			graph1.addEdge(BD1);
			graph1.addEdge(DE1);
			graph1.addEdge(DF1);
			graph1.addEdge(GS1);
			graph1.addEdge(GT1);
			graph1.addEdge(GX1);
			graph1.addEdge(GY1);
			graph1.addEdge(GZ1);
			graph1.addEdge(GW1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(graph1);
		
		b.g=graph1;
		
		b.dfs();
	}
	
}
