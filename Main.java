public class Main {
	public static void main(String[] args) {
		RBTree tree = new RBTree();

		System.out.println("A self-balance tree:");

		tree.addRBNode(3);
		tree.addRBNode(89);
		tree.addRBNode(5);
		tree.addRBNode(1);
		tree.addRBNode(8);
		tree.addRBNode(7);
		tree.addRBNode(12);
		tree.addRBNode(51);
		tree.addRBNode(2);
		tree.addRBNode(9);

		System.out.println("Preorder:");
		System.out.print("\tLeft (imbalanced): ");
		tree.preorderLeft(tree.getRootOriginal());
		System.out.print("\tLeft (balanced): ");
		tree.preorderLeft(tree.getRoot());
		System.out.print("\n\tRight (imbalanced): ");
		tree.preorderRight(tree.getRootOriginal());
		System.out.print("\tRight (balanced): ");
		tree.preorderRight(tree.getRoot());

		System.out.println("\nPostorder:");
		System.out.print("\tLeft (imbalanced): ");
		tree.postorderLeft(tree.getRootOriginal());
		System.out.print("\tLeft (balanced): ");
		tree.postorderLeft(tree.getRoot());
		System.out.print("\n\tRight (imbalanced): ");
		tree.postorderRight(tree.getRootOriginal());
		System.out.print("\tRight (balanced): ");
		tree.postorderRight(tree.getRoot());

		System.out.println("\nInorder:");
		System.out.print("\tLeft (imbalanced): ");
		tree.inorderLeft(tree.getRootOriginal());
		System.out.print("\tLeft (balanced): ");
		tree.inorderLeft(tree.getRoot());
		System.out.print("\n\tRight (imbalanced): ");
		tree.inorderRight(tree.getRootOriginal());
		System.out.print("\tRight (balanced): ");
		tree.inorderRight(tree.getRoot());

		System.out.print("\n\nShowing imbalanced tree:");
		tree.traverse(tree.getRootOriginal());
		System.out.print("\n\nShowing balanced tree:");
		tree.traverse(tree.getRoot());

		System.out.print("\n\nShowing imbalanced tree (horizontal):");
		tree.traverseInOrder(tree.getRootOriginal(), 0);
		System.out.print("\n\nShowing balanced tree (horizontal):");
		tree.traverseInOrder(tree.getRoot(), 0);
	}
}

