package ch.opo.opoomcb.core.dao.builder.model.operation.compare.param;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Key;

/**
 * @author Paweł Łabuda
 */
public class Contains extends CompareColumnAndParam //todo to remove
{
   public Contains(Column column, Key key)
   {
      super(column, key);
   }

   @Override
   protected String getComparisonOperation()
   {
      return QueryElements.LIKE.toString();
   }
}
