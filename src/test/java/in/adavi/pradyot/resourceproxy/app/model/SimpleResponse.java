package in.adavi.pradyot.resourceproxy.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Pradyot H Adavi
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleResponse {
	
	private String responseMsg;
}
