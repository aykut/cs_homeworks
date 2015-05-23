import java.util.ArrayList;
import java.util.Vector;

import edu.bilgics.GraphADT.*;

/*
BFS(G, s)
1 for each vertex u element of V[G]-{S}do 
2 		color[u] <- WHITE
3 		d[u]<- infinity 
4		pi[u]<- NIL
5 color[s] <- GRAY
6 d[s] <- 0
7 pi[s] <- null
8 Q <- empty
9 ENQUEUE(Q, s)
10 while Q != empty 
11 		do u <- DEQUEUE(Q)
12 			for each v element of Adj[u]
13 				do if color[v] = WHITE
14 						then color[v] <- GRAY
15 						d[v] <- d[u] + 1
16 						pi[v]<- u
17 						ENQUEUE(Q, v)
18 			color[u] <- BLACK
*/




public class BFS {
	Vector<IVertex> q=new Vector<IVertex>();
	String sonuc="";
	public BFS() {
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
					sonuc=sonuc+" "+u;
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
			
			System.out.println(sonuc);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGraph graph1 = new Graph(); 
		
		IVertex A = new Vertex("A");
		IVertex B = new Vertex("B");
		IVertex C = new Vertex("C");
		IVertex D = new Vertex("D");
		IVertex E = new Vertex("E");
		IVertex F = new Vertex("F");
		//IVertex G = new Vertex("G");
		//IVertex H = new Vertex("H");
		//IVertex I = new Vertex("I");
		//IVertex J = new Vertex("J");
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
		
		BFS b=new BFS();
		/// the result should be like that A B C D E F
		b.bfs(graph1, A);
		
		IGraph graph=new Graph();
		
		IVertex S=new Vertex("S");
		IVertex T=new Vertex("T");
		IVertex X=new Vertex("X");
		IVertex Y=new Vertex("Y");
		IVertex Z=new Vertex("Z");
		
		try {
			graph.addVertex(S);
			graph.addVertex(T);
			graph.addVertex(X);
			graph.addVertex(Y);
			graph.addVertex(Z);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		IEdge ST=new Edge(S,T);
		IEdge SY=new Edge(S,Y);
		IEdge TX=new Edge(T,X);
		IEdge TY=new Edge(T,Y);
		IEdge YT=new Edge(Y,T);
		IEdge YX=new Edge(Y,X);
		IEdge YZ=new Edge(Y,Z);
		IEdge XZ=new Edge(X,Z);
		IEdge ZX=new Edge(Z,X);
		IEdge ZS=new Edge(Z,S);
		
		try {
			graph.addEdge(ST);
			graph.addEdge(SY);
			graph.addEdge(TX);
			graph.addEdge(TY);
			graph.addEdge(YT);
			graph.addEdge(YX);
			graph.addEdge(YZ);
			graph.addEdge(XZ);
			graph.addEdge(ZX);
			graph.addEdge(ZS);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(graph);
		BFS b1=new BFS();
		// the result should be like that S T Y X Z
		b1.bfs(graph, S);
		
		IGraph gr=new Graph();
		
		IVertex K=new Vertex("K");
		IVertex L=new Vertex("L");
		IVertex M=new Vertex("M");
		try {
			gr.addVertex(K);
			gr.addVertex(L);
			gr.addVertex(M);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge KM=new Edge(K,M);
		IEdge KL=new Edge(K,L);
		try {
			gr.addEdge(KM);
			gr.addEdge(KL);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(gr);
		BFS b2=new BFS();
		// the result should be like that K M L
		b2.bfs(gr, K);
		
	}

}
