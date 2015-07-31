package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.model.On;

import java.util.LinkedList;

/**
 * @author Paweł Łabuda
 */
public class OnBuilder extends AbstractBuilder<On>
{
   protected OnBuilder(LinkedList<AbstractBuilder> previousBuilders)
   {
      super(previousBuilders);
   }

   public String build()
   {
      Query query = takePreviousBuilder(Query.class);
      return query.build();
   }

}
