package prime.factors;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller("/factorization")
public class FactorizationController {

    @Get(uri = "/")
    public HttpResponse health() {
        return HttpResponse.ok();
    }

    @Get(uri = "/{number}")
    public HttpResponse factorization(@PathVariable String number) {
        Long value = Long.valueOf(number);
        return HttpResponse.ok(PrimeFactor.generate(value));
    }
}