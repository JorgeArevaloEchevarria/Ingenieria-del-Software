package enumerados;

public enum Peligrosidad {
	BAJA("Baja"), MEDIA("Media"), ALTA("Alta"), EXTREMA("Extrema");
	
	private String id;

	Peligrosidad(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}
}
