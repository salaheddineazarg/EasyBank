package DAO;

import DTO.Operation;
import INTERFACES.Ioperation;

import java.util.List;

public class OperationD implements Ioperation {
    @Override
    public Operation AddOperation(Operation operation) {
        return null;
    }

    @Override
    public int DeleteOperation(String nbOperation) {
        return 0;
    }

    @Override
    public List<Operation> SearchOperation(Operation operation) {
        return null;
    }

    @Override
    public List<Operation> SearchByNum(String nbOperation) {
        return null;
    }
}
