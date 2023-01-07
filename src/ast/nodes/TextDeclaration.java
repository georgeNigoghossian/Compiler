package ast.nodes;

public class TextDeclaration extends WidgetAbstractChild {
	String strline;
	
	public TextDeclaration(String strline,int line ,String parent) {
		super(line,parent);
		this.strline=strline;
	}
	
	@Override
	public String toString() {
		return "Text Declaration line: "+getLine()+" parent "+getParent()
				+strline;
	}
}
