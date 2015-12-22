/*
 * All rights reserved by MIT license.
 */
package kr.re.etri.fncp.vapp.openflowswitch.em.model;

import javax.ws.rs.core.Response.Status;

/**
 * true/false 결과와 함께 관련 데이타를 같이 전달해주는 클래스 <BR>
 * 
 * @author Park Jun-Hong (fafanmama_at_naver_dot_com)
 * 
 * @since 2014. 6. 27. - add {@link #message}: 성공/실패에 대한 정보
 * @since 2012. 02. 15.
 * 
 */
public class Result<T> {

    /** 결과와 관련된 데이타 */
    private T data;

    /** true/false 값 */
    private boolean result;

    /** 성공/실패에 대한 정보 */
    private String message;
    
    /** 실패시 실패에 대한 status정보 */
    private Status status;

    /**
     * 결과값과 데이타 값으로 기본값을 사용하는 생성자.<br>
     * <ul>
     * <li>{@link #data}: <code>null</code>
     * <li>{@link #result}: <code>false</code>
     * </ul>
     * 
     * @see Result#Result(Object, boolean)
     */
    public Result() {
        this(null, false, Status.INTERNAL_SERVER_ERROR);
    }

    /**
     * 결과 데이타를 가지고 객체를 생성한다.<br>
     * {@link #result}에 대한 값은 <code>false</code>로 설정된다.
     * 
     * @param data
     * 
     * @since 2012. 02. 15.
     * @author Park Jun-Hong (fafanmama_at_naver_dot_com)
     * 
     * @see #Result(Object, boolean)
     */
    public Result(T data) {
        this(data, false, Status.INTERNAL_SERVER_ERROR);
    }

    /**
     * 결과 데이타와 <code>true</code>/<code>false</code>를 가지고 객체를 생성한다.<br>
     * 
     * @param data
     * @param result
     * 
     * @since 2012. 02. 15.
     * @author Park Jun-Hong (fafanmama_at_naver_dot_com)
     */
    public Result(T data, boolean result, Status status) {
        // if (data == null) {
        // throw new IllegalArgumentException("'data' must not be null!!!");
        // }

        this.data = data;
        this.result = result;
        this.status = status;
    }
    
    /**
     * 결과를 <code>false</code>로 설정한 후 객체를 반환한다.
     * 
     * @return
     * @since 2012. 05. 30.
     * @author Park Jun Hong (jhpark@ymtech.kr)
     */
    public Result<T> andFalse() {
        this.result = false;

        return this;
    }

    /**
     * 결과를 <code>true</code>로 설정한 후 객체를 반환한다.
     * 
     * @return
     * @since 2012. 05. 30.
     * @author Park Jun Hong (jhpark@ymtech.kr)
     */
    public Result<T> andTrue() {
        this.result = true;
        this.status = Status.OK;

        return this;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Result other = (Result) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (result != other.result)
            return false;
        return true;
    }

    /**
     * 결과 데이타를 반환한다.
     * 
     * @return
     * 
     * @since 2012. 02. 15.
     * @author Park Jun-Hong (fafanmama_at_naver_dot_com)
     */
    public T getData() {
        return data;
    }

    /**
     * 
     * @return the message
     * 
     * @since 2014. 6. 27.
     */
    public String getMessage() {
        return message;
    }

    /**
     * 결과를 반환한다.
     * 
     * @return
     * 
     * @since 2012. 02. 15.
     * @author Park Jun-Hong (fafanmama_at_naver_dot_com)
     */
    public boolean getResult() {
        return result;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + (this.result ? 1231 : 1237);
        return result;
    }

    /**
     * 데이타를 설정하고, 이전 데이타를 반환한다.
     * 
     * @param data
     * @return
     */
    public T setData(T data) {
        T latest = this.data;
        this.data = data;
        return latest;
    }

    /**
     * @param message
     *            the message to set
     * 
     * @since 2014. 6. 27.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 결과값을 설정하고, 이전 결과값을 반환한다.
     * 
     * @param result
     * @return
     * 
     * @since 2012. 02. 15.
     * @author Park Jun-Hong (fafanmama_at_naver_dot_com)
     */
    public boolean setResult(boolean result) {
        boolean latestResult = this.result;
        this.result = result;

        return latestResult;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Result [data=" + data + ", result=" + result + ", message=" + message + "]";
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
