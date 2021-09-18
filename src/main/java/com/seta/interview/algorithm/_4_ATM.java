package com.seta.interview.algorithm;

import com.seta.interview.algorithm.model.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _4_ATM {
    /**
     * @param currentBalance
     * @param withdrawAmount
     * @return expected list note with quantity calculated from withdrawAmount
     */
    public static List<Note> withdrawAmount(List<Note> currentBalance, Integer withdrawAmount) throws Exception {
        if (currentBalance.isEmpty()) {
            return Collections.emptyList();
        }
        List<Note> result = new ArrayList<>();
        Integer remainingAmount = withdrawAmount;
        for (Note processingNote : currentBalance) {
            if (remainingAmount <= 0) {
                break;
            }
            // Divide to get the quantity of current note
            int requiredQuantity = (int) Math.floor(remainingAmount * 1.0 / processingNote.getValue());
            if (requiredQuantity == 0) {
                // The remaining amount is < processing note value
                continue;
            }
            int quantityToPut = requiredQuantity < processingNote.getQuantity() ? requiredQuantity : processingNote.getQuantity();
            result.add(Note.of(processingNote.getValue(), quantityToPut));
            remainingAmount -= processingNote.getValue() * quantityToPut;
        }
        // Find the minimum value of note for checking valid withdrawAmount
        Note minNote = currentBalance.stream().min(Comparator.comparing(Note::getValue)).get();
        // Check remaining amount after processing all notes
        if (remainingAmount <= 0) {
            return result;
        } else if (remainingAmount < minNote.getValue()) {
            throw new IllegalArgumentException("Not a valid amount");
        } else {
            throw new Exception("Amount not available in ATM");
        }
    }
}
