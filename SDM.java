import java.util.ArrayList;

public class SDM {
    static class Intervalo{
        public int s;
        public int f;
        public Intervalo(int s, int f){
            this.s=s;
            this.f=f;
        }
        @Override
        public String toString(){
            return "("+s+","+f+")";
        }
    }
    public static void main(String[] args){
        //assume-se que f está em ordem crescente e nenhum s[i]>f[i].
        ArrayList<Intervalo> S = new ArrayList<Intervalo>();
        S.add(new Intervalo(2,4));      S.add(new Intervalo(4,5));
        S.add(new Intervalo(1,6));      S.add(new Intervalo(6,7));
        S.add(new Intervalo(4,8));      S.add(new Intervalo(6,9));
        S.add(new Intervalo(7,10));     S.add(new Intervalo(9,11));
        S.add(new Intervalo(9,12));     S.add(new Intervalo(3,13));
        S.add(new Intervalo(13,14));

        ArrayList<Intervalo> X = SdmGuloso(S);
        System.out.println(X);
    }
    public static ArrayList<Intervalo> SdmGuloso(ArrayList<Intervalo> S){
        ArrayList<Intervalo> X = new ArrayList<Intervalo>();
        //adiciona o primeiro intervalo de S em X.
        X.add(S.get(0));
        int i = 1;
        int j = 0;
        //itera sobre S
        while(i<S.size()){
            if( X.get(j).f < S.get(i).s ){
                //se o atual de S, for posterior do ultimo de X, ele entra em X
                X.add(S.get(i));
                j++;
                i++;
            }
            else{
                //se não ele (o intervalo atual de S) vai tornar X não disjunto e por isso deve ser ignorado
                i++;
            }
        }
        return X;
    }
}