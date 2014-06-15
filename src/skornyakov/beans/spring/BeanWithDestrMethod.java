package skornyakov.beans.spring;

public class BeanWithDestrMethod {
    
    public void destroy() {
	System.out.println("Bean With Destroy method has been destroyed");
    }
}
