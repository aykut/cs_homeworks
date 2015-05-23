import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import edu.bilgics.GraphADT.*;


public class Eulerian {
	public static IVertex getFirstAdjacentVertice(IGraph g,IVertex v){
		IEdge edge=null;
		try {
			edge=g.getFirstEdge();
			while(edge!=null){
				if(edge.getOriginatingVertex().equals(v)){
					return edge.getDestinationVertex();
				}
				edge=g.getNextEdge();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
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

	public boolean isAllVerticesEven(IGraph g){
		boolean b=false;
		try {
			IVertex v=g.getFirstVertex();
			while(v!=null){
				v.setDegree(getAllAdjacentVertices(g, v).size());
				if(v.getDegree()%2==0){
					b=true;
				}
				else{
					return b;
				}
				v=g.getNextVertex();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
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
	public ArrayList<IVertex> find(IGraph g){
		ArrayList<IVertex> C=new ArrayList<IVertex>();
		Vector<IVertex> S=new Vector<IVertex>();
		if(isAllVerticesEven(g)){
			IVertex v;
			IVertex x;
			try {
				v=g.getFirstVertex();
				while(v!=null){
					//System.out.println("1");
					x=getFirstAdjacentVertice(g, v);
					if(x==null){
						//System.out.println("2");
						C.add(v);
						if(S.isEmpty()){
							//System.out.println("3");
							v=null;
						}
						else{
						v=S.lastElement();
						S.remove(S.size()-1);
						//System.out.println("4");
						}
					}
					else{
						remove(g, v, x);
						S.add(v);
						//System.out.println(v.getName());
						v=x;
						//System.out.println("5");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else{
			System.out.println("There is an edge has odd degree");
		}
		return C;
		
	}
	public static void main(String[] args) {
		IGraph gr=new Graph();
		
		IVertex X=new Vertex("X");
		IVertex Y=new Vertex("Y");
		IVertex S=new Vertex("S");
		IVertex T=new Vertex("T");
		IVertex V=new Vertex("V");
		
		try {
			gr.addVertex(X);
			gr.addVertex(Y);
			gr.addVertex(S);
			gr.addVertex(T);
			gr.addVertex(V);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		IEdge XY=new Edge(X,Y);
		IEdge YX=new Edge(Y,X);
		IEdge YS=new Edge(Y,S);
		IEdge SY=new Edge(S,Y);
		IEdge SX=new Edge(S,X);
		IEdge XS=new Edge(X,S);
		IEdge ST=new Edge(S,T);
		IEdge TS=new Edge(T,S);
		IEdge TV=new Edge(T,V);
		IEdge VT=new Edge(V,T);
		IEdge VS=new Edge(V,S);
		IEdge SV=new Edge(S,V);
		
		try {
			gr.addEdge(XY);
			gr.addEdge(YX);
			gr.addEdge(YS);
			gr.addEdge(SY);
			gr.addEdge(SX);
			gr.addEdge(XS);
			gr.addEdge(ST);
			gr.addEdge(TS);
			gr.addEdge(TV);
			gr.addEdge(VT);
			gr.addEdge(VS);
			gr.addEdge(SV);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		System.out.println(gr);

		
		Eulerian e=new Eulerian();

		ArrayList<IVertex> arr=e.find(gr);
		
		String st="";
		for(int i=arr.size()-1;i>=0;i--){
			st=st+" "+arr.get(i).getName();
		}
		System.out.println(st);
		
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
		
		
		Eulerian eu=new Eulerian();

		ArrayList<IVertex> a=eu.find(g);
		
		String s="";
		for(int i=a.size()-1;i>=0;i--){
			s=s+" "+a.get(i).getName();
		}
		System.out.println(s);
	}
}
