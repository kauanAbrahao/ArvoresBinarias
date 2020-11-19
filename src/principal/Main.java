package principal;

public class Main {
	public static void main(String[] args) {
		int vetor[] = new int[] {40, 5, 4, 10, 240, 31, 55, 77, 32, 41};
		Tree tree = new Tree();
		
		for (int i = 0; i<10; i++) {
			tree.insert(vetor[i], tree.root);
		}
		System.out.print("\nPre-Order: ");
		tree.preOrder(tree.root);
		
		System.out.print("\nIn-Order: ");
		tree.inOrder(tree.root);
		
		System.out.print("\nPos-Order: ");
		tree.posOrder(tree.root);
		
		System.out.println("\nAltura da árvore: " + tree.obtemAltura(tree.root));
		
		System.out.println("\nBuscar valor 4:");
		System.out.println((tree.busca(tree.root, 4)? "Valor encontrado" : "Valor não encontrado"));
		
		System.out.println("\nRemover valor 32");
		tree.remover(32);
		
		System.out.print("In-Order: ");
		tree.inOrder(tree.root);
		System.out.println("\nAltura da árvore: " + tree.obtemAltura(tree.root));
		
		
	}

}
