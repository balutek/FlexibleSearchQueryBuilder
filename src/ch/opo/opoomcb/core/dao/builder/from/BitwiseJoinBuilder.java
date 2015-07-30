package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.And;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.Or;
import ch.opo.opoomcb.core.dao.builder.whereSegment.CompareWhereBuilder;

/**
 * @author Paweł Łabuda
 */
public class BitwiseJoinBuilder
{
   private JoinOnBuilder builder;

   public BitwiseJoinBuilder(JoinOnBuilder builder)
   {
      this.builder = builder;
   }

   public CompareWhereBuilder where()
   {
      return builder.getCompareWhereBuilder();
   }

   public CompareJoinBuilder and()
   {
      builder.insertOperation(new And());
      return builder.getCompareJoinBuilder();
   }

   public CompareJoinBuilder or()
   {
      builder.insertOperation(new Or());
      return builder.getCompareJoinBuilder();
   }

   public BitwiseJoinBuilder closeBracket()
   {
      builder.closeBracket();
      return builder.getBitwiseJoinBuilder();
   }
}