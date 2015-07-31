package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.model.From;
import ch.opo.opoomcb.core.dao.builder.model.Join;
import ch.opo.opoomcb.core.dao.builder.model.Table;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class FromBuilder extends AbstractBuilder<From>
{
   private JoinBuilder joinBuilder;

   protected FromBuilder(LinkedList<AbstractBuilder> previousBuilders)
   {
      super(previousBuilders);
   }

   public JoinBuilder join(String typecode)
   {
      Join join = new Join(new Table(typecode));
      constructedObject.addJoin(join);
      joinBuilder = new JoinBuilder(previousBuilders);
      previousBuilders.addFirst(this);
      joinBuilder.setConstructedObject(join);
      return joinBuilder;
   }

   public JoinBuilder join(String alias, String typecode)
   {
      Join join = new Join(new Table(typecode, alias));
      constructedObject.addJoin(join);
      joinBuilder = new JoinBuilder(previousBuilders);
      previousBuilders.addFirst(this);
      joinBuilder.setConstructedObject(join);
      return joinBuilder;
   }

}
