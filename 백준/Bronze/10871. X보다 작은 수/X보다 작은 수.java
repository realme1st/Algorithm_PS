import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");


        int N = Integer.parseInt(st.nextToken());

        int X = Integer.parseInt(st.nextToken());
        int a[] = new int[N];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine()," " );
        for(int i=0;i<N;i++){

            a[i]=Integer.parseInt(st.nextToken());

        }



        for(int i=0;i<N;i++){
            if(a[i]<X){
                sb.append(a[i]+" ");
            }

        }

        bw.write(sb.toString());

        br.close();

        bw.close();
    }

}