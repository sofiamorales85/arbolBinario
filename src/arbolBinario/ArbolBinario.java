package arbolBinario;

//Todos los metodos u operaciones del arbol
public class ArbolBinario {
	private NodoBinario raiz;
	private NodoBinario ultimo;
	private int numeroElementos;

	// Constructor
	public ArbolBinario() {
		raiz = null;
		numeroElementos = 0;
	}

	/**
	 * Obtiene el numero de elementos
	 * 
	 * @return tamaño de la lista
	 */
	public int getTamanio() {
		return numeroElementos;
	}

	/**
	 * Consulta si la lista esta vacia.
	 ** 
	 * @return true o false
	 */
	public boolean esVacia() {
		if (raiz == null) {
			return true;
		} else {
			return false;
		}
	}

	public NodoBinario getraiz() {
		return raiz;

	}

	/**
	 * Agrea un nodo al álbol binario
	 * 
	 * @param valorNodo
	 * @param nodo
	 */
	public void agregarNodo(int valorNodo, NodoBinario nodo) {
		NodoBinario nuevo;
		if (esVacia()) {
			nuevo = new NodoBinario(valorNodo);
			raiz = nuevo;
			ultimo = nuevo;
		} else {
			nuevo = new NodoBinario(valorNodo);
			if (valorNodo < nodo.getValorNodo()) {// Subarbol izquierdo
				if (nodo.getNodoIzquierda() == null) {
					NodoBinario actual = new NodoBinario(valorNodo);
					nodo.setNodoIzquierda(nuevo);
				} else {// No es null
					agregarNodo(valorNodo, nodo.getNodoIzquierda());
				}
			} else {// es mayor
				if (valorNodo > nodo.getValorNodo()) { // Subarbol derecho
					if (nodo.getNodoDerecha() == null) {
						NodoBinario actual = new NodoBinario(valorNodo);
						nodo.setNodoDerecha(nuevo);
					} else {// No es null
						agregarNodo(valorNodo, nodo.getNodoDerecha());
					}
				} else {
					System.out.println("El dato ya existe " + valorNodo);
				}
			}

		}

	}

	// BUSCAR NODO
	public NodoBinario buscar(int valorBuscar) {

		NodoBinario actual = raiz;
		while (actual.getValorNodo() != valorBuscar) {
			if (valorBuscar < actual.getValorNodo()) {// Si es menor
				actual = actual.getNodoIzquierda();
			} else {
				actual = actual.getNodoDerecha();
			}
			if (actual == null) {
				return null;
			}
		}
		return actual;// Si lo encontró
	}

	public boolean eliminar(int valorEliminar) {
		NodoBinario auxiliar = raiz;
		NodoBinario padre = raiz;
		boolean eshijoizquierdo = (auxiliar.getNodoIzquierda() != null);
		while (auxiliar.getValorNodo() != valorEliminar) {
			padre = auxiliar;
			if (valorEliminar < auxiliar.getValorNodo()) {// Si es menor
				auxiliar = auxiliar.getNodoIzquierda();
				eshijoizquierdo = true;

			} else {// Si es mayor
				auxiliar = auxiliar.getNodoDerecha();
				eshijoizquierdo = false;
			}
			if (auxiliar == null) {// No hay nodo
				return false;
			}
		}
		if (auxiliar.hoja()) {// hoja
			eliminarHoja(padre, auxiliar, eshijoizquierdo);
		} else {// Un hijo
			if (auxiliar.getNodoIzquierda() == null || auxiliar.getNodoDerecha() == null) {
				unHijo(padre, auxiliar, eshijoizquierdo);
			} else {// 2 hijos
				dosHijos(padre, auxiliar, eshijoizquierdo);
			}
		}
		return true;

	}
// Caso 1. que sea una hoja 
	private void dosHijos(NodoBinario padre, NodoBinario auxiliar, boolean eshijoizquierdo) {
		// TODO Auto-generated method stub
		if(auxiliar == raiz) {
			raiz = null;
		}else {
			if(eshijoizquierdo) {
				padre.setNodoIzquierda(null);
			}else {
				padre.setNodoDerecha(null);
			}
		}
	}
	// Caso 2. que tenga un hijo  
	private void unHijo(NodoBinario padre, NodoBinario auxiliar, boolean eshijoizquierdo) {
		// TODO Auto-generated method stub
		if(auxiliar == raiz) {
			if(auxiliar .getNodoIzquierda() == null) {
				raiz = auxiliar.getNodoDerecha();
			}else {
				raiz = auxiliar.getNodoIzquierda();
			}
		}else {
			if(eshijoizquierdo ) {
				if(auxiliar.getNodoIzquierda() == null ) {//Hijo derecho
					padre.setNodoIzquierda(auxiliar.getNodoDerecha());
				}else {//Hijo Izquierdo 
					padre.setNodoDerecha(auxiliar.getNodoIzquierda());
				}
			}else {
				if(auxiliar.getNodoIzquierda() == null ) {//Hijo derecho
					padre.setNodoDerecha(auxiliar.getNodoDerecha());
				}else {//Hijo Izquierdo 
					padre.setNodoDerecha(auxiliar.getNodoIzquierda());
				}
			}
		}
	}

	private void eliminarHoja(NodoBinario padre, NodoBinario auxiliar, boolean eshijoizquierdo) {
		// TODO Auto-generated method stub

	}

}
