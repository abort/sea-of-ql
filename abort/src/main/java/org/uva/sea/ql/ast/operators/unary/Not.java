package org.uva.sea.ql.ast.operators.unary;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.traversal.SymbolTable;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.datatypes.BoolType;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Represents the not operation in the QL language.
 * 
 * @author J. Dijkstra
 */
public class Not extends UnaryOperator {
	private static final DataType type = new BoolType();

	/**
	 * Constructor.
	 * 
	 * @param expression
	 *            expression or operation the not operation affects
	 */
	public Not(final Expression expression) {
		super(expression);
	}

	@Override
	public DataType typeOf(final SymbolTable symbolTable) {
		return type;
	}

	@Override
	public <T> T accept(final IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}