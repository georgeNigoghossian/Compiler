package ast.nodes;

import gen.dart_parse;

import java.util.List;

public class FunctionBody extends Node{
    List<Statement> statementList;
    //ReturnStatement returnStatement;

    public FunctionBody(dart_parse.FunctionBodyContext ctx, List<Statement> statementList) {
        super(ctx);
        this.statementList = statementList;
       // this.returnStatement = returnStatement;
    }

    @Override
    public String toString() {
        return getLineString()
                +"FunctionBody{" +
                "statementList=" + statementList +
                ", col=" + col +
                ", type='" + type + '\'' +
                ", childCount=" + childCount +
                ", parent='" + parent + '\'' +
                '}';
    }
}
