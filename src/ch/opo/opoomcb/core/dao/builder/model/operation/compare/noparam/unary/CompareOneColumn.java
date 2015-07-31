package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.unary;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.CompareOperation;

/**
 * @author Paweł Łabuda
 */
public abstract class CompareOneColumn extends CompareOperation
{
   private Column column;

   public CompareOneColumn(Column column)
   {
      super();

      this.column = column;
   }

   public Column getColumn()
   {
      return column;
   }

   @Override
   public StringBuilder render(StringBuilder builder)
   {

      return builder;
   }
}
