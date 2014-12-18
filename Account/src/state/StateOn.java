package state;

public class StateOn implements State {
	
	public State stateAvailable() {
		//Se retorna la instancia actual, si ya estaba en on, no la modifico:
		return this;
	}

	
	public State stateNonAvailable() {
		// Retorna una instancia de estado en off:
		return new StateOff();
	}

	public boolean state() {
		return true;
	}
	
}
