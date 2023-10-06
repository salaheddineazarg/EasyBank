package interfaces;

import dto.Operation;

import java.time.LocalDate;
import java.util.Optional;

public interface iOperation {
    Optional<Operation> AddOperation(Operation operation);
    int DeleteOperation(int nbOperation);

    Optional<Operation> SearchByDate(LocalDate date);
    Optional<Operation> SearchByNum(int nbOperation);
}
