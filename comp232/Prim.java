import java.util.ArrayList;
import java.util.Iterator;



import edu.bilgics.GraphADT.*;

/*
MST-PRIM(G,w, r)
1 for each v element of V[G] 
2 		do key[u] <- infinity
3 			pi[u] <- NIL
4 key[r] <- 0
5 Q <- V[G]
6 while Q != empty 
7 		do u <- EXTRACT-MIN(Q)
8 		for each v element of Adj[u]
9 			do if v element of Q and W(u, v) < key[v]
10 					then pi[v] <- u
11 						key[v] <- w(u, v)

*/


public class Prim {
	String s=" ";
	IGraph g=new Graph();
	ArrayList<IVertex> q=new ArrayList<IVertex>();
	public Prim() {
		// TODO Auto-generated constructor stub
	}
	//from GraphDemo
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
	
	public IVertex extractMin(ArrayList<IVertex> q){
		IVertex v=q.get(0);
		for(int i=0;i<q.size();i++){
			if(v.getDi()>q.get(i).getDi()){
				v=q.get(i);
			}
		}
		q.remove(v);
		return v;
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

	
	public void mstPrim(IVertex r){
		IVertex u;
		Integer infinite=Integer.MAX_VALUE;
		try {
			u=g.getFirstVertex();
			while(u!=null){
				u.setDi(infinite);
				u.setPi(null);
				u=g.getNextVertex();
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		r.setDi(0);
		q=(ArrayList<IVertex>)g.getVertices().clone();
		while(!q.isEmpty()){
			u=extractMin(q);
			s=s+u+" ==> ";
			for(IVertex v : getAllAdjacentVertices(g, u)){
				if(q.contains(v)&&weight(u, v)<v.getDi()){
					v.setPi(u);
					v.setDi(weight(u, v));
				}
			}
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		IGraph graph=new Graph();
		
		IVertex a=new Vertex("a");
		IVertex b=new Vertex("b");
		IVertex c=new Vertex("c");
		IVertex d=new Vertex("d");
		IVertex e=new Vertex("e");
		IVertex f=new Vertex("f");
		IVertex g=new Vertex("g");
		IVertex h=new Vertex("h");
		IVertex i=new Vertex("i");
		
		try {
			graph.addVertex(a);
			graph.addVertex(b);
			graph.addVertex(c);
			graph.addVertex(d);
			graph.addVertex(e);
			graph.addVertex(f);
			graph.addVertex(g);
			graph.addVertex(h);
			graph.addVertex(i);
		} catch (Exception exp) {
			// TODO: handle exception
		}
		IEdge ab=new Edge(a,b);
		ab.setWeight(4);
		IEdge ba=new Edge(b,a);
		ba.setWeight(4);
		IEdge ah=new Edge(a,h);
		ah.setWeight(8);
		IEdge ha=new Edge(h,a);
		ha.setWeight(8);
		IEdge bh=new Edge(b,h);
		bh.setWeight(11);
		IEdge hb=new Edge(h,b);
		hb.setWeight(11);
		IEdge bc=new Edge(b,c);
		bc.setWeight(8);
		IEdge cb=new Edge(c,b);
		cb.setWeight(8);
		IEdge hi=new Edge(h,i);
		hi.setWeight(7);
		IEdge ih=new Edge(i,h);
		ih.setWeight(7);
		IEdge hg=new Edge(h,g);
		hg.setWeight(1);
		IEdge gh=new Edge(g,h);
		gh.setWeight(1);
		IEdge ig=new Edge(i,g);
		ig.setWeight(6);
		IEdge gi=new Edge(g,i);
		gi.setWeight(6);
		IEdge ic=new Edge(i,c);
		ic.setWeight(2);
		IEdge ci=new Edge(c,i);
		ci.setWeight(2);
		IEdge cd=new Edge(c,d);
		cd.setWeight(7);
		IEdge dc=new Edge(d,c);
		dc.setWeight(7);
		IEdge cf=new Edge(c,f);
		cf.setWeight(4);
		IEdge fc=new Edge(f,c);
		fc.setWeight(4);
		IEdge gf=new Edge(g,f);
		gf.setWeight(2);
		IEdge fg=new Edge(f,g);
		fg.setWeight(2);
		IEdge fd=new Edge(f,d);
		fd.setWeight(14);
		IEdge df=new Edge(d,f);
		df.setWeight(14);
		IEdge fe=new Edge(f,e);
		fe.setWeight(10);
		IEdge ef=new Edge(e,f);
		ef.setWeight(10);
		IEdge de=new Edge(d,e);
		de.setWeight(9);
		IEdge ed=new Edge(e,d);
		ed.setWeight(9);
		
		try {
			graph.addEdge(ab);
			graph.addEdge(ah);
			graph.addEdge(bh);
			graph.addEdge(bc);
			graph.addEdge(hi);
			graph.addEdge(hg);
			graph.addEdge(ig);
			graph.addEdge(ic);
			graph.addEdge(cd);
			graph.addEdge(cf);
			graph.addEdge(gf);
			graph.addEdge(fd);
			graph.addEdge(fe);
			graph.addEdge(de);
			
			graph.addEdge(ba);
			graph.addEdge(ha);
			graph.addEdge(hb);
			graph.addEdge(cb);
			graph.addEdge(ih);
			graph.addEdge(gh);
			graph.addEdge(gi);
			graph.addEdge(ci);
			graph.addEdge(dc);
			graph.addEdge(fc);
			graph.addEdge(fg);
			graph.addEdge(df);
			graph.addEdge(ef);
			graph.addEdge(ed);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
		System.out.println(graph);
		
		Prim p=new Prim();
		
		p.g=graph;
		
		p.mstPrim(a);
		
		
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
		} catch (Exception ex) {
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
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
		System.out.println(graph1);
		Prim p1=new Prim();
		// the result should be like that S T Y X Z
		p1.g=graph1;
		
		p1.mstPrim(S);
		
		IGraph gr=new Graph();
		
		IVertex K=new Vertex("K");
		IVertex L=new Vertex("L");
		IVertex M=new Vertex("M");
		try {
			gr.addVertex(K);
			gr.addVertex(L);
			gr.addVertex(M);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		IEdge KM=new Edge(K,M);
		IEdge KL=new Edge(K,L);
		try {
			gr.addEdge(KM);
			gr.addEdge(KL);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		System.out.println(gr);
		
		Prim p2=new Prim();
		p2.g=gr;
		p2.mstPrim(K);
		
		
	}

}
