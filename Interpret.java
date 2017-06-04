abstract class Expr { }

class Constant extends Expr {
	int val; 
	public Constant(int arg) {
		val = arg; 
	}
	public int eval() {
		return val; 
	}
}

class Plus extends Expr {
	private Expr left, right; 
	public Plus(Expr arg1, Expr arg2) {
		left = arg1;
		right = arg2; 	
	}
	public Expr getLeft() { 
		return left;
	} 
	public Expr getRight() {
		return right;
	} 
}

class Interpret {
	public static int interpret(Expr node) {
  		if(node instanceof Constant) {
			return ((Constant)node).eval(); 
		}
		else if(node instanceof Plus) { 
			Plus plus = (Plus) node; 
			return interpret(plus.getLeft()) + interpret(plus.getRight());
		} 
		else {
			throw new RuntimeException("Internal error: Not Implemented Yet (NIY)"); 
		} 
	} 

	public static void main(String ...args) {
		// ((10 + 20) + 30)  
		Expr expr = new Plus(
				new Plus(
					new Constant(10), 
					new Constant(20)), 
				new Constant(30)); 	
		System.out.println(interpret(expr)); 
	}
}
