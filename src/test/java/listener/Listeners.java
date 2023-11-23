package listener;


import bases.BaseTest;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class Listeners extends BaseTest implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification,
                           FilterableResponseSpecification filterableResponseSpecification,
                           FilterContext filterContext) {
      Response response = filterContext.next(filterableRequestSpecification,
                                             filterableResponseSpecification);
      loger.info("\n Request Method : "+ filterableRequestSpecification.getMethod());
        loger.info("\n Request URI : "+ filterableRequestSpecification.getURI());
        loger.info("\n Request Body : "+ filterableRequestSpecification.getBody());
        loger.info("\n Response Body : "+ response.getBody().prettyPrint());
        return response;

    }
}
