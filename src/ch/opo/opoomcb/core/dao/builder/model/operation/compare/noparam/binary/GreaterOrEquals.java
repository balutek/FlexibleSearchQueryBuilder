package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class GreaterOrEquals extends CompareTwoColumns
{
   public GreaterOrEquals(Column firstColumn, Column secondColumn)
   {
      super(firstColumn, secondColumn);
   }

   @Override
   protected String getComparisonOperation()
   {
      return ">=";
   }
}
