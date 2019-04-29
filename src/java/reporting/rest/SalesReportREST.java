/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.primefaces.json.JSONObject;
import reporting.beans.InventoryMainBean;
import reporting.beans.SalesServiceBean;
import reporting.beans.StockItemUnitService;
import reporting.util.DateConvert;
import reporting.util.DateSetter;
import reporting.util.ExcludeFieldsInJSON;
import reporting.util.InventoryReportFormat;
import reporting.util.ParamBuilder;
import reporting.util.ReportFormat;
import reporting.util.ReportParamVendor;
import reporting.util.ReportPattern;
import reporting.wrapper.CustomerProductReport;
import reporting.wrapper.CustomerReport;
import reporting.wrapper.OutletProductReport;
import reporting.wrapper.OutletReport;
import reporting.wrapper.ReportParam;
import reporting.wrapper.ReportResponse;
import reporting.wrapper.TestParam;
import reporting.wrapper.TransactionWrapper;
import reporting.wrapper.UserProductReport;
import reporting.wrapper.UserReport;

/**
 * REST Web Service
 *
 * @author S3-Developer
 */
@Path("sales-report-service")
public class SalesReportREST {

    @ManagedProperty(value = "#{salesServiceBean}")
    private SalesServiceBean salesService;

    @ManagedProperty(value = "#{stockItemUnitService}")
    private StockItemUnitService stockItemUnitService;

    @ManagedProperty(value = "#{inventoryMainBean}")
    private InventoryMainBean mainService;
    
    
    private DateConvert dateConvert;

    Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SalesReportREST
     */
    public SalesReportREST() {
        salesService = new SalesServiceBean();
        stockItemUnitService = new StockItemUnitService();
        mainService = new InventoryMainBean();
        dateConvert = new DateConvert();
    }

    /**
     * Retrieves representation of an instance of reporting.rest.SalesReportREST
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate-report")
    public Response generateReport(ReportParam wrapper) {
        try {
//            System.out.println("In generateReport");System.out.println(wrapper.getReportType());
//            System.out.println(wrapper.getReportGranularity());System.out.println(wrapper.getMeasure());

            ReportResponse response = salesService.generateSalesSummary(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());
            //return new Response.<Object>(response, HttpStatus.OK);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            // return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(iue.getMessage()), HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/generate-user-report")
    public Response generateUserReport(ReportParam wrapper) {
        try {
            if (wrapper.getReportGranularity().getStart() == null || wrapper.getReportGranularity().getEnd() == null || wrapper.getReportGranularity() == null || wrapper.getMeasure() == null) {
                throw new Exception("Invalid Parameter");
            }

            List<UserReport> userReports = salesService.generateSalesSummaryByUsers(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());

            return Response.status(Response.Status.OK).entity(gson.toJson(userReports)).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate-user-product-report")
    public Response generateUserProductReport(ReportParam wrapper) {
        try {
            List<UserProductReport> response = salesService.generateUserProductSummary(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());
            return Response.status(Response.Status.OK).entity(gson.toJson(response)).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            //return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(iue.getMessage()), HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate-customer-report")
    public Response generateCustomerReport(ReportParam wrapper) {
        try {
            List<CustomerReport> customerReports = salesService.generateSalesSummaryByCustomer(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());
            return Response.status(Response.Status.OK).entity(gson.toJson(customerReports)).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            //return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(iue.getMessage()), HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate-customer-product-report")
    public Response generateCustomerProductReport(ReportParam wrapper) {
        try {
            List<CustomerProductReport> response = salesService.generateCustomerProductSummary(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());
            return Response.status(Response.Status.OK).entity(gson.toJson(response)).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            //return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(iue.getMessage()), HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate-outlet-report")
    public Response generateOutletReport(ReportParam wrapper) {
        try {
            List<OutletReport> outletReports = salesService.generateSalesSummaryByOutlet(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());
            return Response.status(Response.Status.OK).entity(gson.toJson(outletReports)).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            //return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(iue.getMessage()), HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate-outlet-product-report")
    public Response generateOutletProductReport(ReportParam wrapper) {
        try {
            List<OutletProductReport> response = salesService.generateOutletProductSummary(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());
            return Response.status(Response.Status.OK).entity(gson.toJson(response)).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            // return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(iue.getMessage()), HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate-product-report")
    public Response generateProductReport(ReportParam wrapper) {
        try {
            ReportResponse response = salesService.generateProductSummary(wrapper.getReportType(), wrapper.getMeasure(), wrapper.getReportGranularity());
            // return new ResponseEntity<Object>(response, HttpStatus.OK);

            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception iue) {
            iue.printStackTrace();
            // return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(iue.getMessage()), HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/save-transaction")
    public Response postTransaction(TransactionWrapper transactionWrapper) {
        // return new ResponseEntity<Object>(transactionWrapper, HttpStatus.OK);
        return Response.status(Response.Status.OK).entity(transactionWrapper).build();
    }

    /**
     * *****************************************************************************
     * THIS IS THE SECTION FOR VENDOR REPORTS
     * *******************************************************************************
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/by-vendor-payments")
    public Response showVendorReportsByVendorPayments(ReportParamVendor reportParamVendor) {

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExcludeFieldsInJSON())
                .serializeNulls() //<-- uncomment to serialize NULL fields as well
                .create();

        Date start = null;
        Date end = null;
        try {
            start = new DateSetter().setDateFormat(reportParamVendor.getStartDate());
            end = new DateSetter().setDateFormat(reportParamVendor.getEndDate());

            //Method Call
            List<ReportFormat> payments = stockItemUnitService.getReportOfVendorPayments(start, end);

            return Response.status(Response.Status.OK).entity(gson.toJson(payments)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/by-brand")
    public Response showVendorReportsByBrand(ReportParamVendor reportParamVendor) {

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExcludeFieldsInJSON())
                .serializeNulls() //<-- uncomment to serialize NULL fields as well
                .create();

        Date start = null;
        Date end = null;
        try {
            start = new DateSetter().setDateFormat(reportParamVendor.getStartDate());
            end = new DateSetter().setDateFormat(reportParamVendor.getEndDate());
            List<ReportFormat> brandNames = stockItemUnitService.getReportOfVendorByBrandSupplied(start, end);

            return Response.status(Response.Status.OK).entity(gson.toJson(brandNames)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            // return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(ex.getMessage()),HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/by-vendor-performance")
    public Response showVendorReportsByVendorPerformance(ReportParamVendor param) {
        Date start = null; 
        Date end = null;
        try {           
            start = new DateSetter().setDateFormat(param.getStartDate());
            end = new DateSetter().setDateFormat(param.getEndDate());
           
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExcludeFieldsInJSON())
                    .serializeNulls() //<-- uncomment to serialize NULL fields as well
                    .create();

            List<ReportPattern> performance = stockItemUnitService.getReportOfVendorByPerformance(start,end);

            return Response.status(Response.Status.OK).entity(gson.toJson(performance)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            //return new ResponseEntity<ErrorMessage>(CodeGenerator.generateError(ex.getMessage()),HttpStatus.BAD_REQUEST);
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }

    /**
     * *****************************************************************************
     * THIS IS THE END OF THE SECTION FOR VENDOR REPORTS
     * *******************************************************************************
     */
    
    
    
    
    
    
    
    
    
