package ArvoreAVL;

public class No {
	// Propriedades da classe
	private int numero = 0;
	private int altura = 0;
	private No esquerdo = null;
	private No direito = null;
	
	// M�todos construtores da classe
	public No() {
		super();
	}
	public No(int numero, int altura, No esquerdo, No direito) {
		super();
		this.numero = numero;
		this.altura = altura;
		this.esquerdo = esquerdo;
		this.direito = direito;
	}
	
	// M�todos get/set da classe
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public No getEsquerdo() {
		return esquerdo;
	}
	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}
	public No getDireito() {
		return direito;
	}
	public void setDireito(No direito) {
		this.direito = direito;
	}
	
	
}
