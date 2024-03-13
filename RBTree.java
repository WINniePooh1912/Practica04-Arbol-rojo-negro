public class RBTree {
	private RBNode NIL;

	private RBNode root;
	private RBNode rootOriginal;

	RBTree() {
		NIL = RBNode.signalRB();
		root = NIL;
	}

	public RBNode getRoot() {
		return root;
	}

	public RBNode getRootOriginal() {
		return rootOriginal;
	}

	public int getHeight (RBNode branch) {
		if (branch == null)
			return -1;
		return branch.height;
		// return condition ? "isTrue" : "isFalse";
		// return (branch == null) ? -1 : branch.height;
	}

	private void updateHeight (RBNode branch) {
		branch.height = Math.max(getHeight(branch.left), getHeight(branch.right)) + 1;
	}

	private RBNode addRecursive(RBNode branch, int value) {
		if (branch == null)
			return new RBNode(value);

		if (value < branch.value)
			branch.left= addRecursive(branch.left, value);
		else if (value > branch.value)
			branch.right= addRecursive(branch.right, value);
		else
			return branch;

		updateHeight(branch);
		return branch;
	}

	public void addRBNode(int value) {
		RBNode newBranch = new RBNode(value, NIL);
		rootOriginal= addRecursive(rootOriginal, value);
		if(root == NIL) {
			root = newBranch;
			root.setBlack();
			return;
		}

		RBNode currentBranch = root;
		RBNode parentBranch = NIL;

		while(currentBranch != NIL) {
			parentBranch = currentBranch;
			if (value < currentBranch.value)
				currentBranch = currentBranch.left;
			else if (value > currentBranch.value)
				currentBranch = currentBranch.right;
			else
				return;
		}

		newBranch.parent = parentBranch;
		if (value < parentBranch.value)
			parentBranch.left = newBranch;
		else
			parentBranch.right = newBranch;

		balanceInsertion(newBranch);
		updateHeight(parentBranch);
	}

	private void balanceInsertion(RBNode branch) {
		RBNode parentBranch = branch.parent;

		while(parentBranch.isRed()) {
			RBNode uncle;
			if (parentBranch == parentBranch.parent.left) {
				uncle = parentBranch.parent.right;
				if(uncle.isRed()) {
					parentBranch.setBlack();
					uncle.setBlack();
					parentBranch.parent.setRed();
					branch = parentBranch.parent;
					parentBranch = branch.parent;
				} else {
					if(branch == parentBranch.right) {
						branch = parentBranch;
						leftRotation(branch);
						parentBranch = branch.parent;
					}
					parentBranch.setBlack();
					parentBranch.parent.setRed();
					rightRotation(parentBranch.parent);
				}
			} else {
				uncle = parentBranch.parent.left;
				if(uncle.isRed()) {
					parentBranch.setBlack();
					uncle.setBlack();
					parentBranch.parent.setRed();
					branch = parentBranch.parent;
					parentBranch = branch.parent;
				} else {
					if(branch == parentBranch.left) {
						branch = parentBranch;
						rightRotation(branch);
						parentBranch = branch.parent;
					}
					parentBranch.setBlack();
					parentBranch.parent.setRed();
					leftRotation(parentBranch.parent);
				}
			}
			if(branch == root)
				break;
			}
		root.setBlack();
	}

	private void leftRotation(RBNode branch) {
		RBNode newRoot = branch.right;
		RBNode newParent = newRoot.left;

		branch.right = newParent;
		if(newParent != NIL)
			newParent.parent = branch;
		newRoot.parent = branch.parent;

		if(branch.parent == NIL)
			root = newRoot;
		else if (branch == branch.parent.left)
			branch.parent.left = newRoot;
		else
			branch.parent.right = newRoot;

		newRoot.left = branch;
		branch.parent = newRoot;

		updateHeight(branch);
		updateHeight(newRoot);
	}

	private void rightRotation(RBNode branch) {
		RBNode newRoot = branch.left;
		RBNode newParent = newRoot.right;

		branch.left = newParent;
		if(newParent != NIL)
			newParent.parent = branch;
		newRoot.parent = branch.parent;

		if(branch.parent == NIL)
			root = newRoot;
		else if (branch == branch.parent.right)
			branch.parent.right = newRoot;
		else
			branch.parent.left = newRoot;

		newRoot.right = branch;
		branch.parent = newRoot;

		updateHeight(branch);
		updateHeight(newRoot);
	}

	public void preorderLeft(RBNode branch) {
		if (branch != null) {
			branch.print();
			preorderLeft(branch.getLeft());
			preorderLeft(branch.getRight());
		}
	}

    public void preorderRight(RBNode branch) {
		if (branch != null) {
			branch.print();
			preorderRight(branch.getRight());
			preorderRight(branch.getLeft());
		}
	}

	public void postorderLeft(RBNode branch) {
		if (branch != null) {
			postorderLeft(branch.getLeft());
			postorderLeft(branch.getRight());
			branch.print();
		}
	}

	public void postorderRight(RBNode branch) {
		if (branch != null) {
			postorderRight(branch.getRight());
			postorderRight(branch.getLeft());
			branch.print();
		}
	}

	public void inorderLeft(RBNode branch) {
		if (branch != null) {
			inorderLeft(branch.getLeft());

			branch.print();

			inorderLeft(branch.getRight());
		}
	}

	public void inorderRight(RBNode branch) {
		if (branch != null) {
			inorderRight(branch.getRight());
			branch.print();
			inorderRight(branch.getLeft());
		}
	}

	public void printOneLevel(RBNode branch, int level) {
		if (branch == null)
			return;

		if (level == 1) {
			System.out.print(branch.value + "\t* ");
			return;
		}

		printOneLevel(branch.left, level - 1);
		printOneLevel(branch.right, level - 1);
	}

	public void traverse(RBNode branch) {
		if (branch != null) {
			int height = getHeight(branch);
			for (int i = 0; i <= height; i++) {
				System.out.print("\n* ");
				printOneLevel(branch, i + 1);
			}
		} else
			System.out.println("The tree is empty :c");
	}

	public void traverseInOrder(RBNode branch, int spaces) {
        if (branch == null)
            return;

		spaces += 10;

        traverseInOrder(branch.right, spaces);

        System.out.print("\n");
        for (int i = 10; i < spaces; i++)
            System.out.print(" ");
        System.out.print(branch.value);

        traverseInOrder(branch.left, spaces);
    }
}
