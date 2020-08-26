package edu.multi.voting.participate;

import org.springframework.stereotype.Component;

@Component
public class ParticipateResultVO {
	String result;
	String errorMsg;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "ParticipateResultVO [result=" + result + ", errorMsg=" + errorMsg + "]";
	}
}
