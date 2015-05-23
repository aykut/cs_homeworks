import java.util.ArrayList;
import java.util.Iterator;

import edu.bilgics.GraphADT.Edge;
import edu.bilgics.GraphADT.EmptyGraphException;
import edu.bilgics.GraphADT.EmptyVerticeSetException;
import edu.bilgics.GraphADT.Graph;
import edu.bilgics.GraphADT.IEdge;
import edu.bilgics.GraphADT.IGraph;
import edu.bilgics.GraphADT.IVertex;
import edu.bilgics.GraphADT.Vertex;
/*
INITIALIZE-SINGLE-SOURCE(G, s)
1 for each vertex v element of V[G]
2 		do d[v] <- infinity 
3 			pi[v]<- null
4 d[s] <- 0

RELAX(u, v,w)
1 if d[v] > d[u] + w(u, v)
2 		then d[v] <- d[u] + w(u, v)
3 			pi[v]<- u


DIJKSTRA(G,w,s)
1 INITIALIZESINGLESOURCE(G,s)
2 s <- empty
3 Q <- V[G]
4 while Q != empty
5 		do u <- EXTRACT-MIN(Q)
6 			S <- S U {u} 
7 			for each vertex v element Adj[u]
8 				do RELAX(u, v,w)

*/

public class Dijkstra {
	ArrayList<IVertex> S=new ArrayList<IVertex>();
	ArrayList<IVertex> q=new ArrayList<IVertex>();
	IGraph g;
	public Dijkstra() {
		// TODO Auto-generated constructor stub
		g=new Graph();
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
	public void initializeSingle(IVertex s){
		Double infinite=Double.POSITIVE_INFINITY;
		IVertex v;
		try {
			v=g.getFirstVertex();
			while(v!=null){
				
				v.setDouble(infinite);
				v.setPi(null);
				v=g.getNextVertex();
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		s.setDouble(0);
	}
	public void relax(IVertex u,IVertex v){
		if(v.getDouble()>u.getDouble()+weight(u, v)){
			v.setDouble(u.getDouble()+weight(u, v));
			v.setPi(u);
		}
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

	public void dijkstra(IVertex s){
		initializeSingle(s);
		q=(ArrayList<IVertex>)g.getVertices().clone();
		IVertex u;
		while(!q.isEmpty()){
			u=extractMin(q);
			S.add(u);
			for(IVertex v : getAllAdjacentVertices(g, u)){
				relax(u, v);
			}
		}
	}
	public static void main(String[] args) {
		
		/*IGraph graph=new Graph();
		
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
		ST.setWeight(10);
		IEdge SY=new Edge(S,Y);
		SY.setWeight(5);
		IEdge TX=new Edge(T,X);
		TX.setWeight(1);
		IEdge TY=new Edge(T,Y);
		TY.setWeight(2);
		IEdge YT=new Edge(Y,T);
		YT.setWeight(3);
		IEdge YX=new Edge(Y,X);
		YX.setWeight(9);
		IEdge YZ=new Edge(Y,Z);
		YZ.setWeight(2);
		IEdge XZ=new Edge(X,Z);
		XZ.setWeight(4);
		IEdge ZX=new Edge(Z,X);
		ZX.setWeight(6);
		IEdge ZS=new Edge(Z,S);
		ZS.setWeight(7);
		
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
		
		Dijkstra d=new Dijkstra();
		
		d.g=graph;
		d.dijkstra(S);
		
		for(int i=d.S.size()-1;i>=0;i--){
			String s=" ";
			IVertex u=d.S.get(i);
			while(u!=null){
				s=u+" ==> "+s;
				u=u.getPi();
			}
			System.out.println(s);
			}
		
		
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
		
		Dijkstra d1=new Dijkstra();
		
		d1.g=graph1;
		d1.dijkstra(A);
		
		for(int i=d1.S.size()-1;i>=0;i--){
			String s=" ";
			IVertex u=d1.S.get(i);
			while(u!=null){
				s=u+" ==> "+s;
				u=u.getPi();
			}
			System.out.println(s);
			}
		
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
		
		Dijkstra d2=new Dijkstra();
		
		d2.g=gr;
		d2.dijkstra(K);
		
		for(int i=d2.S.size()-1;i>=0;i--){
			String s=" ";
			IVertex u=d2.S.get(i);
			while(u!=null){
				s=u+" ==> "+s;
				u=u.getPi();
			}
			System.out.println(s);
			}
		
		IGraph gra=new Graph();
		
		IVertex a=new Vertex("a");
		IVertex b=new Vertex("b");
		IVertex c=new Vertex("c");
		try {
			gra.addVertex(a);
			gra.addVertex(b);
			gra.addVertex(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IEdge ab=new Edge(a,b);
		IEdge ba=new Edge(b,a);
		IEdge bc=new Edge(b,c);
		IEdge bc=new Edge(b,c);
		try {
			gra.addEdge(ab);
			gra.addEdge(ba);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(gra);
		Dijkstra d3=new Dijkstra();
		
		d3.g=gra;
		d3.dijkstra(a);
		
		for(int i=d3.S.size()-1;i>=0;i--){
			String s=" ";
			IVertex u=d3.S.get(i);
			while(u!=null){
				s=u+" ==> "+s;
				u=u.getPi();
			}
			System.out.println(s);
			}*/
		

		IGraph gra=new Graph();
		
		IVertex a=new Vertex("a");
		IVertex b=new Vertex("b");
		IVertex c=new Vertex("c");
		IVertex d=new Vertex("d");
		IVertex e=new Vertex("e");
		IVertex f=new Vertex("f");
		IVertex g=new Vertex("g");
		IVertex h=new Vertex("h");
		IVertex i=new Vertex("i");
		IVertex z=new Vertex("z");
		try {
			gra.addVertex(a);
			gra.addVertex(b);
			gra.addVertex(c);
			gra.addVertex(d);
			gra.addVertex(e);
			gra.addVertex(f);
			gra.addVertex(g);
			gra.addVertex(h);
			gra.addVertex(i);
			gra.addVertex(z);
		} catch (Exception exp) {
			// TODO: handle exception
		}
		IEdge ab=new Edge(a,b);
		ab.setWeight(1);
		IEdge ba=new Edge(b,a);
		ba.setWeight(1);
		IEdge ac=new Edge(a,c);
		ac.setWeight(10);
		IEdge ca=new Edge(c,a);
		ca.setWeight(10);
		IEdge ad=new Edge(a,d);
		ad.setWeight(6);
		IEdge da=new Edge(d,a);
		da.setWeight(6);
		IEdge ae=new Edge(a,e);
		ae.setWeight(3);
		IEdge ea=new Edge(e,a);
		ea.setWeight(3);
		IEdge bc=new Edge(b,c);
		bc.setWeight(10);
		IEdge cb=new Edge(c,b);
		cb.setWeight(10);
		IEdge bf=new Edge(b,f);
		bf.setWeight(10);
		IEdge fb=new Edge(f,b);
		fb.setWeight(10);
		IEdge cd=new Edge(c,d);
		cd.setWeight(4);
		IEdge dc=new Edge(d,c);
		dc.setWeight(4);
		IEdge cf=new Edge(c,f);
		cf.setWeight(1);
		IEdge fc=new Edge(f,c);
		fc.setWeight(1);
		IEdge cg=new Edge(c,g);
		cg.setWeight(4);
		IEdge gc=new Edge(g,c);
		gc.setWeight(4);
		IEdge ch=new Edge(c,h);
		ch.setWeight(1);
		IEdge hc=new Edge(h,c);
		hc.setWeight(1);
		IEdge de=new Edge(d,e);
		de.setWeight(2);
		IEdge ed=new Edge(e,d);
		ed.setWeight(2);
		IEdge dh=new Edge(d,h);
		dh.setWeight(3);
		IEdge hd=new Edge(h,d);
		hd.setWeight(3);
		IEdge eh=new Edge(e,h);
		eh.setWeight(6);
		IEdge he=new Edge(h,e);
		he.setWeight(6);
		IEdge ei=new Edge(e,i);
		ei.setWeight(8);
		IEdge ie=new Edge(i,e);
		ie.setWeight(8);
		IEdge fg=new Edge(f,g);
		fg.setWeight(2);
		IEdge gf=new Edge(g,f);
		gf.setWeight(2);
		IEdge fz=new Edge(f,z);
		fz.setWeight(5);
		IEdge zf=new Edge(z,f);
		zf.setWeight(5);
		IEdge gh=new Edge(g,h);
		gh.setWeight(5);
		IEdge hg=new Edge(h,g);
		hg.setWeight(5);
		IEdge gz=new Edge(g,z);
		gz.setWeight(2);
		IEdge zg=new Edge(z,g);
		zg.setWeight(2);
		IEdge hi=new Edge(h,i);
		hi.setWeight(3);
		IEdge ih=new Edge(i,h);
		ih.setWeight(3);
		IEdge hz=new Edge(h,z);
		hz.setWeight(8);
		IEdge zh=new Edge(z,h);
		zh.setWeight(4);
		IEdge iz=new Edge(i,z);
		iz.setWeight(5);
		IEdge zi=new Edge(z,i);
		zi.setWeight(5);
		
		try {
			gra.addEdge(ab);
			gra.addEdge(ba);
			gra.addEdge(ac);
			gra.addEdge(ca);
			gra.addEdge(ad);
			gra.addEdge(da);
			gra.addEdge(ae);
			gra.addEdge(ea);
			gra.addEdge(bc);
			gra.addEdge(cb);
			gra.addEdge(bf);
			gra.addEdge(fb);
			gra.addEdge(cd);
			gra.addEdge(dc);
			gra.addEdge(cf);
			gra.addEdge(fc);
			gra.addEdge(cg);
			gra.addEdge(gc);
			gra.addEdge(ch);
			gra.addEdge(hc);
			gra.addEdge(de);
			gra.addEdge(ed);
			gra.addEdge(dh);
			gra.addEdge(hd);

			
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
		try {
			gra.addEdge(eh);
			gra.addEdge(he);
			gra.addEdge(ei);
			gra.addEdge(ie);
			gra.addEdge(fg);
			gra.addEdge(gf);
			gra.addEdge(fz);
			gra.addEdge(zf);
			gra.addEdge(gh);
			gra.addEdge(hg);
			gra.addEdge(gz);
			gra.addEdge(zg);
			gra.addEdge(hi);
			gra.addEdge(ih);
			gra.addEdge(hz);
			gra.addEdge(zh);
			gra.addEdge(iz);
			gra.addEdge(zi);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		System.out.println(gra);
		
		Dijkstra d3=new Dijkstra();
		
		d3.g=gra;
		d3.dijkstra(a);
		
		for(int in=d3.S.size()-1;in>=0;in--){
			String s=" ";
			IVertex u=d3.S.get(in);
			while(u!=null){
				s=u+" ==> "+s;
				u=u.getPi();
			}
			System.out.println(s);
			}
	}
	

}
