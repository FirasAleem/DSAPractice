public class ComputeResultPrim {
    public static void main(String[] args) {
        int[] p = {0, 0, 1, 2};
        int[] path = new int[p.length];
        int count = p.length-1;
        int end = 2;
        int x = 2;
        while (p[x]!=x){
            path[count--] = end;
            x = p[x];
            end = p[x];
        }
        for (int i = 0; i < path.length; i++) {
            System.out.println(path[i]);
        }
    }


}
