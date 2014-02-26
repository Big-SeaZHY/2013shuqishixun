package com.seu.bigocto.mainframe;

public class MainUrl {
	
	public String URL_BASE="http://223.3.75.111";
	public String URL_O="http://10.0.2.2:8080";
	
	public String LOGIN_URL=URL_BASE+"/xueZhang/servlet/AndroidLoginSev";
	
	public String BROWSE_URL=URL_BASE+"/xueZhang/servlet/AndroidBroSev";
	public String IMAGE_URL=URL_BASE+"/xueZhang/";
	public String CONTENT_DETAIL=URL_BASE+"/xueZhang/servlet/AndroidBookDetailSev";
	public String DETAIL_IAMGE_URL=URL_BASE+"/xueZhang/";
	public String COLLECTION_URL=URL_BASE+"/xueZhang/servlet/AndroidCollectionSev";
	
//	public String CONTENT_DETAIL=URL_O+"/commodity_detail/abc";
//	public String DETAIL_IAMGE_URL=URL_O+"/commodity_detail/images/";
//	public String BROWSE_URL=URL_O+"/brow_test/abc";
//	public String IMAGE_URL=URL_O+"/brow_test/images/";
	//public String COLLECTION_URL=URL_O+"/commodity_detail/abc";
	//public String FAVORITE_URL=URL_O+"/brow_test/abc";
	//public String FAVORITE_IMAGE=URL_O+"/brow_test/images/";
	
	public String FAVORITE_URL=URL_BASE+"/xueZhang/servlet/AndroidFavoriteSev";
	public String FAVORITE_IMAGE=URL_BASE+"/xueZhang/";
	
	public String SETTINGMYINFO_URL=URL_BASE+"/xueZhang/servlet/AndroidInfoSev";
	
	public String SETTINGREGISTER_URL=URL_BASE+"/xueZhang/servlet/AndroidRegisterSev";
	
	public String COMMODITY_COLLECTION_URL=URL_BASE+"/xueZhang/servlet/AndroidAddCollectionSev";
	
	public String getCOMMODITY_COLLECTION_URL() {
		return COMMODITY_COLLECTION_URL;
	}
	public String getSETTINGRESGISTER_URL() {
		return SETTINGREGISTER_URL;
	}
	
	public String getSETTINGMYINFO_URL() {
		return SETTINGMYINFO_URL;
	}
	
	public String getFAVORITE_URL() {
		return FAVORITE_URL;
	}
	
	public String getFAVORITE_IMAGE() {
		return FAVORITE_IMAGE;
	}
	public String getCOLLECTION_URL() {
		return COLLECTION_URL;
	}
	public String getCONTENT_DETAIL() {
		return CONTENT_DETAIL;
	}
	public void setCONTENT_DETAIL(String cONTENT_DETAIL) {
		CONTENT_DETAIL = cONTENT_DETAIL;
	}
	public String getDETAIL_IAMGE_URL() {
		return DETAIL_IAMGE_URL;
	}
	public void setDETAIL_IAMGE_URL(String dETAIL_IAMGE_URL) {
		DETAIL_IAMGE_URL = dETAIL_IAMGE_URL;
	}



	
	public String getLOGIN_URL() {
		return LOGIN_URL;
	}
	public void setLOGIN_URL(String lOGIN_URL) {
		LOGIN_URL = lOGIN_URL;
	}
	public String getBROWSE_URL() {
		return BROWSE_URL;
	}
	public void setBROWSE_URL(String bROWSE_URL) {
		BROWSE_URL = bROWSE_URL;
	}
	
	public String getIMAGE_URL() {
		return IMAGE_URL;
	}
	

}
