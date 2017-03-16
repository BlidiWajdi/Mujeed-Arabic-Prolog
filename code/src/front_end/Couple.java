package front_end;

public class Couple {
    private String category;
    private String value;

    public Couple(String category, String value)
    {
        this.category = category;
        this.value = value;
    }

	public String getCategory() {
		return category;
	}

	public String getValue() {
		return value;
	}
	
	public String toString() {
		return "["+category+" : "+value+"]";
	}

}
