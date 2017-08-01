

import java.net.URL;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CacheHandler handle = CacheHandler.getInstance();
//		handle.put("1232131241222");
//		handle.put("33s39s33s93d3");
//		handle.put("12321312423w2");
//		handle.put("33s39s33s9213");
		
//		handle.getAll();
		
		
//		if(handle.check("123213124"))
//		System.out.println(handle.get("123213124"));
//		else 
//			System.out.println("nie ma");
	
		
		
		
		if(handle.check("33s39s33s9213")) {
		System.out.println("jest");

		}
		else {
			System.out.println("nie ma");
		}

//		handle.setTimeout(new Long(15));
		// 	System.out.println(handle.get("12321312423w2"));
		
		handle.finalize();
		
	}

}
