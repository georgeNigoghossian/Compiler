package ast.nodes;

import ast.variables.NumberClass;

public class WidthPropertyDeclaration extends ContainerPropertiesDeclarationAbstractChild {
	NumberClass number ;
	
	public WidthPropertyDeclaration(NumberClass number,int line ,String parent) {
		super(line,parent);
		this.number = number;
	}
	
	@Override
	public String toString() {

		return "Width Property Declaration line: "+getLine() + " parent "+getParent()
				+number.toString();
	}
}
