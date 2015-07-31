package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class Less extends CompareTwoColumns
{
   public Less(Column firstColumn, Column secondColumn)
   {
      super(firstColumn, secondColumn);
   }

   @Override
   protected String getComparisonOperation()
   {
      return "<";
   }
}
