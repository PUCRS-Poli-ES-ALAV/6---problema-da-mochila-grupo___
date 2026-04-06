/*

Resolva o problema da mochila utilizando o algoritmo com programação dinâmica visto em aula, teste e contabilize o número de iterações.

```javascript
Inteiro backPackPD(Inteiro N, Inteiro C, Tupla<Inteiro, Inteiro> itens)
   N = número de produtos;
   C = capacidade real da mochila
   itens[N +1];   // (O índice 0 guarda null), Tupla com peso e valor
   maxTab[N+1][C+1];

   Inicialize com 0 toda a linha 0 e também a coluna 0;
   para i = 1 até N
      para j = 1 até C
         se item itens[i].peso <= j // se o item cabe na mochila atual
            maxTab[i][j] = Max(maxTab[i-1][j], 
                               itens[i].valor + 
                                 maxTab[i-1][j – itens[i].peso]);
         senão
            maxTab[i][j] = maxTab[i-1][j];

   retorne maxTab[N][C] // valor máximo para uma mochila de capacidade C e 		         
                        //que pode conter itens que vão do item 1 até o item N.
```

5. Monte uma tabela com os resultados e número de iterações e instruções de ambas a implementações, para os casos de testes disponíveis no moodle.


*/

import java.util.*;

public class Ex04 {

    static long iteracoes = 0;
    static long instrucoes = 0;
    static List<Integer> selecionados = new ArrayList<>();

    public static int backPackPD(int N, int C, int[][] itens) {

        int[][] maxTab = new int[N + 1][C + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                maxTab[i][j] = 0;
                instrucoes++;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                iteracoes++;

                if (itens[i][0] <= j) {

                    maxTab[i][j] = Math.max(maxTab[i - 1][j],
                                            itens[i][1] +
                                            maxTab[i - 1][j - itens[i][0]] );
                    instrucoes++;

                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                    instrucoes++;
                }
            }
        }

        for (int i = N, j = C; i >= 1; i--) {
            if (maxTab[i][j] != maxTab[i - 1][j]) {
                selecionados.add(i);
                j -= itens[i][0];
            }
        }

        Collections.reverse(selecionados);

        return maxTab[N][C];
    }

    public static void main(String[] args) {

        int[] pesos1 = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int[] valores1 = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72};

        int N1 = pesos1.length;
        int[][] itens1 = new int[N1 + 1][2];

        for (int i = 1; i <= N1; i++) {
            itens1[i][0] = pesos1[i - 1];
            itens1[i][1] = valores1[i - 1];
        }

        long t1 = System.nanoTime();
        int valor1 = backPackPD(N1, 165, itens1);
        long t2 = System.nanoTime();

        System.out.println("caso 1");
        System.out.println("valor: " + valor1);
        System.out.println("blocos: " + selecionados);
        System.out.println("tempo: " + (t2-t1) + "ns");
        System.out.println("iteracoes: " + iteracoes);
        System.out.println("instrucoes: " + instrucoes);
        iteracoes = 0;
        instrucoes = 0;
        selecionados.clear();
        System.out.println();


        int[] pesos2 = {56, 59, 80, 64, 75, 17};
        int[] valores2 = {50, 50, 64, 46, 50, 5};

        int N2 = pesos2.length;
        int[][] itens2 = new int[N2 + 1][2];

        for (int i = 1; i <= N2; i++) {
            itens2[i][0] = pesos2[i - 1];
            itens2[i][1] = valores2[i - 1];
        }

        int valor2 = backPackPD(N2, 190, itens2);

        System.out.println("caso 2");
        System.out.println("valor: " + valor2);
        System.out.println("blocos: " + selecionados);
        System.out.println("iteracoes: " + iteracoes);
        System.out.println("instrucoes: " + instrucoes);
    }
}