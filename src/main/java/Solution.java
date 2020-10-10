import java.util.*;

public class Solution{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int t=1;//sc.nextInt();
        int max=1001;

        while(t-->0){
            int n=sc.nextInt();

            PriorityQueue<Pair>pq=new PriorityQueue<>();

            int x,y;
            for(int i=0;i<n;i++){
                for(int j=0;j<n-1;j++){
                    x=sc.nextInt();
                    if(i>j)pq.add(new Pair(i*max+j,x));
                    else pq.add(new Pair(i*max+j+1,x));
                }
            }

            int[] ans=new int[n];
            Arrays.fill(ans,-1);

            while(!pq.isEmpty()){
                Pair p=pq.remove();

                x=p.x/max;
                y=p.x%max;



                if(ans[x]!=-1||ans[y]!=-1)continue;
                System.out.println(x+" y= "+y+" value= "+p.v);

                ans[x]=y+1;
                ans[y]=x+1;

                System.out.println(Arrays.toString(ans));

            }

            StringBuilder sb=new StringBuilder();
            for(int a:ans){
                if(a==-1){
                    sb=new StringBuilder(-1);
                    break;
                }else sb.append(a).append('\n');
            }

            System.out.println(sb);
        }
    }
}
class Pair implements Comparable<Pair>{
    int x,v;

    Pair(int x,int v){
        this.x=x;
        this.v=v;
    }

    public int compareTo(Pair oth){
        return v-oth.v;
    }


}