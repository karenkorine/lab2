/**
 * Polynomial.java
 * 
 * @author PARTNER_1_NAME
 * @author PARNTER_2_NAME CIS 22C, Lab 2
 */
public class Polynomial {
	private LinkedList<Term> poly;

	/**
	 * Default Polynomial constructor whose purpose is to initialize poly to an
	 * empty LinkedList
	 */
	public Polynomial() {
		poly = new LinkedList<Term>();
	}

	/**
	 * Polynomial copy constructor whose purpose is to initialize poly and then copy
	 * the data from p into this Polynomial
	 * 
	 * @param p a Polynomial to copy Hint: Make sure that you create a deep copy not
	 *          a shallow copy Also: don't forget to check the edge case
	 */
	public Polynomial(Polynomial p) {
		poly = new LinkedList<>(); 
		 this.poly = p.poly;
	}

	/**
	 * Adds a new Term to the end of the Polynomial
	 * 
	 * @param exponent    the exponent of the Term
	 * @param coefficient the coefficient of the Term
	 */
	public void addTerm(int exponent, double coefficient) {
		Term N = new Term(exponent,coefficient); 
		poly.addLast(N); 
	}

	/**
	 * Assigns a new coefficient to an existing Term
	 * 
	 * @param exponent       the exponent of the Term (i.e. its position within the
	 *                       Polynomial)
	 * @param newCoefficient the coefficient to assign
	 * @precondition 0 <= exponent <= poly.first.exponent
	 * @throws IllegalArgumentException when exponent larger than the exponent of
	 *                                  the leading order Term or less than 0
	 */
	public void updateTerm(int exponent, double newCoefficient) throws IllegalArgumentException {
		if(exponent < 0 && exponent > poly.getFirst().getExponent()) {
			throw new IllegalArgumentException("updateTerm(): The exponent is larger than the exponent of the leading order Term or less than 0" );
		}
			poly.positionIterator();
		while (poly.getIterator() != null ) {
			if(exponent == poly.getIterator().getExponent() ) {
				poly.getIterator().setCoefficient(newCoefficient);
			}
			poly.advanceIterator();
		}
	}

	/**
	 * A helper method for evaluate. Evaluates a single term in the Polynomial by
	 * plugging in the value For example: If the term is 3.0x2 and the value is 5.0
	 * This function will return 75.0 since 3.0*5.0*5.0=75.0
	 * 
	 * @param t     a Term to evaluate
	 * @param value the value to plug in for x
	 * @return the result of evaluating the Term
	 */
	private double evaluateTerm(final Term t, double value) {
		double result; 
		result = t.getCoefficient() * Math.pow(value, t.getExponent());
		return result;
	}

	/**
	 * Evaluates the Polynomial by plugging in the given value at all terms
	 * 
	 * @param value the value to plug into the equation
	 * @return the result of evaluating the polynomial by plugging in value for x
	 */

	public double evaluate(double value) {
		double result = 0.0;
		while(this.poly != null) {
			result = evaluateTerm(poly.getIterator(), value);
			poly.advanceIterator();
		}
		return result;
	}

	/**
	 * Adds two Terms - helper method for add
	 * 
	 * @param t1 the first Term to add
	 * @param t2 the second Term to add
	 * @return the resulting Term from adding t1 and t2
	 * @precondition t1 and t2 cannot be null
	 * @precondition t1.exponent == t2.exponent
	 * @throws NullPointerException     when either t1 or t2 is null
	 * @throws IllegalArgumentException when the exponents for t1 and t2 are not the
	 *                                  same
	 */
	private Term addTerms(Term t1, Term t2) throws NullPointerException, IllegalArgumentException {
		return null;
	}

	/**
	 * Adds p to this Polynomial
	 * 
	 * @param p another Polynomial to add to this
	 * @return a new Polynomial resulting from adding p to this Handles two
	 *         exceptions from calling addTerms by using a try-catch
	 */
	public Polynomial add(final Polynomial p) {
		return null;
	}

	/**
	 * Subtracts p from this Polynomial
	 * 
	 * @param p another Polynomial to subtract from this
	 * @return a new Polynomial resulting from subtracting p from this
	 * @postcondition p remains unchanged
	 */
	public Polynomial subtract(final Polynomial p) {
		return null;
	}

	/**
	 * Converts this Polynomial to a String in the form <coefficient1>x<exponent1> +
	 * <coefficient2>x<exponenent2> + ... For example: 2.5x4 + 3x3 + 8.1x1 + 7.5
	 * 
	 * @return the Polynomial represented as a String
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		this.poly.positionIterator();
		while (this.poly != null) {
			result.append(this.poly.getIterator().toString());
			this.poly.advanceIterator();
			if (this != null) {
				result.append(" + ");
			}
		}
		return result.toString() + "\n";
	}

}