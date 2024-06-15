package org.TTA.Naukri_Page;


import org.TTA.Base.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class homepage extends Common {
private By usename=By.xpath("(//input)[1]");
private By pass=By.xpath("(//input)[2]");
private By login_btn_OnDashBoardPage=By.xpath("//a[text()=\"Login\"]");
private By login_btn_toLogin=By.xpath("//button[@type=\"submit\"]");
private By view_profile_tab=By.xpath("//div[@class=\"view-profile-wrapper\"]/a");
private By resume_Headline=By.xpath("//span[@class=\"edit icon\"]");
private By textspance_of_Headline=By.id("resumeHeadlineTxt");
private By Save_Btn=By.xpath("//button[text()=\"Save\"]");


    public homepage update_Profile_with_dot() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\nikpo\\IdeaProjects\\LumaEcart\\src\\main\\java\\org\\TTA\\Resources\\data.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String naukri_url = prop.getProperty("naukri_url");
        openUrl(naukri_url);
        clickElemnet(login_btn_OnDashBoardPage);
        implicitWait(50);
        enterInput(usename, prop.getProperty("naukri_email"));
        enterInput(pass, prop.getProperty("naukri_password"));
        clickElemnet(login_btn_toLogin);
        clickElemnet(view_profile_tab);
        clickElemnet(resume_Headline);
        enterInput(textspance_of_Headline,".");
        clickElemnet(Save_Btn);
        return this;
    }
    public homepage update_Profile_remove_dot() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\nikpo\\IdeaProjects\\LumaEcart\\src\\main\\java\\org\\TTA\\Resources\\data.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String naukri_url = prop.getProperty("naukri_url");
        openUrl(naukri_url);
        clickElemnet(login_btn_OnDashBoardPage);
        implicitWait(50);
        enterInput(usename, prop.getProperty("naukri_email"));
        enterInput(pass, prop.getProperty("naukri_password"));
        clickElemnet(login_btn_toLogin);
        clickElemnet(view_profile_tab);
        clickElemnet(resume_Headline);
        enterInput(textspance_of_Headline, String.valueOf(Keys.BACK_SPACE));
        clickElemnet(Save_Btn);
        return this;
    }
}
