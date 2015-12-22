/*
 * This file is generated under this project, "vapp.openflowswitch.em". 
 *
 * @author Kim_Yeong_Seok_(yskim_at_ymtech_co_kr)
 * @copyright: 
 * @package: 
 * @license: 
 * @url: 
 * @require: 
 * @since: 2015. 12. 22. 오전 10:53:41
*/



package kr.re.etri.fncp.vapp.openflowswitch.em;

import kr.re.etri.fncp.vapp.openflowswitch.em.model.EMRequestEntity;
import kr.re.etri.fncp.vapp.openflowswitch.em.model.Result;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OVSfunctionCall {

	public static final Log logger = LogFactory.getLog(OVSfunctionCall.class);

	/**
	 * OVS Bridge를 추가한다.
	 * @param entity
	 * @return
	 */
	public static Result<String> addBridge(EMRequestEntity entity) {

		if(logger.isDebugEnabled()){
			logger.debug("(addBridge)");
		}
		Result<String> result = new Result<>(); 
		return result;
		
	}
	
	/**
	 * OVS Bridge를 삭제한다.
	 * @param entity
	 * @return
	 */
	public static Result<String> delBridge(EMRequestEntity entity) {
		
		if(logger.isDebugEnabled()){
			logger.debug("(delBridge)");
		}
		
		Result<String> result = new Result<>(); 
		return result;
		
	}
	
	/**
	 * OVS Bridge에 Port를 추가한다.
	 * @param entity
	 * @return
	 */
	public static Result<String> addPort(EMRequestEntity entity) {
		
		if(logger.isDebugEnabled()){
			logger.debug("(addPort)");
		}
		
		Result<String> result = new Result<>(); 
		return result;
		
	}
	
	/**
	 * OVS Bridge에 Port를 삭제한다.
	 * @param entity
	 * @return
	 */
	public static Result<String> delPort(EMRequestEntity entity) {
		
		if(logger.isDebugEnabled()){
			logger.debug("(delPort)");
		}
		
		Result<String> result = new Result<>(); 
		return result;
		
	}
	
	/**
	 * OVS Bridge에 SDN Controller를 설정하고, fail-mode를 설정한다.
	 * @param entity
	 * @return
	 */
	public static Result<String> setSDNController(EMRequestEntity entity) {
		
		if(logger.isDebugEnabled()){
			logger.debug("(setSDNController)");
		}
		
		Result<String> result = new Result<>(); 
		return result;
		
	}
	
	/**
	 * OVS Bridge에 SDN Controller 설정을 해제하고, fail-mode 설정도 해제한다.
	 * @param entity
	 * @return
	 */
	public static Result<String> delSDNController(EMRequestEntity entity) {
		
		if(logger.isDebugEnabled()){
			logger.debug("(delSDNController)");
		}
		
		Result<String> result = new Result<>(); 
		return result;
		
	}
	
}
