package wasdev.sample.servlet;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class harassFilter {
	double negThresh;
	AlchemyLanguage service;

	public harassFilter(double negThresh) {
		 service = new AlchemyLanguage();
		this.negThresh = negThresh;
	}
	
	public String checkHarassment(String text) {
		service.setApiKey("<api_key>");

		Map<String,Object> params = new HashMap<String, Object>();
		params.put(AlchemyLanguage.TEXT, text);
		DocumentSentiment sentiment = service.getSentiment(params).execute();
		System.out.println(sentiment);
		
		return sentiment.getText();
	}

}

