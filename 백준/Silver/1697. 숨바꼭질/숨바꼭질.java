import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int visited[]=new int [100001];
	static int cnt=1;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		if(N>=K) {
			bw.write(N-K+"\n");
		}else {
			bfs(N);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	public static void bfs(int n) {
		Queue<Integer> q =new LinkedList<>();
		q.add(n);
		visited[n]=1;
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int i=0;i<3;i++) {
				int next;
				
				if(i==0) {
					next=tmp+1;
				}else if(i==1) {
					next=tmp-1;
				}else {
					next=tmp*2;
				}
				
				if(next==K) {
					sb.append(visited[tmp]+"\n");
					return;
				}
				
				if(next>=0 && next<visited.length && visited[next]==0) {
					q.add(next);
					visited[next]=visited[tmp]+1;
				}
			}
			
			
		}
	}
}