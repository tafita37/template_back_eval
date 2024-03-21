package eval.mikolo.mikolo.model.exception;

public class CatchingException extends Exception {
    int status;

    public CatchingException(String arg0, int status) {
        super(arg0);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
