import java.io.*;
import java.util.StringTokenizer;

/**
 * 입력이 크지 않고 모든 경우의 수를 확인 => 백트래킹
 */

public class Main {
    static int C;
    static int map[][]; //선수 포지션 점수
    static boolean visited[]; // 선수 포지션 자리(갈 수 있는 곳?)

    static int ans;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        C=Integer.parseInt(br.readLine());

        for(int i=0;i<C;i++){
            map=new int[11][11];
            visited=new boolean[11];

            for(int j=0;j<11;j++){
                st=new StringTokenizer(br.readLine()," ");
                for(int k=0;k<11;k++){
                    map[j][k]=Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);
            sb.append(ans+"\n");
            ans=0;
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void dfs(int idx,int tmp){
        if(idx==11){
            ans=Math.max(tmp,ans);
            return;
        }

        for(int i=0;i<11;i++){
            if(!visited[i] && map[idx][i]!=0){
                visited[i]=true;
                dfs(idx+1,map[idx][i]+tmp);
                visited[i]=false;
            }
        }
    }
}