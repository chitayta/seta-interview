package com.seta.interview;

import com.seta.interview.algorithm.model.Note;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.seta.interview.algorithm._4_ATM.withdrawAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class _4_ATMTest {

    @Test
    void testATMWithdraw() throws Exception {
        // Given
        List<Note> currentBalance = Arrays.asList(
                Note.of(2000, 5),
                Note.of(500, 10),
                Note.of(200, 10),
                Note.of(100, 10)
        );

        // Then
        // Withdraw 2000 returns (2000, 1)
        assertThat(withdrawAmount(currentBalance, 2000))
                .usingComparatorForType(Comparator.comparing(Note::getQuantity).thenComparing(Note::getValue), Note.class)
                .containsExactly(Note.of(2000, 1));

        // Withdraw 1600 returns (500, 3), (100, 1)
        assertThat(withdrawAmount(currentBalance, 1600))
                .usingComparatorForType(Comparator.comparing(Note::getQuantity).thenComparing(Note::getValue), Note.class)
                .containsExactly(
                        Note.of(500, 3),
                        Note.of(100, 1)
                );

        // Withdraw 2600 returns (2000, 1), (500, 1) and (100, 1)
        assertThat(withdrawAmount(currentBalance, 2600))
                .usingComparatorForType(Comparator.comparing(Note::getQuantity).thenComparing(Note::getValue), Note.class)
                .containsExactly(
                        Note.of(2000, 1),
                        Note.of(500, 1),
                        Note.of(100, 1)
                );
        // Withdraw 6000 returns (2000, 3)
        assertThat(withdrawAmount(currentBalance, 6000))
                .usingComparatorForType(Comparator.comparing(Note::getQuantity).thenComparing(Note::getValue), Note.class)
                .containsExactly(Note.of(2000, 3));

        // Withdraw 1650 throws "Not a valid amount"
        assertThat(catchThrowable(() -> withdrawAmount(currentBalance, 1650)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not a valid amount");

        // Withdraw 32000 throws "Amount not available in ATM"
        assertThat(catchThrowable(() -> withdrawAmount(currentBalance, 32000)))
                .isInstanceOf(Exception.class)
                .hasMessage("Amount not available in ATM");
    }

}
