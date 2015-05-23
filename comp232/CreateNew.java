import java.util.ArrayList;

import edu.bilgics.GraphADT.*;
public class CreateNew {
	public static void removeVertex(IGraph g,IVertex x){
		try {
			IVertex u=x;
			for(IVertex v:getAllAdjacentVertices(g, u)){
				remove(g, u, v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			g.removeVertex(x);	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void remove(IGraph g,IVertex u,IVertex v){
		IEdge edge=null;
		try {
			edge=g.getFirstEdge();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			while(edge!=null){
				if(edge.getOriginatingVertex().equals(u)&edge.getDestinationVertex().equals(v)){
					try {
						g.removeEdge(edge);
					} catch (Exception e) {
						// TODO: handle exception
					}
					remove(g, v, u);
				}
				try {
					edge=g.getNextEdge();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	
	public boolean check(IGraph g,IVertex u,IVertex v){
		boolean b=false;
		try {
			IEdge edge=g.getFirstEdge();
			while(edge!=null){
				if(edge.getOriginatingVertex().equals(u)&&edge.getDestinationVertex().equals(v)){
					return true;
				}
				else{
					b=false;
				}
				edge=g.getNextEdge();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return b;
	}
	
	public void create(IGraph g,ArrayList<IVertex> V){
		ArrayList<IVertex> arr=new ArrayList<IVertex>();
		for(int i=g.getVertices().size()-1;i>=0;i--){
			if(V.contains(g.getVertices().get(i))){
			}
			else{
				arr.add(g.getVertices().get(i));
			}

		}
		try {
			for(int i=arr.size()-1;i>=0;i--){
				removeVertex(g, arr.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public IGraph inducedGraph(IGraph g,ArrayList<IVertex> V){
		IGraph graph=new Graph();
		for(int i=V.size()-1;i>=0;i--){
			try {
				graph.addVertex(V.get(i));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for(int i=V.size()-1;i>=0;i--){
			for(int j=V.size()-1;j>=0;j--){
				if(check(g,V.get(i),V.get(j))){
					try {
						graph.addEdge(new Edge(V.get(i),V.get(j)));
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		return graph;
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
		IVertex J=new Vertex("J");
		
		try {
			g.addVertex(A);
			g.addVertex(B);
			g.addVertex(C);
			g.addVertex(D);
			g.addVertex(E);
			g.addVertex(F);
			g.addVertex(G);
			g.addVertex(H);
			g.addVertex(J);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
		IEdge AB=new Edge(A,B);
		IEdge BA=new Edge(B,A);
		IEdge AF=new Edge(A,F);
		IEdge FA=new Edge(F,A);
		IEdge AH=new Edge(A,H);
		IEdge HA=new Edge(H,A);
		IEdge AJ=new Edge(A,J);
		IEdge JA=new Edge(J,A);
		IEdge BC=new Edge(B,C);
		IEdge CB=new Edge(C,B);
		IEdge BD=new Edge(B,D);
		IEdge DB=new Edge(D,B);
		IEdge BH=new Edge(B,H);
		IEdge HB=new Edge(H,B);
		IEdge CD=new Edge(C,D);
		IEdge DC=new Edge(D,C);
		IEdge EH=new Edge(E,H);
		IEdge HE=new Edge(H,E);
		IEdge EG=new Edge(E,G);
		IEdge GE=new Edge(G,E);
		IEdge GH=new Edge(G,H);
		IEdge HG=new Edge(H,G);
		IEdge FJ=new Edge(F,J);
		IEdge JF=new Edge(J,F);
		
		try {
			g.addEdge(AB);
			g.addEdge(BA);
			g.addEdge(AF);
			g.addEdge(FA);
			g.addEdge(AH);
			g.addEdge(HA);
			g.addEdge(AJ);
			g.addEdge(JA);
			g.addEdge(BC);
			g.addEdge(CB);
			g.addEdge(BD);
			g.addEdge(DB);
			g.addEdge(BH);
			g.addEdge(HB);
			g.addEdge(CD);
			g.addEdge(DC);
			g.addEdge(EH);
			g.addEdge(HE);
			g.addEdge(EG);
			g.addEdge(GE);
			g.addEdge(GH);
			g.addEdge(HG);
			g.addEdge(FJ);
			g.addEdge(JF);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
		System.out.println(g);
		
		ArrayList<IVertex> V=new ArrayList<IVertex>();
		
		V.add(G);
		V.add(D);
		V.add(C);
		V.add(B);
		V.add(A);
		
		CreateNew c=new CreateNew();
		
		System.out.println(c.inducedGraph(g, V));
		
		
		
		
		Graph graph1 = new Graph();
		IVertex S = new Vertex("S");
		IVertex T = new Vertex("T");
		IVertex X = new Vertex("X");
		IVertex Y = new Vertex("Y");
		IVertex Z = new Vertex("Z");
		try {
			graph1.addVertex(S);
			graph1.addVertex(T);
			graph1.addVertex(X);
			graph1.addVertex(Y);
			graph1.addVertex(Z);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge ST = new Edge(S, T);
		IEdge SY = new Edge(S, Y);
		IEdge TX = new Edge(T, X);
		IEdge TY = new Edge(T, Y);
		IEdge YT = new Edge(Y, T);
		IEdge YX = new Edge(Y, X);
		IEdge YZ = new Edge(Y, Z);
		IEdge XZ = new Edge(X, Z);;
		IEdge ZX = new Edge(Z, X);
		IEdge ZS = new Edge(Z, S);
		try {
			graph1.addEdge(ST);
			graph1.addEdge(SY);
			graph1.addEdge(TX);
			graph1.addEdge(TY);
			graph1.addEdge(YT);
			graph1.addEdge(YX);
			graph1.addEdge(YZ);
			graph1.addEdge(XZ);
			graph1.addEdge(ZX);
			graph1.addEdge(ZS);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(graph1);
		
		
		ArrayList<IVertex> V1=new ArrayList<IVertex>();
		
		V1.add(Z);
		V1.add(X);
		V1.add(S);
		
		CreateNew c1=new CreateNew();
		
		
		System.out.println(c1.inducedGraph(graph1, V1));

	}

}
