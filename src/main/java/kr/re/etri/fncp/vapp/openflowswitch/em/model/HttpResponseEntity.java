package kr.re.etri.fncp.vapp.openflowswitch.em.model;
import open.commons.json.annotation.JSONField;
import open.commons.json.model.DefaultJSONModel;
import code.org.codehaus.jettison.json.JSONException;
public  class HttpResponseEntity<T> extends DefaultJSONModel{

	private static final long serialVersionUID = 1L;

	@JSONField(name="status")
	private String status;
	
	@JSONField(name="message")
	private String message;
	
	@JSONField(isfinal = false)
	private T data;
	
	public HttpResponseEntity (){}
	
	public HttpResponseEntity (ResponseStatus status){
		this.status = status.toString(); 
	}
	
	public HttpResponseEntity (ResponseStatus status, String message){
		this.status = status.toString();
		this.message = message;
	}
	
	public HttpResponseEntity(String json) throws JSONException {
		mature(json);
	}

	public String getStatus() {
		return status;
	}

	public HttpResponseEntity<T> setStatus(String status) {
		this.status = status;
		return this;

	}

	public String getMessage() {
		return message;
	}

	public HttpResponseEntity<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public HttpResponseEntity<T> setData(T data) {
		this.data = data;

		return this;
	}
	
	

}