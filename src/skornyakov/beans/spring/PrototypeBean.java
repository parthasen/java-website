package skornyakov.beans.spring;

public class PrototypeBean {
    
    
    public PrototypeBean() {
	super();
	this.value = String.valueOf(Math.random());
    }

    private String value;

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

}
