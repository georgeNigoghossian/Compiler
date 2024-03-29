package ast.variables;

import ast.nodes.Node;

public class AddExpression extends Node {
	public NumberClass value;


	public AddExpression(NumberClass value, int line, String parent,String type,int childCount) {
		super(line, parent, type, childCount);
		this.value = value;

	}

	@Override
	public String toString() {
		return "Add expression: " +"value: "+value.num+ " line: " + getLine() + " parent: " + getParent()+
				" Child Count =  "+getChildCount()+" Type = "+getType()+"\n"
				+ value;
	}
}
