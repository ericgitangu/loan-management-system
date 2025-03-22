
package com.credable.lms.client.soap.generated;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "CustomerPort", targetNamespace = "http://credable.io/cbs/customer")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerPort {


    /**
     * 
     * @param customerRequest
     * @return
     *     returns com.credable.lms.client.soap.generated.CustomerResponse
     */
    @WebMethod(operationName = "Customer")
    @WebResult(name = "CustomerResponse", targetNamespace = "http://credable.io/cbs/customer", partName = "CustomerResponse")
    public CustomerResponse customer(
        @WebParam(name = "CustomerRequest", targetNamespace = "http://credable.io/cbs/customer", partName = "CustomerRequest")
        CustomerRequest customerRequest);

}
