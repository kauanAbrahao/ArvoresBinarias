package principal;

public class No {
	int info;
	No left;
	No right;
	
	No(int info){
		this.info = info;
		this.left = null;
		this.right = null;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public No getLeft() {
		return left;
	}

	public void setLeft(No left) {
		this.left = left;
	}

	public No getRight() {
		return right;
	}

	public void setRight(No right) {
		this.right = right;
	}
	
	
}
