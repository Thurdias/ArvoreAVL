package ArvoreAVL;

public class Arvore {
	// Propriedades da classe
	private No raiz = null;

	// Métodos da classe
	public boolean buscar(int numero) {
		return buscar(raiz, numero);
	}

	private boolean buscar(No raiz, int numero) {
		boolean retorno = false;

		if (raiz == null) {
			retorno = false;
		} else if (raiz.getNumero() == numero) {
			retorno = true;
		} else if (raiz.getNumero() > numero) {
			retorno = buscar(raiz.getEsquerdo(), numero);
		} else {
			retorno = buscar(raiz.getDireito(), numero);
		}

		return retorno;
	}

	public void navegar() {
		navegar(raiz);
	}

	private void navegar(No raiz) {
		if (raiz != null) {
			navegar(raiz.getEsquerdo());
			System.out.println(raiz.getNumero());
			navegar(raiz.getDireito());
		}
	}

	private int getAlturaDoNo(No raiz) {
		int retorno = 0;
		if (raiz != null) {
			retorno = raiz.getAltura();
		}
		return retorno;
	}
	
	private int getMaximoEntreDoisNumeros(int a, int b) {
		return(a > b) ? a : b;
	}
	
	private int getBalanco(No raiz) {
		int retorno = 0;
		
		if(raiz != null) {
			retorno = (getAlturaDoNo(raiz.getEsquerdo())) - getAlturaDoNo(raiz.getDireito());
		}
		return retorno;
	}
	
	private No rotacaoAEsquerda(No raiz) {
		No novaRaiz = raiz.getDireito();
		No temp = novaRaiz.getEsquerdo();
		novaRaiz.setEsquerdo(raiz);
		raiz.setDireito(temp);
		raiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerdo()), 
				getAlturaDoNo(raiz.getDireito()) + 1));	
		novaRaiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerdo()), 
				getAlturaDoNo(raiz.getDireito()) + 1));	
		
		return novaRaiz;
	}

	public void mostrar() {
		mostrar(raiz,""," (raiz)");
	}
	
	private void mostrar(No raiz, String espaco, String filho) {
		if (raiz != null) {
			System.out.println(espaco + raiz.getNumero() + filho);
			mostrar(raiz.getEsquerdo(), espaco + "\t", " (E)");
			mostrar(raiz.getDireito(), espaco + "\t", " (D)");
		}
	}
	
	private No rotacaoADireita(No raiz) {
		No novaRaiz = raiz.getEsquerdo();
		No temp = novaRaiz.getDireito();
		novaRaiz.setDireito(raiz);
		raiz.setEsquerdo(temp);
		raiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerdo()), 
				getAlturaDoNo(raiz.getDireito()) + 1));	
		novaRaiz.setAltura(getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerdo()), 
				getAlturaDoNo(raiz.getDireito()) + 1));	
		
		return novaRaiz;
	}
	
	public void inserir(int numero) {
		raiz = inserir(raiz, numero);
	}
	
	private No inserir(No raiz, int numero) {
		if(raiz == null) {
			raiz = new No(numero,1,null,null);
		} else if(raiz.getNumero() > numero) {
			raiz.setEsquerdo(inserir(raiz.getEsquerdo(), numero));
		} else if (raiz.getNumero() < numero) {
			raiz.setDireito(inserir(raiz.getDireito(), numero));
		}
		
		raiz.setAltura(1 + getMaximoEntreDoisNumeros(getAlturaDoNo(raiz.getEsquerdo()),
				        getAlturaDoNo(raiz.getDireito())));
		
		int balanco = getBalanco(raiz);
		
		if ((balanco > 1) && (numero < raiz.getEsquerdo().getNumero())) {
			raiz = rotacaoADireita(raiz);
		}
		
		if ((balanco < -1) && (numero > raiz.getDireito().getNumero())) {
			raiz = rotacaoAEsquerda(raiz);
		}
		
		if((balanco > 1) && (numero > raiz.getEsquerdo().getNumero())) {
			raiz.setEsquerdo(rotacaoAEsquerda(raiz.getEsquerdo()));
			raiz = rotacaoADireita(raiz);
		}
		
		if ((balanco < -1) && (numero < raiz.getDireito().getNumero())) {
			raiz.setDireito(rotacaoADireita(raiz.getDireito()));
			raiz = rotacaoAEsquerda(raiz);
		}
		
		return raiz;
	}
}