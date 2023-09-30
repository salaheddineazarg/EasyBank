package INTERFACES;

import DTO.Operation;

import java.util.List;

public interface Ioperation {
    Operation AddOperation(Operation operation);
    int DeleteOperation(String nbOperation);

    List<Operation> SearchOperation(Operation operation);
    List<Operation> SearchByNum(String nbOperation);
}
