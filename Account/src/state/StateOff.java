package state;

public class StateOff implements State {

	public State stateAvailable() {
		// Retorna una nueva instancia de State on, ya que lo que se desea es cambiar de estado:
		return new StateOff();
				
	}

	public State stateNonAvailable() {
		// Retorna a sí mismo, se pide que se ponga no disponible, pero ya lo está; no creo nuevo:
		return this;
	}

	public boolean state() {
		return false;
	}

}
