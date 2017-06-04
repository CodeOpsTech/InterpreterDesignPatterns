abstract class Expr {
	public abstract int interpret(); 
}

class Constant extends Expr {
	int val; 
	public Constant(int arg) {
		val = arg; 
	}
	public int interpret() {
		return val; 
	}
}

class Plus extends Expr {
	private Expr left, right; 
	public Plus(Expr arg1, Expr arg2) {
		left = arg1;
		right = arg2; 	
	}
	public int interpret() {
		return left.interpret() + right.interpret();
	}
}

class Interpret {
	public static void main(String ...args) {
		// ((10 + 20) + 30)  
		Expr expr = new Plus(
				new Plus(
					new Constant(10), 
					new Constant(20)), 
				new Constant(30)); 	
		System.out.println(expr.interpret()); 
	}
}
