import java.util.Set;

public abstract class SimpleEntityLocator implements EntityLocator {
	 private Set<EntityDef> entityDefs = new HashSet<EntityDef>();

	   public AbstractEntityLocator(Set<String> packageNames){
	      ClassNameLocator locator = new ClassNameLocatorImpl(new ClasspathURLConverterImpl());
	      for(String packageName: packageNames){
	         for(String className: locator.locateClassNames(packageName)){
	            try {
	               final Class<?> entityClass = Class.forName(className);
	               if(isEntity(entityClass)){
	                  entityDefs.add(new EntityDef(){

	                     public String getServiceId() {
	                        return entityClass.getSimpleName() + "DAO";
	                     }

	                     public Class<?> getType() {
	                        return entityClass;
	                     }

	                     @Override
	                     public String toString(){
	                        return "Entity Definition for " + getServiceId();
	                     }

	                  });
	               }
	            } catch (ClassNotFoundException e) {
	               throw new RuntimeException(e);
	            }
	         }
	      }
	   }

	   public boolean isEntity(Class<?> entityClass){
	      return entityClass.getAnnotation(javax.persistence.Entity.class) != null ||
	         entityClass.getAnnotation(javax.persistence.MappedSuperClass.class) != null;
	   }

	   public Set<EntityDef> getEntityDefs() {
	      return entityDefs;
	   }
	}
}
