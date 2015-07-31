package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.model.Renderable;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public abstract class AbstractBuilder<CONSTRUCTEDOBJECT extends Renderable>
{
   protected CONSTRUCTEDOBJECT constructedObject;

   protected LinkedList<AbstractBuilder> previousBuilders;

   protected AbstractBuilder(LinkedList<AbstractBuilder> previousBuilders)
   {
      this.previousBuilders = previousBuilders;
   }

   public void setConstructedObject(CONSTRUCTEDOBJECT constructedObject)
   {
      this.constructedObject = constructedObject;
   }

   protected <T extends AbstractBuilder> T takePreviousBuilder(Class<T> requestedBuilderClass)
   {
      for (AbstractBuilder previousBuilder : previousBuilders)
      {
         if (requestedBuilderClass.isInstance(previousBuilder))
         {
            return requestedBuilderClass.cast(previousBuilder);
         }
      }
      return null;
   }

}
