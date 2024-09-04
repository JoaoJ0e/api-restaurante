package api_restaurante.exceptions;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException() {
        super();
    }

    public IdNotFoundException(String mensagem) {
        super(mensagem);
    }
}
