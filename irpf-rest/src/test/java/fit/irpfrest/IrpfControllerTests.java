package fit.irpfrest;

import fit.irpfrest.view.PersonVm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IrpfControllerTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testCreatePerson() {
        var p = new PersonVm(3500, 2);
        ResponseEntity<PersonVm> respEntity = restTemplate.postForEntity("/irpf/person", p, PersonVm.class);

        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        var personResponse = respEntity.getBody();

        Assertions.assertNotNull(personResponse);
        assertThat(personResponse.getTotalSalary()).isEqualTo(p.getTotalSalary());
        assertThat(personResponse.getDependentsNumber()).isEqualTo(p.getDependentsNumber());
    }

    @Test
    void testShouldCalculateIrpfWithoutDependents() {
        double expectedResult = 181.65;
        var p = new PersonVm(3500, 0);
        ResponseEntity<Double> respEntity = restTemplate.postForEntity("/irpf/calculate", p, Double.class);

        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        var value = respEntity.getBody();

        Assertions.assertNotNull(value);
        assertThat(value).isEqualTo(expectedResult);
    }

    @Test
    void testShouldCalculateIrpfWithDependents() {
        double expectedResult = 62.39;
        var p = new PersonVm(3500, 2);
        ResponseEntity<Double> respEntity = restTemplate.postForEntity("/irpf/calculate", p, Double.class);

        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        var value = respEntity.getBody();

        Assertions.assertNotNull(value);
        assertThat(value).isEqualTo(expectedResult);
    }
}
