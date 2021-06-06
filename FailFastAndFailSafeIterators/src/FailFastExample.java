import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
	names.add("Rama");
	names.add("Rama1");
	names.add("Rama2");
	names.add("Rama3");
	names.add("Rama4");
	try {
		System.out.println("Name in Array");
		Iterator<String>itr = names.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			System.out.println("Adding elemen  in between iteration");
			names.add("Krishna");
		}
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		System.out.println("Final block");
	}
	//using CopyOnWriteArrayList to avoid concurrentModificationException
	CopyOnWriteArrayList<String> names1 = new CopyOnWriteArrayList<String>();
	names1.add("Rama");
	names1.add("Rama1");
	names1.add("Rama2");
	names1.add("Rama3");
	names1.add("Rama4");
	try {
		System.out.println("Name1 in CopyOnArrayListArray");
		Iterator<String>itr = names.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			System.out.println("Adding elemen  in between iteration");
			names.add("Krishna");
		}
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		System.out.println("Final block");
	}
	}

}
