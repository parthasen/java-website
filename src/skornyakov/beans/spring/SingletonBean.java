package skornyakov.beans.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Alexander on 16.06.2014.
 */
public class SingletonBean implements InitializingBean, DisposableBean {
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

    @Override
    public void afterPropertiesSet() throws Exception {
        //initialization method
    }

    @Override
    public void destroy() throws Exception {
        //destoy method
    }
}
