package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.model.Join;
import ch.opo.opoomcb.core.dao.builder.model.On;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class JoinBuilder extends AbstractBuilder<Join>
{
   private OnBuilder onBuilder;

   protected JoinBuilder(LinkedList<AbstractBuilder> previousBuilders)
   {
      super(previousBuilders);

      onBuilder = new OnBuilder(previousBuilders);
   }

   public OnBuilder on()
   {
      On on = new On();
      constructedObject.setOn(on);
      onBuilder.setConstructedObject(on);
      previousBuilders.addFirst(this);
      return onBuilder;
   }

   public JoinBuilder join(String typecode)
   {
      FromBuilder fromBuilder = takePreviousBuilder(FromBuilder.class);
      removeLastUsedBuilder();
      return fromBuilder.join(typecode);
   }

}
