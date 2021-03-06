package ch.opo.opoomcb.core.dao.builder.model.operation.compare.param;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Key;

/**
 * @author Paweł Łabuda
 */
public class LessOrEqualsParam extends CompareColumnAndParam
{
   public LessOrEqualsParam(Column column, Key key)
   {
      super(column, key);
   }

   @Override
   protected String getComparisonOperation()
   {
      return "<=";
   }
}
