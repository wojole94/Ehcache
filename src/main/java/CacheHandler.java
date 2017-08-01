import java.net.URL;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.*;
import net.sf.ehcache.event.CacheEventListener;

public class CacheHandler {
	private static CacheHandler instance = null;
	private CacheManager manager = null;
	private Cache cache = null;
	private CacheEventListener cacheEventListener;
	
	CacheHandler(){
		
		final URL config = this.getClass().getResource("ehcache.xml");
		manager = new CacheManager(config);
		cache = manager.getCache("cacheStore");	
		cacheEventListener = new MyListener();
		cache.getCacheEventNotificationService().registerListener(cacheEventListener);
		cache.flush();

	}
		
	public Boolean put(String elem) {
		
		Element cacheElement = new Element(new String(elem), new String(elem));
		cache.put(cacheElement);
		cache.flush();
		
		return true;	
	}
	
	public String get(String elem) {
		
		String result = (String) cache.get(elem).getObjectKey();
		return result;
		
	}
	
	public Boolean check(String elem) {
		
		if (cache.isKeyInCache(elem))
			if (cache.get(elem) != null)
				return true;
		
		return false;
	}
	
	public Boolean delete(String elem) {
		
		cache.remove(elem);
		cache.flush();
		return true;
	}
	
	public void setCacheTimeout(Long timeoutInSeconds) {
		
		CacheConfiguration config = cache.getCacheConfiguration();
		config.setTimeToIdleSeconds(timeoutInSeconds);
		config.setTimeToLiveSeconds(timeoutInSeconds);
		
	}
	
	public void setCacheEntitiesCount(Long entitiesCount) {
		
		CacheConfiguration config = cache.getCacheConfiguration();
		config.setMaxEntriesLocalDisk(entitiesCount);		

	}
	
			
	public static CacheHandler getInstance() {
		
		if (instance == null) {
			instance = new CacheHandler();
			return instance;
		}
		
		return instance;
	}
	
	
	@Override	
	protected void finalize() {
		
		manager.shutdown();
	
	}
}
