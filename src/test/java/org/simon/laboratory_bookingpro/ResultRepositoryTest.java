package org.simon.laboratory_bookingpro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.simon.laboratory_bookingpro.dto.Result;
import org.simon.laboratory_bookingpro.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ResultRepositoryTest {

    @Autowired
    private ResultRepository resultRepository;

    @Test
    public void testFindByUserId() {
        // Save results to the repository
        Result result1 = new Result();
        result1.setId(1L);
        resultRepository.save(result1);

        Result result2 = new Result();
        result2.setId(2L);
        resultRepository.save(result2);

        // Retrieve results by user ID
        List<Result> results = resultRepository.findAllById(1L);

        // Assert that the correct results were found
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).getId()).isEqualTo(1L);
    }
}
