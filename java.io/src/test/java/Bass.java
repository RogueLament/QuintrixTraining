import java.util.List;

public class Bass {
	private String make;
	private List<String> models;
	
	public Bass(String make, List<String> models) {
		setMake(make);
		setModels(models);
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModels(List<String> models) {
		this.models = models;
	}

	public String getMake() {
		return make;
	}
	
	public List<String> getModels() {
		return models;
	}

	@Override
	public boolean equals(Object b2) {
		if ((this.make.equals(((Bass)b2).make)) && (this.models.equals(((Bass)b2).models))) {
			return true;
		}
		else {
			return false;
		}
	}
}
