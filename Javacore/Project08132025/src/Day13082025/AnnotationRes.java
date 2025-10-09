package Day13082025;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;

public class AnnotationRes {
	
	public static void main(String[] args) throws Exception {
		Class c = Resource.class;
		Bean bean = (Bean) c.getDeclaredAnnotation(Bean.class);
		System.out.println(bean.value());
		Annotation a[]=c.getDeclaredAnnotations();
		for(Annotation x:a) {
			System.out.println(x);
		}
		System.out.println();
		Resource resource = (Resource) Class.forName(bean.value()).getConstructor().newInstance();
		System.out.println(resource);
		
		c = resource.getClass();
		Field f = c.getDeclaredField("name");
		f.setAccessible(true);

		Prop prop = (Prop) f.getAnnotation(Prop.class);
		System.out.println(prop.value());
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface abc {
	String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Bean {
	String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Prop {
	String value();
}

@abc(value = "rishjk")
@Bean(value = "Day13082025.DBResource")
abstract class Resource {

}

class DBResource extends Resource {
	@Prop(value = "hello world")
	String name;

	public DBResource() {
		// TODO Auto-generated constructor stub
	}
}

class NetworkResource extends Resource {
	public NetworkResource() {
		// TODO Auto-generated constructor stub
	}
}