package shared;


public class Result<V> {
    private final V value;
    private final String error;

    private Result(V value, String error) {
        this.value = value;
        this.error = error;
    }
    
    public static <V> Result ok(V value){
        return new Result<>(value, null);
    }
    
    public static <V> Result<V> error(String error){
        return new Result<>(null, error);
    }
    
    public boolean isOk(){
        return error == null;
    }

    public V getValue() {
        return value;
    }

    public String getError() {
        return error;
    }
    
    
}
