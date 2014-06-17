package skornyakov.beans.spring;

public class BeanWithInitMethod {
    private String message;

    public void init() {
        message = "Message from init";
        System.out.println("Bean with init method init()");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
