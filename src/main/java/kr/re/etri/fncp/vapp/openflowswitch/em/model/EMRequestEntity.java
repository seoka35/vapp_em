package kr.re.etri.fncp.vapp.openflowswitch.em.model;
import java.util.ArrayList;
import java.util.List;

import open.commons.json.annotation.JSONField;
import open.commons.json.model.DefaultJSONModel;
import open.commons.json.model.JSONMapper;

/**
  * <a href="http://tools.ietf.org/html/rfc7159">JSON</a> source: <br>
  * <pre>
  * 
  * [CASE - 0]
  * 
  * {
  *   "id": "set_sdn_ctrl",
  *   "sync": true,
  *   "parameters": [
  *     {
  *       "index": 0,
  *       "varargs": [
  *         {
  *           "name": "FAIL-MODE",
  *           "value": "secure"
  *         }
  *       ]
  *     },
  *     {
  *       "index": 1,
  *       "varargs": [
  *         {
  *           "name": "IP",
  *           "value": "192.168.0.2"
  *         },
  *         {
  *           "name": "PORT",
  *           "value": "6633"
  *         }
  *       ]
  *     }
  *   ]
  * }
  * </pre>
 */
public  class EMRequestEntity extends DefaultJSONModel{

	private static final long serialVersionUID = 1L;

    static {
    	JSONMapper.register(FunctionID.class, FunctionID.getMarshaller());
    }
    
	@JSONField(name="id")
	private FunctionID id;

	@JSONField(name="parameters")
	private List<Parameters> parameters = new ArrayList<>();

	@JSONField(name="sync")
	private Boolean sync = new Boolean(false);

	public EMRequestEntity (){}

	/**
	 *
	 * @param id id to set.
	 *
	 * @since 2015. 12. 21.
	 */
	public void setId (FunctionID id) {
		this.id = id;
	}

	/**
	 *
	 * @param parameters parameters to set.
	 *
	 * @since 2015. 12. 21.
	 */
	public void setParameters (List<Parameters> parameters) {
		this.parameters = parameters;
	}

	/**
	 *
	 * @param sync sync to set.
	 *
	 * @since 2015. 12. 21.
	 */
	public void setSync (Boolean sync) {
		this.sync = sync;
	}

	/**
	 *
	 * @return id
	 *
	 * @since 2015. 12. 21.
	 */
	public FunctionID getId () {
		return this.id;
	}

	/**
	 *
	 * @return parameters
	 *
	 * @since 2015. 12. 21.
	 */
	public List<Parameters> getParameters () {
		return this.parameters;
	}

	/**
	 *
	 * @return sync
	 *
	 * @since 2015. 12. 21.
	 */
	public Boolean getSync () {
		return this.sync;
	}


}