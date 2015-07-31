package ch.opo.opoomcb.core.dao.builder.model.operation.compare.param;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Key;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.CompareOperation;

/**
 * @author Paweł Łabuda
 */
public abstract class CompareColumnAndParam extends CompareOperation
{
   private Column column;

   private Key key;

   public CompareColumnAndParam(Column column, Key key)
   {
      this.column = column;
      this.key = key;
   }

   public Column getColumn()
   {
      return column;
   }

   public Key getKey()
   {
      return key;
   }

   @Override
   public StringBuilder render(StringBuilder builder)
   {

      return builder;
   }
}
