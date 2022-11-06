
public class LocationObjectMothers {

	public static LocationObjectMother Texas() {
		
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Houston)
				.build();
	}
	
	public static LocationObjectMother Houston() {
		
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Houston)
				.build();
	}
	
	public static LocationObjectMother Louisiana() {
		
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(Cities.NewOrleans)
				.build();
	}

	public static LocationObjectMother NewOrleans() {
		
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(Cities.NewOrleans)
				.build();
	}
	
	public static LocationObjectMother Oregon() {
		
		return new LocationBuilder()
				.withState(States.Oregon)
				.withCity(Cities.Salem)
				.build();
	}
	
	public static LocationObjectMother Salem() {
		
		return new LocationBuilder()
				.withState(States.Oregon)
				.withCity(Cities.Salem)
				.build();
	}
	
	public static LocationObjectMother NewJersey() {
		
		return new LocationBuilder()
				.withState(States.NewJersey)
				.withCity(Cities.Trenton)
				.build();
	}
	
	public static LocationObjectMother Trenton() {
		
		return new LocationBuilder()
				.withState(States.NewJersey)
				.withCity(Cities.Trenton)
				.build();
	}
}
