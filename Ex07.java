/*

```
7. Implemente e teste o algoritmo de programação dinâmica para Distância de Edição. Contabilize o número de iterações. Utilize o mesmo repositório dos exercícios anteriores sobre programação dinâmica, como o mesmo grupo de trabalho. 
```
// Assumindo os Custos: Remoção=R, Inserção=I , Substituição=S e Match=M=0;

inteiro distEdProgDina(string A, String B)
	m = tamanho(A);
	n = tamanho(B);
	matriz[0][0] = 0;
	Para i = 1 até m
	   matriz[i][0] = matriz[i-1][0] + 1  // soma uma I;
	Para j = 1 até n
	   matriz[0][j] = matriz[0][j-1] + 1  // Soma uma R;
	Para i = 1 até m
	   Para j = 1 até n
	      Se A[i] == B[j]
		 custoExtra = 0 //Operação M;
	      Senão
		 custoExtra = 1 //Operação S;
	      matriz[i][j] = Mínimo(matriz[i-1][j] +1, matriz[i][j-1] +1, 
				    matriz[i-1][j-1] + custoExtra];
	devolva matriz[m][n];
```
8. Monte uma tabela com os resultados e número de iterações de ambas a implementações, para, pelo menos, os casos de testes disponíveis acima.

*/

public class Ex07 {
    public static void main(String[] args) {
        
    }
}
