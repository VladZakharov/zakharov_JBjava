package serverCalculator;

import java.util.ArrayList;

class Contaner{

	Contaner(String exp){
		this.content = exp;
	}

	String content = null;
	Double result = null;

	ArrayList<Contaner> contaners = new ArrayList<Contaner>();
	ArrayList<Operation> operations = new ArrayList<Operation>();

	boolean hasBreakets(){
		if (content == null) return false;
		for (int i = 0; i < this.content.length(); i++) {
			if (this.content.charAt(i) == '(') return true;
		}
		return false;
	}

}