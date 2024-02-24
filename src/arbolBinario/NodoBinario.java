package arbolBinario;

public class NodoBinario {
	private int valorNodo;
	private NodoBinario nodoDerecha;
	private NodoBinario nodoIzquierda;
	
	public NodoBinario(int valorNodo) {
		this.valorNodo = valorNodo;
		this.nodoDerecha = nodoDerecha;
		this.nodoIzquierda = nodoIzquierda;
	}

	public int getValorNodo() {
		return valorNodo;
	}

	public void setValorNodo(int valorNodo) {
		this.valorNodo = valorNodo;
	}

	public NodoBinario getNodoDerecha() {
		return nodoDerecha;
	}

	public void setNodoDerecha(NodoBinario nodoDerecha) {
		this.nodoDerecha = nodoDerecha;
	}

	public NodoBinario getNodoIzquierda() {
		return nodoIzquierda;
	}

	public void setNodoIzquierda(NodoBinario nodoIzquierda) {
		this.nodoIzquierda = nodoIzquierda;
	}
	
	public boolean hoja() {
		return (nodoDerecha == null && nodoIzquierda == null);
	}
	
}
