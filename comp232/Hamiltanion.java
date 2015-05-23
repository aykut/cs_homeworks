import java.util.ArrayList;

import edu.bilgics.GraphADT.*;


public class Hamiltanion {
	int d=0;
	int visit=0;
	ArrayList<IVertex> l=new ArrayList<IVertex>();
	IGraph g=null;
	boolean b=false;
	public Hamiltanion() {
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
	
	public void printPath(IVertex v){
		IVertex x=v;
		String s="";
		while(x!=null){
			s=x.getName()+" "+s;
			x=x.getPi();
		}
		System.out.println(s);
	}
	

	public void dfsVisit(IVertex u){
		u.setColour("Gray");
		d=d+1;
		visit++;
		u.setDi(d);
		for(IVertex v: getAllAdjacentVertices(g, u)){
			if(v.getColour()=="White"){
				v.setPi(u);
				dfsVisit(v);
			}
			else{
				if(v.getDi()==0&&visit==g.getVertices().size()){
					printPath(u);
					b=true;
				}
			}
		}
		u.setColour("White");
		d=d-1;
		visit--;
		u.setDi(0);
		u.setPi(null);
		
		
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
			d=-1;
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
		if(!b){
			System.out.println("There is no Hamilton cycle");
		}

	}
	public static void main(String[] args) {
		IGraph gr=new Graph();
		
		IVertex X=new Vertex("X");
		IVertex Y=new Vertex("Y");
		IVertex S=new Vertex("S");
		IVertex T=new Vertex("T");
		IVertex V=new Vertex("V");
		IVertex K=new Vertex("K");
		
		try {
			gr.addVertex(X);
			gr.addVertex(Y);
			gr.addVertex(S);
			gr.addVertex(T);
			gr.addVertex(V);
			gr.addVertex(K);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		IEdge XY=new Edge(X,Y);
		IEdge YX=new Edge(Y,X);
		IEdge SX=new Edge(S,X);
		IEdge XS=new Edge(X,S);
		IEdge YT=new Edge(Y,T);
		IEdge TY=new Edge(T,Y);
		IEdge YK=new Edge(Y,K);
		IEdge KY=new Edge(K,Y);
		IEdge KT=new Edge(K,T);
		IEdge TK=new Edge(T,K);
		IEdge KV=new Edge(K,V);
		IEdge VK=new Edge(V,K);
		IEdge VS=new Edge(V,S);
		IEdge SV=new Edge(S,V);
		IEdge TV=new Edge(T,V);
		IEdge VT=new Edge(V,T);
		
		try {
			gr.addEdge(XY);
			gr.addEdge(YX);
			gr.addEdge(YT);
			gr.addEdge(TY);
			gr.addEdge(YK);
			gr.addEdge(KY);
			gr.addEdge(KT);
			gr.addEdge(TK);
			gr.addEdge(KV);
			gr.addEdge(VK);
			gr.addEdge(SX);
			gr.addEdge(XS);
			gr.addEdge(TV);
			gr.addEdge(VT);
			gr.addEdge(VS);
			gr.addEdge(SV);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		System.out.println(gr);
		
		//removeVertex(gr, V);
		
		//System.out.println(gr);
		Hamiltanion h=new Hamiltanion();
		
		h.g=gr;

		h.dfs(gr);
		

		IGraph graph1 = new Graph(); 
		
		IVertex A = new Vertex("A");
		IVertex B = new Vertex("B");
		IVertex C = new Vertex("C");
		IVertex D = new Vertex("D");
		IVertex E = new Vertex("E");
		
		try {
			graph1.addVertex(A);
			graph1.addVertex(B);
			graph1.addVertex(C);
			graph1.addVertex(D);
			graph1.addVertex(E);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge AB = new Edge(A, B);
		AB.setWeight(1);
		IEdge AD = new Edge(A, D);
		AD.setWeight(3);
		IEdge DB = new Edge(D, B);
		DB.setWeight(5);
		IEdge BC = new Edge(B, C);
		BC.setWeight(6);
		IEdge CE = new Edge(C, E);
		CE.setWeight(7);
		
		try {
			graph1.addEdge(AB);
			graph1.addEdge(AD);
			graph1.addEdge(DB);
			graph1.addEdge(BC);
			graph1.addEdge(CE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(graph1);
		
		h.b=false;
		
		h.g=graph1;

		h.dfs(graph1);
		
		IGraph g=new Graph();
		
		IVertex a=new Vertex("A");
		IVertex b=new Vertex("B");
		IVertex c=new Vertex("C");
		IVertex d=new Vertex("D");
		
		try {
			g.addVertex(a);
			g.addVertex(b);
			g.addVertex(c);
			g.addVertex(d);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge ab=new Edge(a,b);
		IEdge ba=new Edge(b,a);
		IEdge bc=new Edge(b,c);
		IEdge cb=new Edge(c,b);
		IEdge ad=new Edge(a,d);
		IEdge dc=new Edge(d,c);
		try {
			g.addEdge(ab);
			g.addEdge(ba);
			g.addEdge(bc);
			g.addEdge(cb);
			g.addEdge(ad);
			g.addEdge(dc);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println(g);
		
		h.b=false;
		
		h.g=g;

		h.dfs(g);
	}
	
}
