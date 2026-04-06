// Exercicio 1
/*

1. Dadas as três versões de implementação de Fibonacci abaixo:
    
    * implemente os algortimos;
    * teste todos para os inteiros 4, 8, 16, 32; 
    * teste os dois últimos também para os inteiro 128, 1000 e 10.000.
    
   ```java
   FIBO-REC (n)
      se n ≤ 1
      então devolva n
      senão a ← FIBO-REC (n − 1)
            b ← FIBO-REC (n − 2)
            devolva a + b
   ```
    
   ```java
   FIBO (n)
        f [0] ← 0 
	f [1] ← 1
	para i ← 2 até n faça
           f[i] ← f[i-1]+f[i-2]
  	devolva f [n]
   ```
    
   ```java
   MEMOIZED-FIBO (f, n)
	para i ← 0 até n faça
	     f [i] ← −1
	devolva LOOKUP-FIBO (f, n)

   LOOKUP-FIBO (f, n)
	se f [n] ≥ 0
        então devolva f [n]
	se n ≤ 1
	então f [n] ← n
	senão f [n] ← LOOKUP-FIBO(f, n − 1) + LOOKUP-FIBO(f, n − 2)
	devolva f [n]
   ``` 
   
1. Monte uma tabela com a contabilização das execuções anteriores (número de iterações e número de instruções) e com os resultados das execuções. As linhas da tabela são os algoritmos implementados, as colunas os valores para testar e contabilizar.

*/

public class Ex01 {

    static long iteracoes = 0;
    static long instrucoes = 0;

    public static int FIBO_REC(int n){
        iteracoes++;

        if ( n <= 1 ){
            instrucoes++;
            return n;
        }

        instrucoes++;
        int a = FIBO_REC(n-1);

        instrucoes++;
        int b = FIBO_REC(n-2);
        
        instrucoes++;
        return a+b;
    }

    public static int FIBO(int n){

        iteracoes++;
        int[] f = new int[n+1];

        instrucoes++;
        f[0] = 0;
        
        instrucoes++;
        f[1] = 1;
        
        for (int i = 2; i <= n; i++){
            instrucoes++;
            f[i] = f[i-1]+f[i-2];
        }

        instrucoes++;
        return f[n];
    }

    public static int MEMOIZED_FIBO(int[] f, int n){
        
        for ( int i = 0; i <= n; i++){
            instrucoes++;
            f[i] = -1;
        }

        instrucoes++;
        return LOOKUP_FIBO(f, n);
    }

    public static int LOOKUP_FIBO(int[] f, int n){

        iteracoes++;

        if ( f[n] >= 0 ){
            instrucoes++;
            return f[n];
        }

        if ( n <= 1 ){
            instrucoes++;
            f[n] = n;
        } else {
            instrucoes++;
            instrucoes++;
            f[n] = LOOKUP_FIBO(f, n-1)+LOOKUP_FIBO(f, n-2);
        }

        return f[n];
    }

    public static void main(String[] args) {

        int n = 43;
        int[] f = new int[n+1];
        
        long t1 = System.nanoTime();
        System.out.println("resultado (rec): " + FIBO_REC(n));
        long t2 = System.nanoTime();
        System.out.println("tempo: " + (t2-t1) + "ns");
        System.out.println("iteracoes:" + iteracoes);
        System.out.println("instrucoes:" + instrucoes);
        instrucoes = 0;
        iteracoes = 0;
        System.out.println();

        t1 = System.nanoTime();
        System.out.println("resultado (fibo): " + FIBO(n));
        t2 = System.nanoTime();
        System.out.println("tempo: " + (t2-t1) + "ns");
        System.out.println("iteracoes:" + iteracoes);
        System.out.println("instrucoes:" + instrucoes);
        instrucoes = 0;
        iteracoes = 0;
        System.out.println();

        t1 = System.nanoTime();
        System.out.println("resultado (memoized): " + MEMOIZED_FIBO(f, n));
        t2 = System.nanoTime();
        System.out.println("tempo: " + (t2-t1) + "ns");
        System.out.println("iteracoes:" + iteracoes);
        System.out.println("instrucoes:" + instrucoes);
    }
}