     /**
     * *****************************************************************************
     * THIS IS THE START OF THE SECTION FOR INVENTORY REPORTS
     * *******************************************************************************
     * @param param
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/item-summary")
    public Response showInventoryReportsByItemName(ParamBuilder param) {
        Date start = null;
        Date end = null;
        String measureType = param.getMeasureType();
	Integer reportType = param.getReportType();
        try {
            
            start = new DateSetter().setDateFormat(param.getStartDate());
            end = new DateSetter().setDateFormat(param.getEndDate());
           
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExcludeFieldsInJSON())
                    .serializeNulls() //<-- uncomment to serialize NULL fields as well
                    .create();

           List<InventoryReportFormat> reports = mainService.processReports(measureType, reportType,start,end);			

            return Response.status(Response.Status.OK).entity(gson.toJson(reports)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/brand-summary")
    public Response showInventoryReportsByBrand(ParamBuilder param) {
        Date start = null;
        Date end = null;
        String measureType = param.getMeasureType();
	Integer reportType = param.getReportType();
        try {
            
            start = new DateSetter().setDateFormat(param.getStartDate());
            end = new DateSetter().setDateFormat(param.getEndDate());
           
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExcludeFieldsInJSON())
                    .serializeNulls() //<-- uncomment to serialize NULL fields as well
                    .create();

           List<InventoryReportFormat> reports = mainService.processReports(measureType, reportType,start,end);			

            return Response.status(Response.Status.OK).entity(gson.toJson(reports)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/warehouse-summary")
    public Response showInventoryReportsByWarehouse(ParamBuilder param) {
        Date start = null;
        Date end = null;
        String measureType = param.getMeasureType();
	Integer reportType = param.getReportType();
        try {
            
            start = new DateSetter().setDateFormat(param.getStartDate());
            end = new DateSetter().setDateFormat(param.getEndDate());
           
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExcludeFieldsInJSON())
                    .serializeNulls() //<-- uncomment to serialize NULL fields as well
                    .create();

           List<InventoryReportFormat> reports = mainService.processReports(measureType, reportType,start,end);			

            return Response.status(Response.Status.OK).entity(gson.toJson(reports)).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }
    }
    

    
     /**
     * *****************************************************************************
     * THIS IS THE END OF THE SECTION FOR INVENTORY REPORTS
     * *******************************************************************************
     */
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("/testWebService")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String testWebService(TestParam testParam) {

        JSONObject obj = new JSONObject();
        obj.put("name", testParam.getName() + " This has been converted by Jersey");
        obj.put("age", testParam.getAge());

        return obj.toString();
        //return "{value: Test Value}";
    }

    /**
     * PUT method for updating or creating an instance of SalesReportREST
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * @return the salesService
     */
    public SalesServiceBean getSalesService() {
        return salesService;
    }

    /**
     * @param salesService the salesService to set
     */
    public void setSalesService(SalesServiceBean salesService) {
        this.salesService = salesService;
    }

    /**
     * @return the stockItemUnitService
     */
    public StockItemUnitService getStockItemUnitService() {
        return stockItemUnitService;
    }

    /**
     * @param stockItemUnitService the stockItemUnitService to set
     */
    public void setStockItemUnitService(StockItemUnitService stockItemUnitService) {
        this.stockItemUnitService = stockItemUnitService;
    }

    public InventoryMainBean getMainService() {
        return mainService;
    }

    public void setMainService(InventoryMainBean mainService) {
        this.mainService = mainService;
    }
    
    
}
