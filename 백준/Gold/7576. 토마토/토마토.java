import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	
	
	
	static int M,N;
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	static int map[][];
	
	static int maxVal;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Node> q=new LinkedList<>();
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==1) {
					q.add(new Node(r,c));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			int r=now.r;
			int c=now.c;
			
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				
				if(nr<0 || nc< 0 || nr >=N || nc>=M) {
					continue;
				}
				if(map[nr][nc]!=0) {
					continue;
				}
				
				map[nr][nc]=map[r][c]+1;
				q.add(new Node(nr,nc));
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==0) {
					bw.write(-1+"\n");
					br.close();
					bw.close();
					return;
				}
				
				maxVal=Math.max(maxVal, map[r][c]);
				
			}
		}
		bw.write(maxVal-1+"\n");
		br.close();
		bw.close();

	}
	
	

}
class Node{
	int r;
	int c;
	
	Node(int r,int c){
		this.r=r;
		this.c=c;
	}
}