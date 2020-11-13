package prime.factors;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;

@Controller("/factorization")
public class FactorizationController {
    private static final Logger log = LoggerFactory.getLogger(FactorizationController.class);

    @Get(uri = "/")
    public HttpResponse health() {
        log.info("Health check");
        return HttpResponse.ok();
    }

    @Get(uri = "/{number}")
    public HttpResponse factorization(@PathVariable String number) {
        log.info(String.format("Calculate factorization of %s", number));
        Long value = Long.valueOf(number);
        Map<String, ArrayList<Long>> factorization = Map.of(number, PrimeFactor.generate(value));
        return HttpResponse.ok(factorization);
    }
}