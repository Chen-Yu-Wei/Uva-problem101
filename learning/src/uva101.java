import java.util.Scanner;

public class uva101 {
    static int[][] block = new int[25][25];//total block
    static int[] height = new int[25];//each block height
    static int[] place = new int[25];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String first;
        String second;
        int a, b;
        for(int i = 0;i < n;i++){
            place[i] = i;
            block[i][1] = i;
            height[i] = 1;
        }
        while (sc.hasNext()){
            first = sc.next();
            if(first.equals("quit")){
                break;
            }
            a = sc.nextInt();
            second = sc.next();
            b = sc.nextInt();
            if(place[a] == place[b]){
                continue;
            }
            if(first.equals("move")&&second.equals("onto")){
                intial(a);
                intial(b);
                move(a,b);
            }
            else if(first.equals("move")&&second.equals("over")){
                intial(a);
                move(a,b);
            }
            else if(first.equals("pile")&&second.equals("onto")){
                intial(b);
                move(a,b);
            }
            else{
                move(a,b);
            }
        }
        for(int i = 0;i < n;i++){
            System.out.printf("%d:",i);
            for(int j = 1;j <= height[i];j++){
                System.out.printf(" %d",block[i][j]);
            }
            System.out.println("");
        }
    }

    public static void intial(int n) {
        int num;
        while (block[place[n]][height[place[n]]] != n){
            num = block[place[n]][height[place[n]]];
            place[num] = num;
            height[num]++;
            block[num][height[num]] = num;
            height[place[n]]--;
        }
    }
    public static void move(int aa,int bb){
        int num,j;
        for(int i = 1;i <= height[place[aa]];i++) {
            if (block[place[aa]][i] == aa) {
                num = place[aa];
                for(j = i;j <= height[num];j++){
                    height[place[bb]]++;
                    block[place[bb]][height[place[bb]]] = block[num][j];
                    place[block[num][j]] = place[bb];
                }
                height[num] = height[num] - (j-i);
                break;
            }
        }
    }
}
