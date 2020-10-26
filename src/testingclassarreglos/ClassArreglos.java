package testingclassarreglos;

/** @author Jonathan P. */

import java.util.Scanner;

public class ClassArreglos {
    
    /* 01.Bubble Sort                07.Imprimir Matriz
       02.Matriz Inversa             08.Resta de matrices
       03.Matriz Adjunta             09.Crear Matriz Irregular
       04.Matriz Identidad           10.Multiplicación de matrices
       05.Matriz en espiral          11.Ordenamiento por inserción
       06.Intercambio del min de     12.Intercambiar elementos de primera columna
       matrizA y el max de matrizB   con los de última columna de una matriz   */
    
    //01.BubbleSort
    public int[] BubbleSort(int arreglo[]){
        //Recibimos el arreglo que acomodaremos con ordenamiento burbuja
        /* Bucle desde 0 hasta la longitud del array -1 */
        for (int i = 0; i < arreglo.length - 1; i++) {
            /* Bucle anidado desde 0 hasta la longitud del array -1 */
            for (int j = 0; j < arreglo.length - 1; j++)
            { /* Si el número almacenado en la posición j es mayor que el de la posición j+1
                (el siguiente del array) */
                if (arreglo[j] > arreglo[j + 1]) {
                    /* guardamos el número de la posicion j+1 en una variable (el menor) */
                    int temp = arreglo[j + 1];
                    /* Lo intercambiamos de posición */
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = temp;
                    /* y volvemos al inicio para comparar los siguientes hasta que todos se hayan comparado*/
                    /* de esta forma vamos dejando los números mayores al final del areglo en orden*/
                }
            }
        }
        /* Mostramos el arreglo ordenado*/
       System.out.println("");//Salto de línea
       System.out.println("|--------ORDENADO-------|");
       System.out.println("|-----------------------|");
        /* Bucle para mostrar el arreglo desde la posicion 0 hasta la longitud del arreglo */
        for (int i = 0; i < arreglo.length; i++)
        {
         System.out.print(" Elemento " + (i + 1) + " -----> " + arreglo[i] + "\n");
        }
        System.out.println("|-----------------------|");
        return arreglo;
    }
    //02.Matriz Inversa
    public double[][] MatrizInversa(double matriz[][]){
        //Recibimos la matriz 3*3 que ocuparemos para el programa
        Scanner sc = new Scanner(System.in);
        //Declaramos variables
        double determinante,x00,x01,x02,x10,x11,x12,x20,x21,x22;
        // Matriz inversa
        double [][]inversa=new double [3][3];
        //Hallamos determinante de nuestra matriz principal
        determinante=(matriz[0][0]*((matriz[1][1]*matriz[2][2])-(matriz[1][2]*matriz[2][1])))-(matriz[0][1]*((matriz[1][0]*matriz[2][2])-(matriz[2][0]*matriz[1][2])))+(matriz[0][2]*((matriz[1][0]*matriz[2][1])-(matriz[2][0]*matriz[1][1])));
        System.out.println();
        System.out.println("Determinate:" + determinante);
        System.out.println();
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if(determinante!=0){
            x00=((matriz[1][1]* matriz[2][2] - matriz[2][1]* matriz[1][2]))/determinante;
            x01=(-(matriz[1][0]* matriz[2][2] - matriz[2][0]* matriz[1][2]))/determinante;
            x02=((matriz[1][0]* matriz[2][1] - matriz[2][0]* matriz[1][1]))/determinante;
            x10=(-(matriz[0][1]* matriz[2][2] - matriz[2][1]* matriz[0][2]))/determinante;
            x11=((matriz[0][0]* matriz[2][2] - matriz[2][0]* matriz[0][2]))/determinante;
            x12=(-(matriz[0][0]* matriz[2][1] - matriz[2][0]* matriz[0][1]))/determinante;
            x20=((matriz[0][1]* matriz[1][2] - matriz[1][1]* matriz[0][2]))/determinante;
            x21=(-(matriz[0][0]* matriz[1][2] - matriz[1][0]* matriz[0][2]))/determinante;
            x22=((matriz[0][0]* matriz[1][1] - matriz[1][0]* matriz[0][1] ))/determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            inversa[0][0]=x00;
            inversa[0][1]=x10;
            inversa[0][2]=x20;
            inversa[1][0]=x01;
            inversa[1][1]=x11;
            inversa[1][2]=x21;
            inversa[2][0]=x02;
            inversa[2][1]=x12;
            inversa[2][2]=x22;
            // Mostramos la matriz inversa
            System.out.println("Matriz Inversa: ");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ inversa[i][j] +"|");
                }
                System.out.println();
            } 
        }
        else{
            System.out.print("Error la matriz no tiene inversa");
        }
        return inversa;
    }
    //03.Matriz Adjunta
    public int[][] MatrizAdjunta(){
        Scanner sc = new Scanner (System.in);
        //Creamos la matriz original y la matriz adjunta que será el resultado
        int matrizA[][]=new int[3][3];
        int matrizAdjun[][]=new int[3][3];
        
        //introducimos números en la Matriz A
        System.out.println("Introduce los números en la Matriz A:");
        System.out.println("Introduce los números de la Matriz A:");
        for(int i=0;i<3;i++){
             for(int j=0;j<3;j++){
                  System.out.print("Fila "+(i+1)+" Columna "+(j+1)+" = "); 
                  matrizA[i][j]=sc.nextInt();
             }     
        }      
        System.out.println("");
       //Mostramos los números introducidos
       System.out.println("Esta es la matriz introducida:");
       
       System.out.println("");
       System.out.println("MATRIZ A");
       System.out.println("-----------");
      
       for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                
                 System.out.print(matrizA[i][j]+" ");
            }   
            System.out.println();
       }
        System.out.println();
        
       //CALCULO DE ADJUNTOS
       matrizAdjun[0][0]=(matrizA[1][1]*matrizA[2][2]) - (matrizA[1][2]*matrizA[2][1]);
       matrizAdjun[0][1]=-((matrizA[1][0]*matrizA[2][2]) - (matrizA[1][2]*matrizA[2][0]));
       matrizAdjun[0][2]=(matrizA[1][0]*matrizA[2][1]) - (matrizA[1][1]*matrizA[2][0]);
       
       matrizAdjun[1][0]=-((matrizA[0][1]*matrizA[2][2]) - (matrizA[0][2]*matrizA[2][1]));
       matrizAdjun[1][1]=(matrizA[0][0]*matrizA[2][2]) - (matrizA[0][2]*matrizA[2][0]);
       matrizAdjun[1][2]=-((matrizA[0][0]*matrizA[2][1]) - (matrizA[0][1]*matrizA[2][0]));
       
       matrizAdjun[2][0]=(matrizA[0][1]*matrizA[1][2]) - (matrizA[0][2]*matrizA[1][1]);
       matrizAdjun[2][1]=-((matrizA[0][0]*matrizA[1][2]) - (matrizA[0][2]*matrizA[1][0]));
       matrizAdjun[2][2]=(matrizA[0][0]*matrizA[1][1]) - (matrizA[0][1]*matrizA[1][0]);
       
       
       //MATRIZ ADJUNTA
       System.out.println("la Matriz Adjunta de la Matriz A es: ");
       for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){                
                 System.out.print(matrizAdjun[i][j]+" "); 
           }   
          System.out.println(); //Salto de línea
       }
      System.out.println();
      return matrizAdjun;
    }
    //04.Matriz Identidad
    public void MatrizIdentidad(int matriz[][]){
        //Deberemos recibir una matriz vacía
        //Llenamos la matriz con el número '0'
        for(int i=0; i<matriz.length; i++){
            for (int x=0; x<matriz[i].length; x++){
                matriz[i][x] = 0;
            }
        }
        //En la diagonal de la matriz, cambiamos el valor por el número '1'
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][i] = 1;
        }
        //Imprimimos la matriz
        System.out.println("Esta es la Matriz Identidad: ");
        for (int[] A1 : matriz) {
            for (int j = 0; j < A1.length; j++) {
                System.out.print(A1[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //05.Matriz Caracol/Espiral
    public int[][] MatrizEspiral(int n, int x) {
        //n será la dimension de la matriz
        //x es el numero de donde empezará la matriz
        
        //Creamos la matriz que mostraremos en forma de espiral
        int[][] matrizEsp = new int[n + 1][n + 1];
        //Generamos la forma de espiral
        for (int a = 1; a <= n / 2; a++) {
            for (int i = a; i <= n - a; i++) {
                matrizEsp[a][i] = x;
                x++;
            }
            for (int i = a; i <= n - a; i++) {
                matrizEsp[i][n - a + 1] = x;
                x++;
            }
            for (int i = n - a + 1; i >= a + 1; i--) {
                matrizEsp[n - a + 1][i] = x;
                x++;
            }
            for (int i = n - a + 1; i >= a + 1; i--) {
                matrizEsp[i][a] = x;
                x++;
            }
        }
        if (n % 2 == 1) {
            matrizEsp[n / 2 + 1][n / 2 + 1] = x;
        }
        //Imprimimos la matriz
        System.out.println("Matriz en espiral:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("\t" + matrizEsp[i][j]);
            }
            System.out.println();
        }
        return matrizEsp;
    }
    //06.Intercambiar el valor mínimo con el valor Máximo entre MatrizA y MatrizB
    public void IntercambioMinMax(int matrizA[][], int matrizB[][]){
           //Variables a ocupar
           int M = 1;
           //Creamos las matrices donde se guardara el resultado
           int A[][] = new int[matrizA.length][matrizA.length];
           int B[][] = new int[matrizB.length][matrizB.length];
          //Comprobamos que se pueda hacer el intercambio
          if(matrizA.length == matrizB.length ){
            
            System.out.println("Resultado del intercambiar de los mínimos de A con los máximos de B");
            System.out.println("===============================");
            System.out.println("Valores de la Matriz a y b ANTES del intercambio: ");
            
            for ( int i=0; i<matrizA.length; i++){
               for ( int j=0; j<matrizA[0].length; j++){
                System.out.print(matrizA[i][j] + " ");
               }
            }
            System.out.print("   ");
             for ( int k=0; k<matrizB.length; k++){
               for ( int j=0; j<matrizB[0].length; j++){
                System.out.print(matrizB[k][j] + " ");
               }
            }
            System.out.print("   ");
            //Encontramos el valor menor matrizA
            int min_a = matrizA [2] [2];
            for (int i = 0 ; i < matrizA.length ; i++)
            {
             for (int j = 0 ; j < matrizA[0].length ; j++)
             {
             if (matrizA [i] [j] < min_a)
                 min_a = matrizA [i] [j];
               }
             }   
            //Encontramos el valor menor matrizB
            int min_b = matrizB [2] [2];
            for (int i = 0 ; i < matrizB.length ; i++)
            {
             for (int j = 0 ; j < matrizB[0].length ; j++)
             {
             if (matrizB [i] [j] < min_b)
                 min_b = matrizB [i] [j];
               }
             }   
            //Encontamos el valor máximo matrizA
             int max_a = matrizA [2] [2];
             for (int i = 0 ; i < matrizA.length ; i++)
            {
            for (int j = 0 ; j < matrizA[0].length ; j++)
         {
             if (matrizA [i] [j] < max_a)
             max_a = matrizA [i] [j];
              }
            }
              //Encontamos el valor máximo matrizB
             int max_b = matrizB [2] [2];
             for (int i = 0 ; i < matrizB.length ; i++)
            {
            for (int j = 0 ; j < matrizB[0].length ; j++)
         {
             if (matrizB [i] [j] < max_b)
             max_b = matrizB [i] [j];
              }
            }
            //Hacemos el intercambio
            
            //para cambiar los minimos de A con los maximos de B
    for (int i = 0 ; i <= matrizA.length ; i++)
    {
        for (int j = 0 ; j <= matrizA[0].length ; j++)
        {
        if (matrizA [i] [j] == min_a)
            A [i] [j] = max_b;
        }
    }
    //para intercambiar los maximos de con los minimos de A
    for (int i = 0 ; i <= matrizB.length  ; i++)
    {
        for (int j = 0 ; j <= matrizB[0].length ; j++)
        {
        if (matrizB [i] [j] == max_b)
            B [i] [j] = min_a;
        }
    }
    
            System.out.println("");
            System.out.println("===============================");
            System.out.println("Valores de la matriz a y b DESPUES del intercambio: ");
            for ( int i=0; i<A.length; i++){
              for ( int j=0; j<A[0].length; j++){
                System.out.print(A[i][j] + " ");
              }
            }
            System.out.print("   ");
             for ( int k=0; k<B.length; k++){
               for ( int j=0; j<B[0].length; j++){
                System.out.print(B[k][j] + " ");
               }
            }
        
        } else {
            System.out.println("los renglones tienen que COINCIDIR");
            System.exit(0);
        }
    }
    //07.Imprimir una matriz
    public void ImprimirMatriz(int matriz[][]){
        //Recibimos la matriz que vamos a imprimir
        System.out.println("MATRIZ: ");
        for (int[] matriz1 : matriz)
        {
          for (int j = 0; j < matriz1.length; j++)
            {
              System.out.print(matriz1[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //08.Resta de matrices
    public int[][] RestaMatrices(int matrizA[][], int matrizB[][]){
    //Recibimos ambas matrices que restaremos
    
    //Creamos la matriz en la que guararemos el resultado. De el mismo tamaño que las matrices A y B
    int[][] resultado = new int[matrizA.length][matrizA[0].length];
    //Hacemos la resta
    for (int x=0; x < resultado.length; x++)
    {
      for (int y=0; y < resultado[x].length; y++)
       {
       resultado [x][y] = matrizA[x][y] - matrizB[x][y];
       }
     }
    System.out.println("El resultado de restar ambas matrices es: ");
    for (int i = 0; i <resultado.length; i++) {
            for (int j = 0; j <resultado[0].length; j++) {
                System.out.print("\t" + resultado[i][j]);
            }
            System.out.println();
        }
        return resultado;
}
    //09.Crear Matriz Irregular
    public int[][] MatrizIrregular(){
        Scanner sc = new Scanner(System.in);
        //Creamos variables para filas y columnas
        int f, c;
        System.out.println("Inserte filas de la matriz");
        f= sc.nextInt();
        int [][]matriz = new int[f][];
        for (int i = 0; i < matriz.length; i++)
        {
            System.out.println("¿Cuantas columnas tendrá la fila " +i+ "?");
            c = sc.nextInt();
            matriz [i] = new int[c];//guardamos las columnas en la matriz
        }
        //Regresamos la matriz creada
        return matriz;
    }
    //10.Multiplicación de Matrices
    public int[][] MultiplicacionMatrices ( int[][] matrizA, int[][] matrizB) {
      //Creamos una matriz en la que vamos a guardar el rsultado
      int[][] resultado = new int[matrizA.length][matrizB[0].length];
      for (int i= 0; i<resultado.length; i++)
          for (int j=0; j<resultado[0].length; j++)
              for (int k=0; k<matrizB.length; k++)
                 resultado[i][j] = resultado[i][j] + matrizA[i][k] * matrizB[k][j];
      //Regresamos la matriz de resultado
      return resultado;
   }
    //11.Ordenamiento por inserción
    public void ordenarPorInsercion(int a[]){
        //Recibimos el arreglo sin ordenamiento
        //Declaramos nuestras variables
        int clave, i, N=a.length;
        //Hacemos el ordenamiento
        for (int j = 1; j <N; j++) {
            clave = a[j];
            i = j-1;
            while(i>-1 && a[i]>clave){
            a[i+1] = a[i];
            i = i-1;
          }
          a[i+1] = clave;
        }
        //Mostramos el resultado
        System.out.println("");//Salto de línea
        System.out.println("La matriz ordenada es: ");
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j]+" ");
        }
        System.out.println("\n");
    }
    /*12.Dada una matriz, intercambiar los elementos de la primera columna con los de la última */
    public int[][] IntercambioFilas(){//
        //Creamos la matriz que ocuparemos
        int[][] matriz = new int [5][5];
        //Creamos un contador para hacer el intercambio
        int cont=1;
        for(int fila=0; fila<matriz.length; fila++)
        {
           for(int col=0; col<matriz[fila].length; col++)
           {
              matriz[fila][col]= cont;
              cont++;
           }
        }
        //Imprimimos la matriz original
        System.out.println("Matriz original: ");
        for(int fila = 0; fila < matriz.length; fila++)
         { 
            for(int col = 0; col < matriz[fila].length; col++)
              { 
                 System.out.print(matriz[fila][col] + "\t");        
              } 
           System.out.println();
        }        
        //Iniciamos con el intercambio
        int [][] a = matriz;
        int[][] matriz1 = a;
        int cont1=1;
        int[] aux= new int[5];
        int[] auxU= new int[5];
        for(cont=0; cont<5; cont++)
         {
          auxU[cont]= matriz[cont][4];
         }
        for(int fila = 0; fila < matriz.length; fila++)
         { 
           for(int col = fila; col > 0; col--)
            { 
               matriz[fila][col]= matriz[fila][col-1];
            } 
         }
        for(cont=0; cont<5; cont++)
        {
         matriz[cont][0]= auxU[cont];
        }
        for(cont=0; cont<5; cont++)
          {
            aux[cont]= matriz[cont][1];
          }
        for(int fila = 0; fila < matriz.length; fila++)
         { 
            for(int col = 1; col < fila; col++)
             { 
               matriz[fila][col]= matriz[fila][col+1];
             } 
         }
        for(cont=0; cont<5; cont++)
          {
           matriz[cont][4]= aux[cont];
          }
        System.out.println();
        System.out.println("Matriz intercambiada");//Imprimimos la matriz intercambiada
        System.out.println();
        for(int fila = 0; fila < matriz.length; fila++)
         { 
          for(int col = 0; col < matriz[fila].length; col++)
           {
            System.out.print(matriz[fila][col] + "\t");
           } 
           System.out.println();
        }
        return matriz;
    }
}