package org.uva.sea.ql.ast.operators.binary;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents a less than or equal to operation in the QL language.
 * @author J. Dijkstra
 */
public class LEq extends BinaryOperator {
	/**
	 * Constructor.
	 * @param leftHandSide left hand side of the operator
	 * @param rightHandSide right hand side of the operator
	 */
	public LEq(final Node leftHandSide, final Node rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public void accept(final IVisitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
