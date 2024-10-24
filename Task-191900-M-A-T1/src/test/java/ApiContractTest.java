import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApiContractTest {

    private Swagger swaggerSpec;

    @BeforeEach
    void setUp() throws IOException {
        // Load the OpenAPI specification from a file or resource
        String specUrl = "path/to/your/openapi.yaml";
        swaggerSpec = new SwaggerParser().read(specUrl);
    }

    @Test
    void validateGetUsersContract() {
        String usersEndpoint = "/users";
        HttpMethod httpMethod = HttpMethod.GET;

        // Validate the endpoint
        Path path = swaggerSpec.getPath(usersEndpoint);
        assertNotNull(path, "Endpoint not found");

        // Validate the GET operation
        Operation operation = path.getGet(); // Use getGet() for GET requests
        assertNotNull(operation, "GET operation not found");

        // Validate the response for HTTP 200
        io.swagger.models.Response response = operation.getResponses().get("200");
        assertNotNull(response, "200 response not found");

        // Use the updated way to access the schema's reference
//        String responseModelName = response.getSchema().get$ref(); // Check for updated method
//        assertEquals("#/definitions/UserList", responseModelName, "Response model mismatch");
//
}

}