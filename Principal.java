package ArvoreAVL;

public class Principal {
public static void main(String[] args) {
	Arvore objArvore = new Arvore();

	for(int i = 0; i < 12; i++) {
		objArvore.inserir(i);
	}

	objArvore.mostrar();
		

	}
}
