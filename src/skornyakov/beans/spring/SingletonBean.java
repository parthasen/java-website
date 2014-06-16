package skornyakov.beans.spring;

/**
 * Created by Alexander on 16.06.2014.
 */
public class SingletonBean {
    private String value;

    public SingletonBean() {
        this.value = String.valueOf(Math.random());
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
