package ast.nodes;

public class DartAllListsDeclaration extends DartVariablesDeclarationAbstractChild{

	DartAllListsDeclarationAbstractChild dartAllListsDeclarationAbstractChild;
	
	public DartAllListsDeclaration(DartAllListsDeclarationAbstractChild child,int line ,String parent,String type,int childCount) {
		super(line,parent, type, childCount);
		this.dartAllListsDeclarationAbstractChild=child;
	}

	@Override
	public String toString() {
		return "DartAllListsDeclaration: " + dartAllListsDeclarationAbstractChild +
				", line:" + line +
				", col: " + col +
				", type: " + type + '\'' +
				", childCount:" + childCount +
				", parent: " + parent + '\n';
	}
}
