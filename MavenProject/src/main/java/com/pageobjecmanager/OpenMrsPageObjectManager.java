package com.pageobjecmanager;

import com.baseclass.BaseClass;
import com.pageobjectmodel.OpenMrsLoginPage;
import com.srcmainresources.OpenMrsFileReaderManager;

public class OpenMrsPageObjectManager extends BaseClass {

	private OpenMrsLoginPage lp;
	
	public OpenMrsLoginPage getLoginPage() {
		if (lp == null) {
			lp = new OpenMrsLoginPage(driver);
		}
		return lp;
	}

	private OpenMrsFileReaderManager fileReader;

//	public OpenMrsLoginPage getLoginPage() {
//
//		if (loginPage == null) {
//			loginPage = new OpenMrsLoginPage(driver);
//		}
//		return loginPage;
//	}

	public OpenMrsFileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new OpenMrsFileReaderManager();
		}
		return fileReader;
	}
}
