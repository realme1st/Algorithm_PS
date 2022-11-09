import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
	int row,col;
	public Node(int row,int col) {
		this.row=row;
		this.col=col;
	}
}

public class Main {
	
	static int N,M;
	static int[][] visited;
	static int[][] map;
	static StringBuilder sb=new StringBuilder();
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		visited=new int[N][M];
		
		for(int r=0;r<N;r++) {
			String s=br.readLine();
			for(int c=0;c<M;c++) {
				map[r][c]=s.charAt(c)-'0';
			}
		}
		BFS();
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void BFS() {
		Queue<Node> queue=new LinkedList<>();
		
		queue.add(new Node(0,0));
		visited[0][0]=1;
		
		while(!queue.isEmpty()) {
			Node node =queue.poll();
			int row =node.row;
			int col=node.col;
			
			for(int i=0;i<4;i++) {
				int nr=row+dr[i];
				int nc=col+dc[i];
				
				if(check(nr,nc)) {
					queue.add(new Node(nr,nc));
					visited[nr][nc]=visited[row][col]+1;
				}
			}
		}
		
		sb.append(visited[N-1][M-1]);
	}
	
	public static boolean check(int row,int col) {
		if(row<0 || col < 0 || row>=N || col>=M ) {
			return false;
		}
		if(visited[row][col]!=0 || map[row][col]==0) {
			return false;
		}
		return true;
	}

}