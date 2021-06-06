
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


public class FailSafeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> names = new HashMap<Integer,String>();
		names.put(1,"Rama");
		names.put(2,"Rama1");
		names.put(3,"Rama2");
		names.put(4,"Rama3");
		names.put(5,"Rama4");
		try {
			System.out.println("Name in Array");
			Iterator<String>itr = names.values().iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
				System.out.println("Adding elemen  in between iteration");
				names.put(6,"Krishna");
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("Final block");
		}
		//using CopyOnWriteArrayList to avoid concurrentModificationException
		ConcurrentHashMap<Integer,String> names1 = new ConcurrentHashMap<Integer,String>();
		names1.put(1,"Rama");
		names1.put(2,"Rama1");
		names1.put(3,"Rama2");
		names1.put(4,"Rama3");
		names1.put(5,"Rama4");
		try {
			System.out.println("Name1 in CopyOnArrayListArray");
			Iterator<String>itr = names1.values().iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
				System.out.println("Adding elemen  in between iteration");
				names1.put(6,"Krishna");
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("Final block");
		}
	}

}
