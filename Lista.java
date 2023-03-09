import java.util.Arrays;

public class Lista {
   Integer[] tabla; //declaramos el atributo tabla

   public Lista() {
      tabla = new Integer[0];
   }  //constructor inicalizando la tabla en 0

   void insertarPrincipio(Integer nuevo) {
      tabla = Arrays.copyOf(tabla, tabla.length + 1);  //aumenta 1 posicion mas el array
      System.arraycopy(tabla, 0, tabla, 1, tabla.length - 1); // System.arraycopy(tablaOrigen, posicionOrigen, tablaDestino,posicionDestino,longitud)
      tabla[0] = nuevo;  //insertamos en la posicion 0 el elemento
   }

   void insertarFinal(Integer nuevo) {
      tabla = Arrays.copyOf(tabla, tabla.length + 1); //aumentamos en 1
      tabla[tabla.length - 1] = nuevo;// insertamos en la ultima posicion el nuevo elemento
   }
   void insertar(int posicion, Integer nuevo) {//insertamos un numero en el lugar de la lista que se pasa como parámetro
      tabla = Arrays.copyOf(tabla, tabla.length + 1);//aumentamos la longitud de la lista +1
      System.arraycopy(tabla, posicion, tabla, posicion + 1, tabla.length - posicion - 1); //hacemos el hueco para poder insetar el nuevo elemento, haciendo que se copie la
      // misma tabla pero la posicion que pasamos le sumamos 1, para dejar esa libre
      tabla[posicion] = nuevo;
   }

   void insertarFinal(Lista otraLista) {//recibimos la otra tabla que insertaremos en la tabla original
      int tamIni = tabla.length; //le asignamos a tamIni el tamaño actual de la tabla para luego crear en la proxima linea la otra lista
      tabla = Arrays.copyOf(tabla, tabla.length + otraLista.tabla.length);//aumentamos el tamaño de la tabla con la longitud de la tabla+la otra tabla que insertaremos
      System.arraycopy(otraLista.tabla, 0, tabla, tamIni, otraLista.tabla.length);// System.arraycopy(tablaOrigen, posicionOrigen, tablaDestino,posicionDestino,longitud)
   }


   Integer eliminar(int indice) {
      Integer eliminado = null;
      if (indice >= 0 && indice < tabla.length) {  // condicionamos que el indice enviado sea correcto y este entre los límites  de la longitud del array
         eliminado = tabla[indice]; //le asignamos a eliminado el indice
         for (int i = indice + 1; i < tabla.length; i++) { //recorremos el array a partir del indice y lo movemos un lugar menos
            tabla[i - 1] = tabla[i];
         }
         tabla = Arrays.copyOf(tabla, tabla.length - 1);//eliminarmos una posicion al array
      }
      return eliminado; //regresamos el elmento eliminado
   }

   Integer get(int indice) { //getter indice, condicionando que este entre los límites del array
      Integer resultado = null;
      if (indice >= 0 && indice < tabla.length) {
         resultado = tabla[indice];
      }
      return resultado;
   }

   int buscar(Integer claveBusqueda) { //buscamos un elemento recorriendo el array
      int indice = -1;//flag  que hace que siguiente bucle se interrumpa cuando encuentre el elemento buscado
      for (int i = 0; i < tabla.length && indice == -1; i++) {
         if (tabla[i].equals(claveBusqueda)) {
            indice = i;
         }
      }
      return indice;
   }

   public int numeroElementos() {
      return tabla.length;
   } //mostramos la longitud de la tabla

   public void mostrar() {
      System.out.println("Lista: " + Arrays.toString(tabla));
   } //mostramos los elementos de la tabla
}
