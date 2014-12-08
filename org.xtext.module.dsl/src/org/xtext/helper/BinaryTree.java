package org.xtext.helper;

import java.util.List;

public class BinaryTree<T> {
	
	private T value;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private BinaryTree<T> parent;
	
	public BinaryTree(){
		value = null;
		left = null;
		right = null;
		parent = null;
	}
	
	public BinaryTree(T r_value) {
		value = r_value;
		left = new BinaryTree<T>();
		right = new BinaryTree<T>();
		parent = null;
	}
	
	public BinaryTree(BinaryTree<T> bt){
		value = bt.getValue();
		left = bt.getLeft();
		right = bt.getRight();
		parent = bt.getParent();
	}
	
	public BinaryTree<T> getParent() {
		return parent;
	}
	
	public void setParent(BinaryTree<T> r_parent){
		this.parent = r_parent;
	}

	public T getValue(){
		return value;
	}
	
	public BinaryTree<T> getLeft(){
		return left;
	}
	
	public BinaryTree<T> getRight(){
		return right;
	}
	
	
	public boolean isEmpty(){
		return ((value==null) && (left == null) && (right == null));
	}
			
	public boolean isLeaf(){
		return !(this.isEmpty()) && (left.isEmpty()) && (right.isEmpty());
	}
	
	public void setTree(BinaryTree<T> bt) {
		this.value = bt.value;
		this.left = bt.left;
		this.right = bt.right;
		//parent is not modified
	}
	
	public void setRight(BinaryTree<T> bt) {
		this.right.value = bt.value;
		this.right.left = bt.left;
		this.right.right = bt.right;
		//parent is not modified
	}
	
	public void setLeft(BinaryTree<T> bt) {
		this.left.value = bt.value;
		this.left.left = bt.left;
		this.left.right = bt.right;
		//parent is not modified
	}
	
	public void search(T value, List<BinaryTree<T>> list) {
		if(this.isLeaf()){
			if(this.value.equals(value)){
				list.add(this);
			}
		}
		else{
			this.left.search(value, list);
			this.right.search(value, list);
		}
	}
	
	public BinaryTree<T> getSibling(BinaryTree<T> bt){
		if(!bt.isEmpty()){
			BinaryTree<T> parent = bt.parent;
			if(parent != null){
				if (parent.right == bt)
						return parent.left;
				else
						return parent.right;
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
	}
	
	public void print(){
		if(!isEmpty()){
			if(!isLeaf()){
				System.out.print("(");
				this.left.print();			
				System.out.print(" " + this.value.toString() + " ");
				this.right.print();
				System.out.print(")");
			}
			else{
				System.out.print(" " + this.value.toString() + " ");
			}
		}
	}
	
}
