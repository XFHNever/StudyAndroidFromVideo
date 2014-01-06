package com.example.studyfromvideo.location;

import java.util.List;

public class TestResult {
	private String status;
    private List<Result> results;
	public String getStatusString() {
		return status;
	}
	public void setStatusString(String statusString) {
		this.status = statusString;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public TestResult(String statusString, List<Result> results) {
		super();
		this.status = statusString;
		this.results = results;
	}
	@Override
	public String toString() {
		return "TestResult [status=" + status + ", results=" + results
				+ "]";
	}
}
