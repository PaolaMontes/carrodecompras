import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class ComprasSteps {

	@Given("Navego a la pagina")
	def IngresarPagina() {

		WebUI.openBrowser('')

		WebUI.navigateToUrl('http://automationpractice.com/index.php?controller=authentication&back=my-account')
	}

	@And("Ingreso mi (.*) y (.*)")
	def Login(String usuario,String contraseña) {

		WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input_Email address_email'), usuario)

		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login - My Store/input_Password_passwd'), contraseña)

		WebUI.click(findTestObject('Object Repository/Page_Login - My Store/span_Sign in'))
	}

	@When("Realizo la compra y doy click en comprar")
	def Compra() {
		WebUI.click(findTestObject('Object Repository/Page_My account - My Store/a_Women'))

		WebUI.click(findTestObject('Object Repository/Page_Women - My Store/div_16.4020.50-20'))

		WebUI.click(findTestObject('Object Repository/Page_Women - My Store/a_More_color_37'))

		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Printed Chiffon Dress - My Store/select_SML'), '3', true)

		WebUI.click(findTestObject('Object Repository/Page_Printed Chiffon Dress - My Store/span_Add to cart'))

		WebUI.click(findTestObject('Object Repository/Page_Printed Chiffon Dress - My Store/span_Proceed to checkout'))

		WebUI.click(findTestObject('Object Repository/Page_Order - My Store/span_Proceed to checkout'))

		WebUI.click(findTestObject('Page_Order - My Store/btn_addres'))

		WebUI.click(findTestObject('Object Repository/Page_Order - My Store/input_2.00_cgv'))

		WebUI.click(findTestObject('Object Repository/Page_Order - My Store/span_Proceed to checkout_1'))

		WebUI.click(findTestObject('Object Repository/Page_Order - My Store/a_Pay by bank wire (order processing will b_e7efad'))

		WebUI.click(findTestObject('Object Repository/Page_My Store/span_I confirm my order'))
	}

	@Then("El sistema me presenta el  mensaje de Exito")
	def Exito() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Order confirmation - My Store/strong_Your order on My Store is complete'))

		WebUI.closeBrowser()
	}
}