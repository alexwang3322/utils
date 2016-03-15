

public class ErrorSnapImpl {

    private static ErrorSnapImpl sErrorSnap;
    
    public static ErrorSnapImpl getInstance(){
	if(sErrorSnap == null) {
  	    sErrorSnap = new ErrorSnapImpl();
	}
	return sErrorSnap;  
    }
 
    public void notify(Throwable t){
    
    }
}
