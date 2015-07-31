package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.unary;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class IsNull extends CompareOneColumn
{
   public IsNull(Column column)
   {
      super(column);
   }

   @Override
   protected String getComparisonOperation()
   {
      return QueryElements.IS_NULL.toString();
   }
}
