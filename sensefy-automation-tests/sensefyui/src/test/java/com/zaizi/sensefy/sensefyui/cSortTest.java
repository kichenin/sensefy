package com.zaizi.sensefy.sensefyui;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.zaizi.sensefy.sensefyui.elements.Element;
import com.zaizi.sensefy.sensefyui.exceptions.IterableException;
import com.zaizi.sensefy.sensefyui.info.TestCaseProperties;
import com.zaizi.sensefy.sensefyui.info.TestCaseValues;
import com.zaizi.sensefy.sensefyui.pages.SearchLogin;
import com.zaizi.sensefy.sensefyui.pages.SearchPage;
/*
 * Test sort scenarios
 */
@RunWith(value = Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class cSortTest {
	public static final Logger LOGGER = LogManager.getLogger(cSortTest.class.getName());
	
	public static final ExtentReports extent = ExtentReports.get(cSortTest.class);
	
	/**
	 * defining class name
	 */
	public static String className = cSortTest.class.getSimpleName();
	
	private String username;
    private String password;
    public String searchWord;
    public String screenshot_name;
    
    public String searchTerm="//input[@id='searchTerm']";
    
    static WebDriver driver;
    
    public cSortTest(String username, String password, String searchWord,String screenshot_name)
    {
        this.username = username;
        this.password = password;
        this.searchWord=searchWord;
        this.screenshot_name = screenshot_name;
    }
    
    @BeforeClass
    public static void beforeClass() throws IOException {
    	
    	Element.reportInitial(driver, className);
        extent.config().documentTitle("SensefyUI Automation Test Report");
        extent.config().reportTitle("SensefyUI Automation");
        extent.config().reportHeadline("Search Page Testing");
    }     

	@Parameters()
    public static Iterable<Object[]> data() throws IterableException
    {
    	LOGGER.info(TestCaseProperties.TEXT_TEST_PREPARING, "SortTest");
        return TestCaseValues.documentLibraryTestValues("SortTest");
    }
    
    //Test sort by creator
    @Test
    public void a_sortbyCreator() throws InterruptedException, IOException
    {
    	LOGGER.info("Running Verify SortByCreator Test");
    	extent.startTest("Verify SortByCreator Test");
    	try
    	{
    		driver = TestCaseProperties.getWebDriverForSearch();
            SearchLogin loginPage = new SearchLogin(driver);
            loginPage.searchuiLogin(username, password);
            Thread.sleep(2000);
            loginPage.checkElementPresent(searchTerm);
            Thread.sleep(2000);
            SearchPage searchPage=new SearchPage(driver);
            searchPage.searchATerm(searchWord);
            Thread.sleep(5000);
            searchPage.selectASort("Creator");
            searchPage.sortbynames("Creator");
            Thread.sleep(5000);
            LOGGER.info("SortByCreator Verified Successfully");
    		LOGGER.info(TestCaseProperties.TEXT_TEST_PASS, "SortByCreator Verified Successfully");
    		extent.log(LogStatus.PASS, "SortByCreator Verified Successfully");
    		Element.takescreenshot(driver,className,screenshot_name+"1");
    	}
    	catch(Exception e)
    	{
    		extent.log(LogStatus.FAIL, "SortByCreator Verification Failed");
    		LOGGER.error("SortByCreator Verification Failed");
    		Element.takescreenshot(driver,className,screenshot_name+"2");
    	}
    	TestCaseProperties.closeDriver(driver);
    	LOGGER.info("---------------------------");
    }
	
    //Test sort by name
    @Test
    public void b_sortbyName() throws InterruptedException, IOException
    {
    	LOGGER.info("Running Verify SortByName Test");
    	extent.startTest("Verify SortByName Test");
    	try
    	{
    		driver = TestCaseProperties.getWebDriverForSearch();
            SearchLogin loginPage = new SearchLogin(driver);
            loginPage.searchuiLogin(username, password);
            Thread.sleep(2000);
            loginPage.checkElementPresent(searchTerm);
            Thread.sleep(2000);
            SearchPage searchPage=new SearchPage(driver);
            searchPage.searchATerm(searchWord);
            Thread.sleep(5000);
            searchPage.selectASort("Name");
            searchPage.sortbynames("Name");
            Thread.sleep(5000);
            LOGGER.info("SortByName Verified Successfully");
    		LOGGER.info(TestCaseProperties.TEXT_TEST_PASS, "SortByName Verified Successfully");
    		extent.log(LogStatus.PASS, "SortByName Verified Successfully");
    		Element.takescreenshot(driver,className,screenshot_name+"3");
    	}
    	catch(Exception e)
    	{
    		extent.log(LogStatus.FAIL, "SortByName Verification Failed");
    		LOGGER.error("SortByName Verification Failed");
    		Element.takescreenshot(driver,className,screenshot_name+"4");
    	}
    	TestCaseProperties.closeDriver(driver);
    	LOGGER.info("---------------------------");
    }
    
    //Test sort by created 
    @Test
    public void c_sortbyCreated() throws InterruptedException, IOException
    {
    	LOGGER.info("Running Verify SortByCreated Test");
    	extent.startTest("Verify SortByCreated Test");
    	try
    	{
    		driver = TestCaseProperties.getWebDriverForSearch();
            SearchLogin loginPage = new SearchLogin(driver);
            loginPage.searchuiLogin(username, password);
            Thread.sleep(2000);
            loginPage.checkElementPresent(searchTerm);
            Thread.sleep(2000);
            SearchPage searchPage=new SearchPage(driver);
            searchPage.searchATerm(searchWord);
            Thread.sleep(5000);
            searchPage.selectASort("Created");
            searchPage.sortbynames("Created");
            Thread.sleep(5000);
            LOGGER.info("SortByCreated Verified Successfully");
    		LOGGER.info(TestCaseProperties.TEXT_TEST_PASS, "SortByCreated Verified Successfully");
    		extent.log(LogStatus.PASS, "SortByCreated Verified Successfully");
    		Element.takescreenshot(driver,className,screenshot_name+"5");
    	}
    	catch(Exception e)
    	{
    		extent.log(LogStatus.FAIL, "SortByCreated Verification Failed");
    		LOGGER.error("SortByCreated Verification Failed");
    		Element.takescreenshot(driver,className,screenshot_name+"6");
    	}
    	TestCaseProperties.closeDriver(driver);
    	LOGGER.info("---------------------------");
    }
	
    //Test sort by Modifier
    @Test
    public void d_sortbyModifier() throws InterruptedException, IOException
    {
    	LOGGER.info("Running Verify SortByModifier Test");
    	extent.startTest("Verify SortByModifier Test");
    	try
    	{
    		driver = TestCaseProperties.getWebDriverForSearch();
            SearchLogin loginPage = new SearchLogin(driver);
            loginPage.searchuiLogin(username, password);
            Thread.sleep(2000);
            loginPage.checkElementPresent(searchTerm);
            Thread.sleep(2000);
            SearchPage searchPage=new SearchPage(driver);
            searchPage.searchATerm(searchWord);
            Thread.sleep(5000);
            searchPage.selectASort("Modifier");
            searchPage.sortbynames("Modifier");
            Thread.sleep(5000);
            LOGGER.info("SortByModifier Verified Successfully");
    		LOGGER.info(TestCaseProperties.TEXT_TEST_PASS, "SortByModifier Verified Successfully");
    		extent.log(LogStatus.PASS, "SortByModifier Verified Successfully");
    		Element.takescreenshot(driver,className,screenshot_name+"7");
    	}
    	catch(Exception e)
    	{
    		extent.log(LogStatus.FAIL, "SortByModifier Verification Failed");
    		LOGGER.error("SortByModifier Verification Failed");
    		Element.takescreenshot(driver,className,screenshot_name+"8");
    	}
    	TestCaseProperties.closeDriver(driver);
    	LOGGER.info("---------------------------");
    }

    //Test sort by Modified
    @Test
    public void e_sortbyModified() throws InterruptedException, IOException
    {
    	LOGGER.info("Running Verify SortByModified Test");
    	extent.startTest("Verify SortByModified Test");
    	try
    	{
    		driver = TestCaseProperties.getWebDriverForSearch();
            SearchLogin loginPage = new SearchLogin(driver);
            loginPage.searchuiLogin(username, password);
            Thread.sleep(2000);
            loginPage.checkElementPresent(searchTerm);
            Thread.sleep(2000);
            SearchPage searchPage=new SearchPage(driver);
            searchPage.searchATerm(searchWord);
            Thread.sleep(5000);
            searchPage.selectASort("Modified");
            searchPage.sortbynames("Modified");
            Thread.sleep(5000);
            LOGGER.info("SortByModified Verified Successfully");
    		LOGGER.info(TestCaseProperties.TEXT_TEST_PASS, "SortByModified Verified Successfully");
    		extent.log(LogStatus.PASS, "SortByModified Verified Successfully");
    		Element.takescreenshot(driver,className,screenshot_name+"9");
    	}
    	catch(Exception e)
    	{
    		extent.log(LogStatus.FAIL, "SortByModified Verification Failed");
    		LOGGER.error("SortByModified Verification Failed");
    		Element.takescreenshot(driver,className,screenshot_name+"10");
    	}
    	TestCaseProperties.closeDriver(driver);
    	LOGGER.info("---------------------------");
    }
    
    //Test sort by Relevance
    @Test
    public void f_sortbyRelevance() throws InterruptedException, IOException
    {
    	LOGGER.info("Running Verify SortByRelevance Test");
    	extent.startTest("Verify SortByRelevance Test");
    	try
    	{
    		driver = TestCaseProperties.getWebDriverForSearch();
            SearchLogin loginPage = new SearchLogin(driver);
            loginPage.searchuiLogin(username, password);
            Thread.sleep(2000);
            loginPage.checkElementPresent(searchTerm);
            Thread.sleep(2000);
            SearchPage searchPage=new SearchPage(driver);
            searchPage.searchATerm(searchWord);
            Thread.sleep(5000);
            searchPage.selectASort("Relevance");
            searchPage.sortbynames("Relevance");
            Thread.sleep(5000);
            LOGGER.info("SortByRelevance Verified Successfully");
    		LOGGER.info(TestCaseProperties.TEXT_TEST_PASS, "SortByRelevance Verified Successfully");
    		extent.log(LogStatus.PASS, "SortByRelevance Verified Successfully");
    		Element.takescreenshot(driver,className,screenshot_name+"10");
    	}
    	catch(Exception e)
    	{
    		extent.log(LogStatus.FAIL, "SortByRelevance Verification Failed");
    		LOGGER.error("SortByRelevance Verification Failed");
    		Element.takescreenshot(driver,className,screenshot_name+"11");
    	}
    	TestCaseProperties.closeDriver(driver);
    	LOGGER.info("---------------------------");
    }
    
    //Test sort by Title
    @Test
    public void g_sortbyTitle() throws InterruptedException, IOException
    {
    	LOGGER.info("Running Verify SortByTitle Test");
    	extent.startTest("Verify SortByTitle Test");
    	try
    	{
    		driver = TestCaseProperties.getWebDriverForSearch();
            SearchLogin loginPage = new SearchLogin(driver);
            loginPage.searchuiLogin(username, password);
            Thread.sleep(2000);
            loginPage.checkElementPresent(searchTerm);
            Thread.sleep(2000);
            SearchPage searchPage=new SearchPage(driver);
            searchPage.searchATerm(searchWord);
            Thread.sleep(5000);
            searchPage.selectASort("Title");
            searchPage.sortbynames("Title");
            Thread.sleep(5000);
            LOGGER.info("SortByTitle Verified Successfully");
    		LOGGER.info(TestCaseProperties.TEXT_TEST_PASS, "SortByTitle Verified Successfully");
    		extent.log(LogStatus.PASS, "SortByTitle Verified Successfully");
    		Element.takescreenshot(driver,className,screenshot_name+"12");
    	}
    	catch(Exception e)
    	{
    		extent.log(LogStatus.FAIL, "SortByTitle Verification Failed");
    		LOGGER.error("SortByTitle Verification Failed");
    		Element.takescreenshot(driver,className,screenshot_name+"13");
    	}
    	TestCaseProperties.closeDriver(driver);
    	LOGGER.info("---------------------------");
    }
}
