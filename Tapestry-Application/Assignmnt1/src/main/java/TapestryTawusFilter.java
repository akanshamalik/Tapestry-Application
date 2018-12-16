
public class TapestryTawusFilter extends TapestryFilter {
	private static final String MODEL_PACKAGES = "tawus-model-packages";

	   @Override
	   protected ModuleDef [] provideExtraModuleDefs(ServletContext context){
	      String packages = context.getInitParameter(MODEL_PACKAGES);
	      if(packages == null){
	         return new ModuleDef[]{};
	      }

	      EntityLocator entityLocator = new AbstractEntityLocator(CollectionFactory.newSet(
	            TapestryInternalUtils.splitAtCommas(packages))){
	         @SuppressWarnings("unchecked")
	         public boolean isEntity(@SuppressWarnings("rawtypes") Class entityType){
	            return entityType.getAnnotation(Entity.class) != null;
	         }
	      };

	      return new ModuleDef[]{ new EntityModuleDef(entityLocator)};
	   }
}
