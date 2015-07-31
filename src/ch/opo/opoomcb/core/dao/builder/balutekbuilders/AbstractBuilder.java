package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.model.Renderable;

/**
 * @author Paweł Łabuda
 */
public abstract class AbstractBuilder<CONSTRUCTEDOBJECT extends Renderable, PREVIOUSBUILDER extends AbstractBuilder>
{
   protected CONSTRUCTEDOBJECT constructedObject;

   protected PREVIOUSBUILDER previousBuilder;

   protected AbstractBuilder(CONSTRUCTEDOBJECT constructedObject, PREVIOUSBUILDER previousBuilder)
   {
      this.constructedObject = constructedObject;
      this.previousBuilder = previousBuilder;
   }

}
