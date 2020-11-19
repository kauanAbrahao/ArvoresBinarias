package principal;

public class Tree {
	No root = null;
	int size = 0;
	
	void insert(int info, No place) {
		
		if (place == null) {
			System.out.print(" " + info);
			root = new No (info);
		} else if(info<place.getInfo()) {
			if (place.left == null) {
				System.out.print(" " + info);
				place.left = new No(info);
			} else {
				insert(info, place.getLeft());
			}
		} else if (info > place.getInfo()) {
			if(place.right == null) {
				System.out.print(" " + info);
				place.right = new No(info);
			} else {
				insert(info,place.getRight());
			}
		}
	}
	
	void preOrder (No place) {
		System.out.print(" " + place.getInfo());
		if (place.getLeft() != null) {
			preOrder(place.getLeft());
		}
		
		if(place.getRight() != null) {
			preOrder(place.getRight());
		}
	}
	
	void inOrder(No place) {
		if(place.getLeft() != null) {
			inOrder(place.getLeft());
		}
		System.out.print(" " + place.getInfo());
		if (place.getRight()!=null) {
			inOrder(place.getRight());
		}
		
	}
	
	void posOrder(No place) {
		if(place.getLeft() != null) {
			posOrder(place.getLeft());
		}
		if(place.getRight() != null) {
			posOrder(place.getRight());
		}
		System.out.print(" " + place.getInfo());
	}
	
	public boolean busca(No place, int valor) {
		if(root == null) {
			return false;
		}
		if(place.getInfo() == valor) { 
			return true;
		} 
		else { 
			if (valor < place.getInfo()) { 
				
				if(place.getLeft() == null) { 
					return false;
				}
				else { 
					return busca(place.getLeft(), valor);
				}
			}
			else {
				if(valor> place.getInfo()) {
					
					if(place.getRight() == null) { 
						return false;
					}	
					 else {
						return busca(place.getRight(), valor);
					 }	
				}
				return false;
			
			}
		}
	}



	public boolean remover(int valor) {
		No atual = root;
		No pai = root;
		boolean filho_esq = true;
		
		if (root == null) {
			return false;
		}
		
		//buscando o valor a ser removido
		while(atual.getInfo() != valor) {
			pai = atual;
			if(valor < atual.getInfo()) {
				atual = atual.getLeft();
				filho_esq = true;
			}
			else {
				atual = atual.getRight();
				filho_esq = false;
			}
			
			if(atual == null) { //encontrou uma folha
				return false;
			}
		}
		
		//Encontramos o valor. 
		//Se for uma folha, é só eliminar
		if(atual.getLeft() == null && atual.getRight() == null) {
			if(atual == root) root = null; //se for raíz
			else if(filho_esq) pai.left = null;
			else pai.right = null;
		}
		
		//Se há filhos à esquerda mas não à direita
		else if(atual.right == null) {
			if (atual == root) root = atual.left;
			else if (filho_esq) pai.left = atual.left;
			else pai.right = atual.left;
		}
		
		//Se há filhos à direita mas não à esquerda
		else if(atual.left == null) {
			if(atual == root) root = atual.right;
			else if (filho_esq) pai.left = atual.right;
			else pai.right = atual.right;
		}
		
		//Se há filhos em ambos os lados
		else {
			No sucessor = achaNoSucessor(atual);
			if (atual == root) root = sucessor;
			else if(filho_esq) pai.left = sucessor;
			else pai.right = sucessor;
			sucessor.left = atual.left;
		}
		return true;
	}

	//Menor valor da subárvore da direita
	private No achaNoSucessor(No atual) {
		No paidosucessor = atual;
		No sucessor = atual;
		No aux = atual.right;
		
		while(aux != null) {
			paidosucessor = sucessor;
			sucessor = aux;
			aux = aux.left;
		}
		
		if(sucessor != atual.right) {
			paidosucessor.left = sucessor.right;
			sucessor.right = atual.right;
		}
		return sucessor;
	}

	public int obtemAltura(No aux) {
		if(aux == null || (aux.getLeft() == null && aux.getRight() == null)){
			return 0;
		}
		
		if(obtemAltura(aux.left) > obtemAltura(aux.right)) {
			return (1+obtemAltura(aux.left));
		}
		else {
			return (1+obtemAltura(aux.right));
		}
		
		
	}
}
