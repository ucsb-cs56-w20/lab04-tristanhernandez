package edu.ucsb.cs56.ratcalc.model;

/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

    */

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */

    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }
    
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	if (denom <0){
		denom = denom * (-1);
		num = num * (-1);
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    public static int lcm(int a, int b)	 
    {
        return ( Math.abs( (a*b) ) / gcd(a,b) );
    }

    public Rational plus(Rational r)
    {
        int denom_lcm = lcm(this.denom, r.denom);
        int multfactor_this = denom_lcm/this.denom;
        int multfactor_r = denom_lcm/r.denom;

        this.denom = denom_lcm;
        this.num = multfactor_this*this.num + multfactor_r*r.num;

        int new_gcd = gcd( this.num, this.denom );
        if ( new_gcd != 1 ){
            this.num = this.num/new_gcd;
            this.denom = this.denom/new_gcd;
        }
	if(this.denom < 0){
		this.num = this.num * -1;
		this.denom = this.denom*-1;
	}
        return this;
    }

    public static Rational sum(Rational a, Rational b)
    {
        int denom_lcm = lcm(a.denom, b.denom);
        int multfactor_a = denom_lcm/a.denom;
        int multfactor_b = denom_lcm/b.denom;

        Rational c = new Rational();

        c.denom = denom_lcm;
        c.num = multfactor_a*a.num + multfactor_b*b.num;

        int new_gcd = gcd( c.num, c.denom );
        if ( new_gcd != 1 ){
            c.num = c.num/new_gcd;
            c.denom = c.denom/new_gcd;
        }

	  if(c.denom < 0){
                c.num = c.num * -1;
                c.denom = c.denom*-1;
        }

        return c;
    }

    public Rational minus(Rational r)
    {
        /*int denom_lcm = lcm(this.denom, r.denom);
        int multfactor_this = denom_lcm/this.denom;
        int multfactor_r = denom_lcm/r.denom;

        this.denom = denom_lcm;
        this.num = multfactor_this*this.num - multfactor_r*r.num;

        int new_gcd = gcd( this.num, this.denom );
        if ( new_gcd != 1 ){
            this.num = this.num/new_gcd;
            this.denom = this.denom/new_gcd;
        }
	*/
	Rational p = new Rational ();
	r.num = r.num *(-1);
        p = (sum(this,(r)));
	  if(p.denom < 0){
                p.num = p.num * -1;
                p.denom = p.denom*-1;
        }
	return p;
    }

    public static Rational difference(Rational a, Rational b)
    {
        /*int denom_lcm = lcm(a.denom, b.denom);
        int multfactor_a = denom_lcm/a.denom;
        int multfactor_b = denom_lcm/b.denom;

        Rational c = new Rational();

        c.denom = denom_lcm;
        c.num = multfactor_a*a.num - multfactor_b*b.num;

        int new_gcd = gcd( c.num, c.denom );
        if ( new_gcd != 1 ){
            c.num = c.num/new_gcd;
            c.denom = c.denom/new_gcd;
        }

        return c;
	*/
	    b.num =  b.num * (-1);
	     return (sum(a,(b)));

    }

    public Rational reciprocalOf()
    {
        if ( this.num == 0)
		throw new ArithmeticException();
	Rational p = new Rational();
	p.num = this.denom;
	p.denom= this.num;
	  if(p.denom < 0){
                p.num = p.num * -1;
                p.denom = p.denom*-1;
        }

        return p;
    }

    public Rational dividedBy(Rational r)
    {
        if ( r.num == 0)
            throw new ArithmeticException();
        return product( this, r.reciprocalOf() );
    }

    public static Rational quotient(Rational a, Rational b)
    {
        if( b.num == 0)
            throw new ArithmeticException();
        return product( a, b.reciprocalOf() );
    }
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
