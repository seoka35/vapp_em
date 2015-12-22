/*
 * This file is generated under this project, "vapp.openflowswitch.em". 
 *
 * @author Kim_Yeong_Seok_(yskim_at_ymtech_co_kr)
 * @copyright: 
 * @package: 
 * @license: 
 * @url: 
 * @require: 
 * @since: 2015. 12. 22. 오전 11:32:19
*/



package kr.re.etri.fncp.vapp.openflowswitch.em.model;

import java.util.ArrayList;

import open.commons.io.IMarshaller;
import open.commons.json.IEnumMarshaller;
import open.commons.json.model.JSONMapper;
import open.commons.utils.StringUtils;


public enum FunctionID {

	ADD_BR("add_br"), DEL_BR("del_br"), ADD_PORT("add_port"), DEL_PORT("del_port"), SET_SDN_CTRL("set_sdn_ctrl"), DEL_SDN_CTRL("del_sdn_ctrl");
	
    private String functionId;

    static {
    	JSONMapper.register(FunctionID.class, FunctionID.getMarshaller());
    }
    
    private FunctionID(String functionId) {
        this.functionId = functionId;
    }
    
    public static FunctionID getFunctionId(String str) {

        for (FunctionID f : FunctionID.values()) {
            if (f.functionId.equalsIgnoreCase(str)) {
                return f;
            }
        }

        return null;
    }
    
    public static IMarshaller<FunctionID> getMarshaller() {
        return new IEnumMarshaller<FunctionID>() {

            @Override
            public Object marshall(FunctionID fieldValue) {
                return fieldValue != null ? fieldValue.functionId : null;
            }

            @Override
            public FunctionID unmarshall(Object value) {
                String functionId = value.toString().toLowerCase();

                switch (functionId) {
                    case "add_br":
                        return FunctionID.ADD_BR;
                    case "del_br":
                    	return FunctionID.DEL_BR;
                    case "add_port":
                    	return FunctionID.ADD_PORT;
                    case "del_port":
                    	return FunctionID.DEL_PORT;
                    case "set_sdn_ctrl":
                    	return FunctionID.SET_SDN_CTRL;
                    case "del_sdn_ctrl":
                    	return FunctionID.DEL_SDN_CTRL;
                }

                ArrayList<String> functionIds = new ArrayList<>();
                for (FunctionID fnc : FunctionID.values()) {
                    functionIds.add(fnc.functionId);
                }

                throw new IllegalArgumentException("Function ID is one of " + StringUtils.concatenate(", ", functionIds) + "... but '" + functionId + "' is wrong.");
            }
        };
    }
    
}
