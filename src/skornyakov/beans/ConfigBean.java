package skornyakov.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ConfigBean implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String websiteName = "Website name";

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }
}
