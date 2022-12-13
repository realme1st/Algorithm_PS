import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int x,y;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());

        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");

            x=Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()>y){
                ans++;
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek()==y){
                continue;
            }

            stack.push(y);
        }

        while(!stack.isEmpty()){
            if(stack.peek()>0){
                ans++;
            }
            stack.pop();
        }

        bw.write(ans+"\n");

        br.close();
        bw.close();
    }
}