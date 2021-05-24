package entity;

public class Script {
	private String testID;
	private String module;
	private String testTitle;
	private String testDesc;
	private String batchFileName;
	private Boolean run;
	private String automatedBy;
	private String status;

	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getTestDesc() {
		return testDesc;
	}

	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}

	public String getBatchFileName() {
		return batchFileName;
	}

	public void setBatchFileName(String batchFileName) {
		this.batchFileName = batchFileName;
	}

	public Boolean getRun() {
		return run;
	}

	public void setRun(Boolean run) {
		this.run = run;
	}

	public String getAutomatedBy() {
		return automatedBy;
	}

	public void setAutomatedBy(String automatedBy) {
		this.automatedBy = automatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Script [testID=" + testID + ", module=" + module + ", testTitle=" + testTitle + ", testDesc=" + testDesc
				+ ", batchFileName=" + batchFileName + ", run=" + run + ", automatedBy=" + automatedBy + ", status="
				+ status + "]";
	}
	
}
