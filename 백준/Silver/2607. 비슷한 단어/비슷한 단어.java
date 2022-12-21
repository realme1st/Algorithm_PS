import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sb =new StringBuilder();

    static int N;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());

        String s = br.readLine();
        int len=s.length();
        int [] alpha = new int[26];

        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'A']++;
        }

        while(N-->1){
            int[] temp=alpha.clone();
            String comp=br.readLine();

            int cnt=0;

            for(int i=0;i<comp.length();i++){
                if(temp[comp.charAt(i)-'A']>0){
                    cnt++;
                    temp[comp.charAt(i)-'A']--;
                }
            }

            if(len-1==comp.length() && cnt==comp.length()){
                ans++;
            }else if(len==comp.length()){
                if(cnt==len || cnt==len-1){
                    ans++;
                }
            }else if(len+1 == comp.length()){
                if(cnt==len){
                    ans++;
                }
            }
            //System.out.println(N);
        }
        bw.write(ans+"\n");

        br.close();
        bw.close();

    }
}