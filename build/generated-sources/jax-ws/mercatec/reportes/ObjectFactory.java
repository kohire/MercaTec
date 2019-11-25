
package mercatec.reportes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mercatec.reportes package. 
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

    private final static QName _DeleteReport_QNAME = new QName("http://reportes.mercatec/", "deleteReport");
    private final static QName _DeleteSameReports_QNAME = new QName("http://reportes.mercatec/", "deleteSameReports");
    private final static QName _DeleteSameReportsResponse_QNAME = new QName("http://reportes.mercatec/", "deleteSameReportsResponse");
    private final static QName _InsertReport_QNAME = new QName("http://reportes.mercatec/", "insertReport");
    private final static QName _InsertReportResponse_QNAME = new QName("http://reportes.mercatec/", "insertReportResponse");
    private final static QName _DeleteReportResponse_QNAME = new QName("http://reportes.mercatec/", "deleteReportResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mercatec.reportes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertReport }
     * 
     */
    public InsertReport createInsertReport() {
        return new InsertReport();
    }

    /**
     * Create an instance of {@link InsertReportResponse }
     * 
     */
    public InsertReportResponse createInsertReportResponse() {
        return new InsertReportResponse();
    }

    /**
     * Create an instance of {@link DeleteReport }
     * 
     */
    public DeleteReport createDeleteReport() {
        return new DeleteReport();
    }

    /**
     * Create an instance of {@link DeleteSameReports }
     * 
     */
    public DeleteSameReports createDeleteSameReports() {
        return new DeleteSameReports();
    }

    /**
     * Create an instance of {@link DeleteSameReportsResponse }
     * 
     */
    public DeleteSameReportsResponse createDeleteSameReportsResponse() {
        return new DeleteSameReportsResponse();
    }

    /**
     * Create an instance of {@link DeleteReportResponse }
     * 
     */
    public DeleteReportResponse createDeleteReportResponse() {
        return new DeleteReportResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reportes.mercatec/", name = "deleteReport")
    public JAXBElement<DeleteReport> createDeleteReport(DeleteReport value) {
        return new JAXBElement<DeleteReport>(_DeleteReport_QNAME, DeleteReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSameReports }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reportes.mercatec/", name = "deleteSameReports")
    public JAXBElement<DeleteSameReports> createDeleteSameReports(DeleteSameReports value) {
        return new JAXBElement<DeleteSameReports>(_DeleteSameReports_QNAME, DeleteSameReports.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSameReportsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reportes.mercatec/", name = "deleteSameReportsResponse")
    public JAXBElement<DeleteSameReportsResponse> createDeleteSameReportsResponse(DeleteSameReportsResponse value) {
        return new JAXBElement<DeleteSameReportsResponse>(_DeleteSameReportsResponse_QNAME, DeleteSameReportsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reportes.mercatec/", name = "insertReport")
    public JAXBElement<InsertReport> createInsertReport(InsertReport value) {
        return new JAXBElement<InsertReport>(_InsertReport_QNAME, InsertReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertReportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reportes.mercatec/", name = "insertReportResponse")
    public JAXBElement<InsertReportResponse> createInsertReportResponse(InsertReportResponse value) {
        return new JAXBElement<InsertReportResponse>(_InsertReportResponse_QNAME, InsertReportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reportes.mercatec/", name = "deleteReportResponse")
    public JAXBElement<DeleteReportResponse> createDeleteReportResponse(DeleteReportResponse value) {
        return new JAXBElement<DeleteReportResponse>(_DeleteReportResponse_QNAME, DeleteReportResponse.class, null, value);
    }

}
