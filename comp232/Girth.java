import java.util.ArrayList;
import java.util.Iterator;

import edu.bilgics.GraphADT.*;


public class Girth {
	IGraph g;
	Double infinite=Double.POSITIVE_INFINITY;
	ArrayList<IVertex> S=new ArrayList<IVertex>();
	ArrayList<IVertex> R=new ArrayList<IVertex>();
	int the_girth;
	int the_g;
	public Girth() {
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
	public int weight(IVertex u, IVertex v) {

		Iterator iterList = g.getGraphData().values().iterator();
		while (iterList.hasNext()) {
			ArrayList list = (ArrayList) iterList.next();
			Iterator iterEdge = list.iterator();

			while (list.size() > 0 && iterEdge.hasNext()) {
				IEdge edge = (IEdge) iterEdge.next();
				if (edge.getOriginatingVertex().equals(u)
						&& edge.getDestinationVertex().equals(v)) {
					return edge.getWeight();

				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public IVertex extractMin(ArrayList<IVertex> q){
		IVertex v=q.get(0);
		for(int i=0;i<q.size();i++){
			if(v.getDouble()>q.get(i).getDouble()){
				v=q.get(i);
			}
		}
		q.remove(v);
		return v;
	}
	
	
	public void girthAlgorith(){
		the_g=9999999;
		IVertex v;
		IVertex x;
		try {
			v=g.getFirstVertex();
			while(v!=null){
				S=new ArrayList<IVertex>();
				R=new ArrayList<IVertex>();
				R.add(v);
				v.setPi(null);
				v.setDouble(0.0);
				the_girth=0;
				while(!R.isEmpty()){
					x=extractMin(R);
					S.add(x);
					for(IVertex y : getAllAdjacentVertices(g, x)){
						if(!S.contains(y)){
							y.setPi(x);
							the_girth=the_girth+weight(x, y);
							y.setDouble(x.getDouble()+1);
							R.add(y);
						}
						else{
							if(y.getDouble()==0){
								the_girth=the_girth+weight(x, y);
								the_g=Math.min(the_girth, the_g);	
							}
						}
					}
				}
				v=g.getNextVertex();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGraph graph=new Graph();
		
		IVertex A=new Vertex("A");
		IVertex B=new Vertex("B");
		IVertex C=new Vertex("C");
		IVertex D=new Vertex("D");
		IVertex E=new Vertex("E");
		IVertex F=new Vertex("F");
		IVertex G=new Vertex("G");
		try {
			graph.addVertex(A);
			graph.addVertex(B);
			graph.addVertex(C);
			graph.addVertex(D);
			graph.addVertex(E);
			graph.addVertex(F);
			graph.addVertex(G);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge AB=new Edge(A,B);
		AB.setWeight(10);
		IEdge BC=new Edge(B,C);
		BC.setWeight(1);
		IEdge CD=new Edge(C,D);
		CD.setWeight(3);
		IEdge DE=new Edge(D,E);
		DE.setWeight(7);
		IEdge EA=new Edge(E,A);
		EA.setWeight(5);
		IEdge DB=new Edge(D,B);
		DB.setWeight(2);
		IEdge EF=new Edge(E,F);
		EF.setWeight(1);
		IEdge FG=new Edge(F,G);
		FG.setWeight(1);
		IEdge GE=new Edge(G,E);
		GE.setWeight(1);
		
		try {
			graph.addEdge(AB);
			graph.addEdge(BC);
			graph.addEdge(CD);
			graph.addEdge(DB);
			graph.addEdge(DE);
			graph.addEdge(EF);
			graph.addEdge(FG);
			graph.addEdge(GE);
			graph.addEdge(EA);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(graph);
		
		Girth g=new Girth();
		g.g=graph;
		g.girthAlgorith();
		
		// the result should be 3
		System.out.println(g.the_g);
		
		
		IGraph graph1=new Graph();
		
		IVertex S=new Vertex("S");
		IVertex T=new Vertex("T");
		IVertex X=new Vertex("X");
		IVertex Y=new Vertex("Y");
		IVertex Z=new Vertex("Z");
		
		try {
			graph1.addVertex(S);
			graph1.addVertex(T);
			graph1.addVertex(X);
			graph1.addVertex(Y);
			graph1.addVertex(Z);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		IEdge ST=new Edge(S,T);
		ST.setWeight(5);
		IEdge SY=new Edge(S,Y);
		SY.setWeight(2);
		IEdge TX=new Edge(T,X);
		TX.setWeight(1);
		IEdge TY=new Edge(T,Y);
		TY.setWeight(7);
		IEdge YT=new Edge(Y,T);
		YT.setWeight(10);
		IEdge YX=new Edge(Y,X);
		YX.setWeight(3);
		IEdge YZ=new Edge(Y,Z);
		YZ.setWeight(9);
		IEdge XZ=new Edge(X,Z);
		XZ.setWeight(4);
		IEdge ZX=new Edge(Z,X);
		ZX.setWeight(1);
		IEdge ZS=new Edge(Z,S);
		ZS.setWeight(4);
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
		
		Girth g1=new Girth();
		g1.g=graph1;
		g1.girthAlgorith();
		
		// the result should be 5 because the shortest cycle is XZ
		System.out.println(g1.the_g);

	}

}
