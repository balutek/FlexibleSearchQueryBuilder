package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.unary;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
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
   public void render(StringBuilder builder)
   {
      column.render(builder);
      builder.append(QueryElements.SPACE)
         .append(getComparisonOperation());
   }
}
