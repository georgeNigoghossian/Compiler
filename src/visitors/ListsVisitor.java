package visitors;

import ast.NodeType;
import ast.SymbolTableObject;
import ast.nodes.DartAllListsDeclaration;
import ast.nodes.DartListBoolDeclaration;
import ast.nodes.DartListIntDeclaration;
import ast.nodes.DartListStringDeclaration;
import ast.variables.BooleanValueClass;
import ast.variables.NumberClass;
import gen.dart_parseBaseVisitorChild;
import gen.dart_parse.DartAllListsDeclarationContext;
import gen.dart_parse.DartListBoolDeclarationContext;
import gen.dart_parse.DartListIntDeclarationContext;
import gen.dart_parse.DartListStringDeclarationContext;
import java.util.ArrayList;
import java.util.List;

public class ListsVisitor extends dart_parseBaseVisitorChild{

	@Override
	public DartAllListsDeclaration visitDartAllListsDeclaration(DartAllListsDeclarationContext ctx) {

		int line = ctx.start.getLine();
		String parent = ctx.getParent().getClass().getName().replace("gen.dart_parse$","").replace("Context","");
		String type = NodeType.LIST.toString();
		int childCount = ctx.getChildCount();
		if (ctx.dartListStringDeclaration() != null) {
			return new DartAllListsDeclaration(visitDartListStringDeclaration(ctx.dartListStringDeclaration()),line,parent,type,childCount);
		}else if(ctx.dartListIntDeclaration() != null) {
			return new DartAllListsDeclaration(visitDartListIntDeclaration(ctx.dartListIntDeclaration()),line,parent,type,childCount);
		}else if(ctx.dartListBoolDeclaration() != null) {
			return new DartAllListsDeclaration(visitDartListBoolDeclaration(ctx.dartListBoolDeclaration()),line,parent,type,childCount);
		}else {
			return null;
		}

	}

	@Override
	public DartListStringDeclaration visitDartListStringDeclaration(DartListStringDeclarationContext ctx) {

		int line = ctx.start.getLine();
		int column = ctx.STRING().getSymbol().getCharPositionInLine() + 1;
		String parent = ctx.getParent().getClass().getName().replace("gen.dart_parse$","").replace("Context","");
		String type = NodeType.LIST.toString();
		int childCount = ctx.getChildCount();
		String name = ctx.NAME().getText();
		if(CheckExistanceInScope(name,index)){
			semanticErrors.add("The name " + name + " already defined (" + line + "," + column + ")");
		}else{
			scopes.get(index - 1).getSymbolMap().put(name, new SymbolTableObject(NodeType.LIST.toString(), name));

		}
		List<String> dartListStringItems = new ArrayList<>();
		for(int i=7;i<ctx.getChildCount();i++){
			String strLine = ctx.getChild(i).getText();
			if((!strLine.equals("[")) && (!strLine.equals("]")) && (!strLine.equals(",")) && (!strLine.equals(";"))){
				dartListStringItems.add(strLine);
			}
		}
		DartListStringDeclaration dec = new DartListStringDeclaration(name,line,parent,type,childCount);
		dec.setItemsList(dartListStringItems);
		return dec;

	}

	@Override
	public DartListIntDeclaration visitDartListIntDeclaration(DartListIntDeclarationContext ctx) {
		int line = ctx.start.getLine();
		int column = ctx.NAME().getSymbol().getCharPositionInLine() + 1;
		String parent = ctx.getParent().getClass().getName().replace("gen.dart_parse$","").replace("Context","");
		String name = ctx.NAME().getText();
		List<NumberClass> dartListIntItems = new ArrayList<>();

		if(CheckExistanceInScope(name,index)){
			semanticErrors.add("The name " + name + " already defined (" + line + "," + column + ")");
		}else{
			scopes.get(index - 1).getSymbolMap().put(name, new SymbolTableObject(NodeType.LIST.toString(), name));
		}
		for(int i=7;i<ctx.getChildCount();i++){
			String str = ctx.getChild(i).getText();
			if(!str.equals(",") && !str.equals("]") && !str.equals(";")) {
				try {
					int numLine = ctx.start.getLine();
					String numParent = ctx.getParent().getClass().getName().replace("gen.dart_parse$","").replace("Context","");
					String type = NodeType.NUMBER.toString();
					int childCount = ctx.getChildCount();
					NumberClass number = new NumberClass(Integer.parseInt(ctx.getChild(i).getText()), line, parent, type, childCount);
					dartListIntItems.add(number);
				} catch (Exception e) {

				}
			}
		}
		String type = NodeType.LIST.toString();
		int childCount = ctx.getChildCount();
		DartListIntDeclaration dec = new DartListIntDeclaration(name,line,parent, type, childCount);
		dec.setItemsList(dartListIntItems);
		return dec;
	}

	@Override
	public DartListBoolDeclaration visitDartListBoolDeclaration(DartListBoolDeclarationContext ctx) {
		int line = ctx.start.getLine();
		int column = ctx.NAME().getSymbol().getCharPositionInLine() + 1;
		String parent = ctx.getParent().getClass().getName().replace("gen.dart_parse$","").replace("Context","");
		String name = ctx.NAME().getText();
		List<BooleanValueClass> dartListBoolItems = new ArrayList<>();

		for(int i=7;i<ctx.getChildCount();i++){
			String str = ctx.getChild(i).getText();

			if(!str.equals(",") && !str.equals("]") && !str.equals(";")) {

				try {
					int boolLine = ctx.start.getLine();
					String boolParent = ctx.getParent().getClass().getName().replace("gen.dart_parse$","").replace("Context","");
					String type = NodeType.BOOLEAN.toString();
					int childCount = ctx.getChildCount();
					BooleanValueClass b = new BooleanValueClass(Boolean.parseBoolean(ctx.getChild(i).getText()), line, parent, type, childCount);
					dartListBoolItems.add(b);
				} catch (Exception e) {

				}
			}
		}
		if(CheckExistanceInScope(name,index)){
			semanticErrors.add("The name " + name + " already defined (" + line + "," + column + ")");
		}else{
			scopes.get(index - 1).getSymbolMap().put(name, new SymbolTableObject(NodeType.LIST.toString(), name));
		}
		String type = NodeType.LIST.toString();
		int childCount = ctx.getChildCount();
		DartListBoolDeclaration dec = new DartListBoolDeclaration(name,line,parent,type,childCount);
		dec.setItemsList(dartListBoolItems);
		return dec;
	}

}
