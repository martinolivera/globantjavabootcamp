package state;

public class StateOn extends State {
	
	@Override
	public State stateOn() {
		//Se retorna la instancia actual, si ya estaba en on, no la modifico:
		return this;
	}

	@Override
	public State stateOff() {
		// Retorna una instancia de estado en off:
		return new StateOff();
	}

	@Override
	public boolean state() {
		return true;
	}
	
}
