package state;

public class StateOff extends State {

	@Override
	public State stateOn() {
		// Retorna una nueva instancia de State on, ya que lo que se desea es cambiar de estado:
		return new StateOff();
				
	}

	@Override
	public State stateOff() {
		// Retorna a sí mismo, se pide que se ponga no disponible, pero ya lo está; no creo nuevo:
		return this;
	}

	@Override
	public boolean state() {
		return false;
	}

}
