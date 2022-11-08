import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int N;
	static int map[][];
	static boolean[][] visited;
	
	static int cnt;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static ArrayList<Integer> ans;
	static int ans_cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		visited=new boolean[N][N];
		ans=new ArrayList<>();
		for(int r=0;r<N;r++) {
			String s = br.readLine();
			for(int c=0;c<N;c++) {
				map[r][c]=s.charAt(c)-'0';
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==1 && !visited[r][c]) {
					DFS(r,c);
					cnt++;
					ans.add(ans_cnt);
					ans_cnt=0;
				}
			}
		}
		
		Collections.sort(ans);
		
		bw.write(cnt+"\n");
		
		for(int i=0;i<ans.size();i++) {
			bw.write(ans.get(i)+"\n");
		}
		br.close();
		bw.close();
	}
	public static void DFS(int r,int c) {
		visited[r][c]=true;
		ans_cnt++;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(isIn(nr,nc) && map[nr][nc]==1 && !visited[nr][nc]) {
				DFS(nr,nc);
			}
		}
		
		
	}
	public static boolean isIn(int r,int c) {
		if(r<0 || c<0 || r>=N || c>=N) {
			return false;
		}
		return true;
	}

}