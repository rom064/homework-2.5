package pro.sky.homework_2_5.homework_2_5.exception;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String message) {
        super(message);
    }
}
