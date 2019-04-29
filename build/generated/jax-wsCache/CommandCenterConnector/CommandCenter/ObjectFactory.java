
package CommandCenter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the CommandCenter package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidateTenantLicenseForLogin_QNAME = new QName("http://services.licensing.business.s3systems.com/", "validateTenantLicenseForLogin");
    private final static QName _ValidateTenantLicenseForUserCreate_QNAME = new QName("http://services.licensing.business.s3systems.com/", "validateTenantLicenseForUserCreate");
    private final static QName _Exception_QNAME = new QName("http://services.licensing.business.s3systems.com/", "Exception");
    private final static QName _ValidateTenantLicenseForLoginResponse_QNAME = new QName("http://services.licensing.business.s3systems.com/", "validateTenantLicenseForLoginResponse");
    private final static QName _LicenseNotYetActivatedException_QNAME = new QName("http://services.licensing.business.s3systems.com/", "LicenseNotYetActivatedException");
    private final static QName _TenantNotFoundException_QNAME = new QName("http://services.licensing.business.s3systems.com/", "TenantNotFoundException");
    private final static QName _ValidateTenantLicenseForUserCreateResponse_QNAME = new QName("http://services.licensing.business.s3systems.com/", "validateTenantLicenseForUserCreateResponse");
    private final static QName _ValidateTenantLicensesForLogin_QNAME = new QName("http://services.licensing.business.s3systems.com/", "validateTenantLicensesForLogin");
    private final static QName _LicenseExpiredException_QNAME = new QName("http://services.licensing.business.s3systems.com/", "LicenseExpiredException");
    private final static QName _TransactionsExceededException_QNAME = new QName("http://services.licensing.business.s3systems.com/", "TransactionsExceededException");
    private final static QName _ApplicationNotFoundException_QNAME = new QName("http://services.licensing.business.s3systems.com/", "ApplicationNotFoundException");
    private final static QName _ValidateTenantLicensesForLoginResponse_QNAME = new QName("http://services.licensing.business.s3systems.com/", "validateTenantLicensesForLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: CommandCenter
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LicenseExpiredException }
     * 
     */
    public LicenseExpiredException createLicenseExpiredException() {
        return new LicenseExpiredException();
    }

    /**
     * Create an instance of {@link TransactionsExceededException }
     * 
     */
    public TransactionsExceededException createTransactionsExceededException() {
        return new TransactionsExceededException();
    }

    /**
     * Create an instance of {@link ApplicationNotFoundException }
     * 
     */
    public ApplicationNotFoundException createApplicationNotFoundException() {
        return new ApplicationNotFoundException();
    }

    /**
     * Create an instance of {@link ValidateTenantLicensesForLoginResponse }
     * 
     */
    public ValidateTenantLicensesForLoginResponse createValidateTenantLicensesForLoginResponse() {
        return new ValidateTenantLicensesForLoginResponse();
    }

    /**
     * Create an instance of {@link LicenseNotYetActivatedException }
     * 
     */
    public LicenseNotYetActivatedException createLicenseNotYetActivatedException() {
        return new LicenseNotYetActivatedException();
    }

    /**
     * Create an instance of {@link TenantNotFoundException }
     * 
     */
    public TenantNotFoundException createTenantNotFoundException() {
        return new TenantNotFoundException();
    }

    /**
     * Create an instance of {@link ValidateTenantLicenseForUserCreateResponse }
     * 
     */
    public ValidateTenantLicenseForUserCreateResponse createValidateTenantLicenseForUserCreateResponse() {
        return new ValidateTenantLicenseForUserCreateResponse();
    }

    /**
     * Create an instance of {@link ValidateTenantLicensesForLogin }
     * 
     */
    public ValidateTenantLicensesForLogin createValidateTenantLicensesForLogin() {
        return new ValidateTenantLicensesForLogin();
    }

    /**
     * Create an instance of {@link ValidateTenantLicenseForLogin }
     * 
     */
    public ValidateTenantLicenseForLogin createValidateTenantLicenseForLogin() {
        return new ValidateTenantLicenseForLogin();
    }

    /**
     * Create an instance of {@link ValidateTenantLicenseForUserCreate }
     * 
     */
    public ValidateTenantLicenseForUserCreate createValidateTenantLicenseForUserCreate() {
        return new ValidateTenantLicenseForUserCreate();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ValidateTenantLicenseForLoginResponse }
     * 
     */
    public ValidateTenantLicenseForLoginResponse createValidateTenantLicenseForLoginResponse() {
        return new ValidateTenantLicenseForLoginResponse();
    }

    /**
     * Create an instance of {@link BusinessTenantDTO }
     * 
     */
    public BusinessTenantDTO createBusinessTenantDTO() {
        return new BusinessTenantDTO();
    }

    /**
     * Create an instance of {@link TenancyLicenseDTO }
     * 
     */
    public TenancyLicenseDTO createTenancyLicenseDTO() {
        return new TenancyLicenseDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTenantLicenseForLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "validateTenantLicenseForLogin")
    public JAXBElement<ValidateTenantLicenseForLogin> createValidateTenantLicenseForLogin(ValidateTenantLicenseForLogin value) {
        return new JAXBElement<ValidateTenantLicenseForLogin>(_ValidateTenantLicenseForLogin_QNAME, ValidateTenantLicenseForLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTenantLicenseForUserCreate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "validateTenantLicenseForUserCreate")
    public JAXBElement<ValidateTenantLicenseForUserCreate> createValidateTenantLicenseForUserCreate(ValidateTenantLicenseForUserCreate value) {
        return new JAXBElement<ValidateTenantLicenseForUserCreate>(_ValidateTenantLicenseForUserCreate_QNAME, ValidateTenantLicenseForUserCreate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTenantLicenseForLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "validateTenantLicenseForLoginResponse")
    public JAXBElement<ValidateTenantLicenseForLoginResponse> createValidateTenantLicenseForLoginResponse(ValidateTenantLicenseForLoginResponse value) {
        return new JAXBElement<ValidateTenantLicenseForLoginResponse>(_ValidateTenantLicenseForLoginResponse_QNAME, ValidateTenantLicenseForLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LicenseNotYetActivatedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "LicenseNotYetActivatedException")
    public JAXBElement<LicenseNotYetActivatedException> createLicenseNotYetActivatedException(LicenseNotYetActivatedException value) {
        return new JAXBElement<LicenseNotYetActivatedException>(_LicenseNotYetActivatedException_QNAME, LicenseNotYetActivatedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TenantNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "TenantNotFoundException")
    public JAXBElement<TenantNotFoundException> createTenantNotFoundException(TenantNotFoundException value) {
        return new JAXBElement<TenantNotFoundException>(_TenantNotFoundException_QNAME, TenantNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTenantLicenseForUserCreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "validateTenantLicenseForUserCreateResponse")
    public JAXBElement<ValidateTenantLicenseForUserCreateResponse> createValidateTenantLicenseForUserCreateResponse(ValidateTenantLicenseForUserCreateResponse value) {
        return new JAXBElement<ValidateTenantLicenseForUserCreateResponse>(_ValidateTenantLicenseForUserCreateResponse_QNAME, ValidateTenantLicenseForUserCreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTenantLicensesForLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "validateTenantLicensesForLogin")
    public JAXBElement<ValidateTenantLicensesForLogin> createValidateTenantLicensesForLogin(ValidateTenantLicensesForLogin value) {
        return new JAXBElement<ValidateTenantLicensesForLogin>(_ValidateTenantLicensesForLogin_QNAME, ValidateTenantLicensesForLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LicenseExpiredException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "LicenseExpiredException")
    public JAXBElement<LicenseExpiredException> createLicenseExpiredException(LicenseExpiredException value) {
        return new JAXBElement<LicenseExpiredException>(_LicenseExpiredException_QNAME, LicenseExpiredException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionsExceededException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "TransactionsExceededException")
    public JAXBElement<TransactionsExceededException> createTransactionsExceededException(TransactionsExceededException value) {
        return new JAXBElement<TransactionsExceededException>(_TransactionsExceededException_QNAME, TransactionsExceededException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "ApplicationNotFoundException")
    public JAXBElement<ApplicationNotFoundException> createApplicationNotFoundException(ApplicationNotFoundException value) {
        return new JAXBElement<ApplicationNotFoundException>(_ApplicationNotFoundException_QNAME, ApplicationNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTenantLicensesForLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.licensing.business.s3systems.com/", name = "validateTenantLicensesForLoginResponse")
    public JAXBElement<ValidateTenantLicensesForLoginResponse> createValidateTenantLicensesForLoginResponse(ValidateTenantLicensesForLoginResponse value) {
        return new JAXBElement<ValidateTenantLicensesForLoginResponse>(_ValidateTenantLicensesForLoginResponse_QNAME, ValidateTenantLicensesForLoginResponse.class, null, value);
    }

}
