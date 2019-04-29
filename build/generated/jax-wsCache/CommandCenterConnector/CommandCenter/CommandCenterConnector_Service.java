
package CommandCenter;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CommandCenterConnector", targetNamespace = "http://services.licensing.business.s3systems.com/", wsdlLocation = "http://test.finultimate.com:8080/CommandCenterConnector/CommandCenterConnector?wsdl")
public class CommandCenterConnector_Service
    extends Service
{

    private final static URL COMMANDCENTERCONNECTOR_WSDL_LOCATION;
    private final static WebServiceException COMMANDCENTERCONNECTOR_EXCEPTION;
    private final static QName COMMANDCENTERCONNECTOR_QNAME = new QName("http://services.licensing.business.s3systems.com/", "CommandCenterConnector");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://test.finultimate.com:8080/CommandCenterConnector/CommandCenterConnector?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COMMANDCENTERCONNECTOR_WSDL_LOCATION = url;
        COMMANDCENTERCONNECTOR_EXCEPTION = e;
    }

    public CommandCenterConnector_Service() {
        super(__getWsdlLocation(), COMMANDCENTERCONNECTOR_QNAME);
    }

    public CommandCenterConnector_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), COMMANDCENTERCONNECTOR_QNAME, features);
    }

    public CommandCenterConnector_Service(URL wsdlLocation) {
        super(wsdlLocation, COMMANDCENTERCONNECTOR_QNAME);
    }

    public CommandCenterConnector_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COMMANDCENTERCONNECTOR_QNAME, features);
    }

    public CommandCenterConnector_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CommandCenterConnector_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CommandCenterConnector
     */
    @WebEndpoint(name = "CommandCenterConnectorPort")
    public CommandCenterConnector getCommandCenterConnectorPort() {
        return super.getPort(new QName("http://services.licensing.business.s3systems.com/", "CommandCenterConnectorPort"), CommandCenterConnector.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CommandCenterConnector
     */
    @WebEndpoint(name = "CommandCenterConnectorPort")
    public CommandCenterConnector getCommandCenterConnectorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.licensing.business.s3systems.com/", "CommandCenterConnectorPort"), CommandCenterConnector.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COMMANDCENTERCONNECTOR_EXCEPTION!= null) {
            throw COMMANDCENTERCONNECTOR_EXCEPTION;
        }
        return COMMANDCENTERCONNECTOR_WSDL_LOCATION;
    }

}
