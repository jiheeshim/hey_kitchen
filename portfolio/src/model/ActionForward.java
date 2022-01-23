package model;

// controller에서 경로와 이동 방법 설정에 사용할 객체 타입
public class ActionForward {
	private boolean isRedirect = false;
	private String path = null;
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public String getPath() {
		return path;
	}

}
