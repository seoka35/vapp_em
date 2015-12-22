package kr.re.etri.fncp.vapp.openflowswitch.em.model;
import open.commons.json.annotation.JSONField;
import open.commons.json.model.DefaultJSONModel;

/**
  * <a href="http://tools.ietf.org/html/rfc7159">JSON</a> source: <br>
  * <pre>
  * 
  * [CASE - 0]
  * 
  * {
  *   "name": "FAIL-MODE",
  *   "value": "secure"
  * }
  * </pre>
 */
public  class Varargs extends DefaultJSONModel{

	private static final long serialVersionUID = 1L;

	@JSONField(name="name")
	private String name;

	@JSONField(name="value")
	private String value;

	public Varargs (){}

	/**
	 *
	 * @param name name to set.
	 *
	 * @since 2015. 12. 21.
	 */
	public void setName (String name) {
		this.name = name;
	}

	/**
	 *
	 * @param value value to set.
	 *
	 * @since 2015. 12. 21.
	 */
	public void setValue (String value) {
		this.value = value;
	}

	/**
	 *
	 * @return name
	 *
	 * @since 2015. 12. 21.
	 */
	public String getName () {
		return this.name;
	}

	/**
	 *
	 * @return value
	 *
	 * @since 2015. 12. 21.
	 */
	public String getValue () {
		return this.value;
	}


}