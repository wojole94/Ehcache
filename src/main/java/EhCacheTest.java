
import java.util.List;
import java.net.URL;
import java.util.LinkedList;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.*;

public class EhCacheTest {

	
	public void exec() { 
//Konfiguracja programowo		
		CacheConfiguration cacheConfig = 
				new CacheConfiguration()
					.name("cacheStore")
					.maxEntriesLocalHeap(10000)
					.maxEntriesLocalDisk(1000)
					.eternal(false)
					.diskSpoolBufferSizeMB(20)				
					.timeToIdleSeconds(300)
					.timeToLiveSeconds(600)
					.memoryStoreEvictionPolicy("LFU")
					.transactionalMode("off");
		
		Configuration config = 
				new Configuration()
					.cache(cacheConfig);
//-------------------------------------------------------------------		

		
//Konfiguracja z xml'a	
//		final URL config = this.getClass().getResource("ehcache.xml");
//-------------------------------------------------------------------			

		CacheManager manager = new CacheManager(config);
		

		Cache myCache = manager.getCache("cacheStore");
	
//		Element elem1 = new Element(new Long(1), new String("nowy1"));
//		Element elem2 = new Element(new Long(2), new String("nowy2"));
//		Element elem3 = new Element(new Long(8), new String("nowy7"));		
//		
//		myCache.put(elem1);
//		myCache.put(elem2);		

//		myCache.put(elem3);			

		List<Long> list = myCache.getKeys();
		
		for(Long key : list) {
			System.out.println(key.toString());
			System.out.println((String) myCache.get(key).getObjectValue());
		}
		manager.shutdown();
}


}