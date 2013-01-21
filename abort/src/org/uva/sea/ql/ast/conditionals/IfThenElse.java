package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Represents an if then else statement in the QL language.
 * @author J. Dijkstra
 */
public class IfThenElse extends IfStatement {
	/**
	 * Form elements to display when the conditions fail.
	 */
	private final List<Element> elseElements;
	
	/**
	 * Constructor.
	 * @param conditions conditions
	 * @param successElements form elements to display on a successful condition
	 * @param elseElements form elements to display on an unsuccessful condition
	 */
	public IfThenElse(final Node conditions, final List<Element> successElements, final List<Element> elseElements) {
		super(conditions, successElements);		
		this.elseElements = elseElements;
	}

	@Override
	public void accept(final IVisitor visitor) {
		for (final Element nodeToVisit : successElements) {
			nodeToVisit.accept(visitor);
		}
		
		for (final Element nodeToVisit : elseElements) {
			nodeToVisit.accept(visitor);
		}
		
		super.accept(visitor);

		visitor.visit(this);		
	}
	
	/**
	 * Retrieve the form elements to display on an unsuccessful condition.
	 * @return form elements
	 */
	public List<Element> getElseElements() {
		return elseElements;
	}
}
