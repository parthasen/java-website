package skornyakov.beans.spring;

public class BeanWithInitMethod {
    public void init() {
	message = "Message from init";
    }

    private String message;

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }
}
