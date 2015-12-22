/*
 *
 * This file is generated under this project, "fncp-gvm-agent".
 *
 * Date  : Apr 7, 2015 12:16:51 PM
 *
 * Author: Park_Jun_Hong_(fafanmama_at_naver_com)
 * 
 */

package kr.re.etri.fncp.vapp.openflowswitch.em.jersey.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.message.internal.AbstractMessageReaderWriterProvider;

import open.commons.utils.IOUtils;

import code.org.codehaus.jettison.json.JSONArray;

@Produces({ "application/json", "*/*" })
@Consumes({ "application/json", "*/*" })
@Singleton
public class JettisonJsonArrayEntityProvider<T extends JSONArray> extends AbstractMessageReaderWriterProvider<T> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return JSONArray.class.isAssignableFrom(type);
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return JSONArray.class.isAssignableFrom(type);
	}

	@Override
	public T readFrom(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		byte[] entity = IOUtils.readFully(entityStream);

		JSONArray obj = null;
		try {
			if (entity == null || entity.length < 1) {
				return null;
			}

			Constructor<JSONArray> cons = (Constructor<JSONArray>) type.getConstructor(String.class);
			obj = cons.newInstance(new String(entity, "UTF-8"));

		} catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage(), e);
		}

		return (T) obj;
	}

	@Override
	public void writeTo(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		try {
			if (t == null) {
				return;
			}

			byte[] entity = t.toString().getBytes("UTF-8");
			entityStream.write(entity);

		} catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage(), e);
		}
	}
}
