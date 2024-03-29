package ast.nodes;

import ast.variables.NumberClass;

public class EdgeInsistAll extends Node{
	NumberClass number;
	
	public EdgeInsistAll(NumberClass number,int line ,String parent,String type,int childCount) {
		super(line,parent, type, childCount);
		this.number = number;
	}
	
	@Override
	public String toString() {

		return "Edge Insist All "+ " line:"+getLine() + " parent "+getParent()
				+" Child Count =  "+getChildCount()+" Type = "+getType()+"\n"
				+number.toString()
				;
	}
}
