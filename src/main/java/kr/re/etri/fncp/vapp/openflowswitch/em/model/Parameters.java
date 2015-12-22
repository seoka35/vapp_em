package kr.re.etri.fncp.vapp.openflowswitch.em.model;
import java.util.ArrayList;
import java.util.List;
import open.commons.json.annotation.JSONField;
import open.commons.json.model.DefaultJSONModel;

/**
  * <a href="http://tools.ietf.org/html/rfc7159">JSON</a> source: <br>
  * <pre>
  * 
  * [CASE - 0]
  * 
  * {
  *   "index": 0,
  *   "varargs": [
  *     {
  *       "name": "FAIL-MODE",
  *       "value": "secure"
  *     }
  *   ]
  * }
  * </pre>
 */
public  class Parameters extends DefaultJSONModel{

	private static final long serialVersionUID = 1L;

	@JSONField(name="index")
	private Integer index = new Integer(0);

	@JSONField(name="varargs")
	private List<Varargs> varargs = new ArrayList<>();

	public Parameters (){}

	/**
	 *
	 * @param index index to set.
	 *
	 * @since 2015. 12. 21.
	 */
	public void setIndex (Integer index) {
		this.index = index;
	}

	/**
	 *
	 * @param varargs varargs to set.
	 *
	 * @since 2015. 12. 21.
	 */
	public void setVarargs (List<Varargs> varargs) {
		this.varargs = varargs;
	}

	/**
	 *
	 * @return index
	 *
	 * @since 2015. 12. 21.
	 */
	public Integer getIndex () {
		return this.index;
	}

	/**
	 *
	 * @return varargs
	 *
	 * @since 2015. 12. 21.
	 */
	public List<Varargs> getVarargs () {
		return this.varargs;
	}


}