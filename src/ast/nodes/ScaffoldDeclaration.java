package ast.nodes;

public class ScaffoldDeclaration extends WidgetAbstractChild {
	BodyPropertyDeclaration bodyPropertyDeclaration;
	
	public ScaffoldDeclaration(BodyPropertyDeclaration bodyPropertyDeclaration) {
		this.bodyPropertyDeclaration = bodyPropertyDeclaration;
	}
}