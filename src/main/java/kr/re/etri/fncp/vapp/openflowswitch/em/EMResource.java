package kr.re.etri.fncp.vapp.openflowswitch.em;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import kr.re.etri.fncp.vapp.openflowswitch.em.model.EMRequestEntity;
import kr.re.etri.fncp.vapp.openflowswitch.em.model.HttpResponseEntity;
import kr.re.etri.fncp.vapp.openflowswitch.em.model.ResponseStatus;
import kr.re.etri.fncp.vapp.openflowswitch.em.model.Result;
import open.commons.json.model.exception.JSONUnmarshalledException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import code.org.codehaus.jettison.json.JSONException;

@Path("listen")
public class EMResource {

	private static final Log logger = LogFactory.getLog(EMResource.class);

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response listenEMRequest(String entity) {

		if (logger.isDebugEnabled()) {
			logger.debug("(listenEMRequest)");
		}

		try {

			EMRequestEntity reqEntity = new EMRequestEntity();
			reqEntity.mature(entity);
			if ("".equals(reqEntity.getId()) || reqEntity.getId() == null) {
				// ERROR: Function ID가 없음.
				if (logger.isErrorEnabled()) {
					logger.error("(listenEMRequest) OpenFlow Function ID is empty.");
				}
				return Response.status(Status.BAD_REQUEST).header("content-type", MediaType.APPLICATION_JSON)
						.entity(new HttpResponseEntity<Object>(ResponseStatus.error, "OpenFlow Function ID is empty.")).build();
			}

			Result<String> result = null;
			switch (reqEntity.getId()) {
			case ADD_BR:
				result = OVSfunctionCall.addBridge(reqEntity);
				break;
			case DEL_BR:
				result = OVSfunctionCall.delBridge(reqEntity);
				break;
			case ADD_PORT:
				result = OVSfunctionCall.addPort(reqEntity);
				break;
			case DEL_PORT:
				result = OVSfunctionCall.delPort(reqEntity);
				break;
			case SET_SDN_CTRL:
				result = OVSfunctionCall.setSDNController(reqEntity);
				break;
			case DEL_SDN_CTRL:
				result = OVSfunctionCall.delSDNController(reqEntity);
				break;
			}

			if (result.getResult()) {
				// SUCCESS: 정상동작 완료
				return Response.status(Status.OK).header("content-type", MediaType.APPLICATION_JSON)
						.entity(new HttpResponseEntity<Object>(ResponseStatus.completed)).build();

			} else {
				// ERROR: 기능 처리중 오류발생
				if (logger.isErrorEnabled()) {
					logger.error("(listenEMRequest) OVS Function Return is False. result: " + result);
				}
				return Response.status(result.getStatus()).header("content-type", MediaType.APPLICATION_JSON)
						.entity(new HttpResponseEntity<Object>(ResponseStatus.error, result.getMessage())).build();

			}

		} catch (JSONException e) {
			// EXCEPTION: JSON Entity 파싱 중 예외 발생 
			logger.error("(listenEMRequest) Request Entity is unavailable. entity: " + entity, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("content-type", MediaType.APPLICATION_JSON)
					.entity(new HttpResponseEntity<Object>(ResponseStatus.error, "Request Entity is unavailable.")).build();
			
		} catch (JSONUnmarshalledException e) {
			// EXCEPTION: Function ID Unmatch Exception 
			logger.error("(listenEMRequest) Function ID is invaild.", e);
			return Response.status(Status.BAD_REQUEST).header("content-type", MediaType.APPLICATION_JSON)
					.entity(new HttpResponseEntity<Object>(ResponseStatus.error, e.getCause().getLocalizedMessage())).build();
			
		} catch (Exception e) {
			// EXCEPTION: 기타 예외 처리 
			logger.error("(listenEMRequest)", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("content-type", MediaType.APPLICATION_JSON)
					.entity(new HttpResponseEntity<Object>(ResponseStatus.error)).build();
			
		}
	}

}
