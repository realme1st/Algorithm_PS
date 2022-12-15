import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int N;
    static int L,H,R;

    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());

        PriorityQueue<Building> pq =new PriorityQueue<>((o1, o2) -> {
            if(o1.x==o2.x){
                return o2.h-o1.h;
            }
            return o1.x-o2.x;
        });

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");

            L=Integer.parseInt(st.nextToken());
            H=Integer.parseInt(st.nextToken());
            R=Integer.parseInt(st.nextToken());

            pq.offer(new Building(L,H));
            pq.offer(new Building(R,-H));
        }

        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());

        int maxX=0,maxH=0;

        map.put(0,1);

        while(!pq.isEmpty()){
            Building b = pq.poll();

            if(b.h>0){
                map.put(b.h,map.getOrDefault(b.h,0)+1);
            }else{
                int val=map.get(-b.h);
                if(val==1){
                    map.remove(-b.h);
                }else{
                    map.replace(-b.h,val-1);
                }
            }

            int height=map.firstKey();
            if(maxX!=b.x && maxH!=height){
                sb.append(b.x+" "+height+" ");
                maxX=b.x;
                maxH=height;
            }
        }

        bw.write(sb.toString().trim());
        br.close();
        bw.close();


    }


    static class Building{
        int x,h;

        public Building(int x,int h){
            this.x=x;
            this.h=h;
        }
    }
}