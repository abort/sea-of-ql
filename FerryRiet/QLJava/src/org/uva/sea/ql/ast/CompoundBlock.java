package org.uva.sea.ql.ast;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class CompoundBlock implements ASTNode  {
	private List<Statement> statementList = new ArrayList<Statement>();

	public CompoundBlock() {
	}

	public void addStatement(Statement st) {
		statementList.add(st);
	}

	public void eval() {

		Iterator<Statement> it = statementList.iterator();

		System.out.print("{");
		while (it.hasNext()) {
			Statement value = (Statement) it.next();
			value.eval();
		}
		System.out.println("}");
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
}
