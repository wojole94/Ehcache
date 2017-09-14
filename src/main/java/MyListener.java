import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class MyListener implements CacheEventListener {

	public void dispose() {
		System.out.println("|============ dispose ==========|");
		
	}

	public void notifyElementEvicted(Ehcache arg0, Element arg1) {
		System.out.println("|============ element evicted: "+ arg1.getObjectKey() + "," + arg1.getObjectValue() + "==========|");
	}

	public void notifyElementExpired(Ehcache arg0, Element arg1) {
		System.out.println("|============ element expired: "+ arg1.getObjectKey() + "," + arg1.getObjectValue() + "==========|");
		// TODO Auto-generated method stub
		
	}

	public void notifyElementPut(Ehcache arg0, Element arg1) throws CacheException {
		System.out.println("|============ element putted: "+ arg1.getObjectKey() + "," + arg1.getObjectValue() + "==========|");
		// TODO Auto-generated method stub
		
	}

	public void notifyElementRemoved(Ehcache arg0, Element arg1) throws CacheException {
		System.out.println("|============ element removed:"+ arg1.getObjectKey() + "," + arg1.getObjectValue() + "==========|");
		// TODO Auto-generated method stub
		
	}

	public void notifyElementUpdated(Ehcache arg0, Element arg1) throws CacheException {
		System.out.println("|============ element updated:"+ arg1.getObjectKey() + "," + arg1.getObjectValue() + "==========|");
		// TODO Auto-generated method stub
		
	}

	public void notifyRemoveAll(Ehcache arg0) {
		System.out.println("|============ cache deleted :"+ arg0.getName() + "==========|");
		// TODO Auto-generated method stub
		
	}
	
	public Object clone() {
		return null;
		
	}
	
}
